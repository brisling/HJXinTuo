package com.hjxintuo.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RandomCodeController  {
	private Logger log = Logger.getLogger(RandomCodeController.class);
	private final String KEY = "verificationCode";
	private final String SMS_KEY = "SMSCode";
	private final String SMS_TIMESTAMP = "SMSCodeTimestamp";
	
	private int imgWidth = 100;  // ����ͼƬ��width
	private int imgHeight = 40;  // ����ͼƬ��height
	private int codeCount = 4;   // ����ͼƬ����ʾ��֤��ĸ���
	private int fontWidth = 20;
	private int fontSize = 24;
	private int codeY = 30;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			'K', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z',  '2', '3', '4', '5', '6', '7', '8', '9' };

	@RequestMapping("/verification_code")
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		log.debug("verification_code");
		
		// ����ͼ��buffer
		BufferedImage buffImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		// Graphics2D gd = buffImg.createGraphics();
		// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// ����һ���������������
		Random random = new Random();
		// ��䱳��ɫ
		gd.setColor(new Color(0xcee1ef));
		gd.fillRect(0, 0, imgWidth, imgHeight);

		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Fixedsys", Font.BOLD, fontSize);
		// �������塣
		gd.setFont(font);

		// ���߿�
		gd.setColor(new Color(0xdcdcdc));
		gd.drawRect(0, 0, imgWidth - 1, imgHeight - 1);

		// ������������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
		gd.setColor(new Color(0x3c5361));
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(imgWidth);
			int y = random.nextInt(imgHeight);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		//int red = 9, green = 95, blue = 167;
		gd.setColor(new Color(9, 95, 167));

		// �������codeCount���ֵ���֤�롣
		for (int i = 0, x = 10; i < codeCount; i++) {
			// �õ������������֤�����֡�
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			//red = random.nextInt(255);
			//green = random.nextInt(255);
			//blue = random.nextInt(255);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			//gd.setColor(new Color(red, green, blue));
			gd.drawString(code, x, codeY);
			x += fontWidth;

			// ���������ĸ�����������һ��
			randomCode.append(code);
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = request.getSession();
		session.setAttribute(KEY, randomCode.toString().toLowerCase());

		// ��ֹͼ�񻺴档
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// ��ͼ�������Servlet������С�
		ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			ImageIO.write(buffImg, "jpeg", sos);
		} catch (Exception e) {

		} finally {
			try {
				if (sos != null) {
					sos.close();
				}
			} catch (Exception e) {
				// nothing to do
			}
		}
	}
	
	@RequestMapping("/verify_code")
	@ResponseBody
	public String verifyCode(String verifyCode, HttpSession session) {
		log.debug("/verify_code: " + verifyCode);
		
		String correctCode = (String)session.getAttribute(KEY);
		if (correctCode == null) {
			return "false";
		}
		
		if (verifyCode.equals(correctCode)) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
	@RequestMapping("/SMSCode")
	@ResponseBody
	public void SMSCode(HttpSession session) {
		log.info("SMS code");
		String timestamp = (String)session.getAttribute(SMS_TIMESTAMP);
		long current= new Date().getTime(); 
		// 60����ֻ����һ��
		if (timestamp != null) {
			if (current - Long.valueOf(timestamp) < 60000) {
				return;
			}
		}
		
		// generate SMS code
		Random random = new Random();
		int i1 = random.nextInt(9);
		int i2 = random.nextInt(9);
		int i3 = random.nextInt(9);
		int i4 = random.nextInt(9);
		String code = String.format("%d%d%d%d", i1, i2, i3, i4);
		
		// send to phone
		// ...
		log.info("code: " + code);
		session.setAttribute(SMS_KEY, code);
		log.info("timestamp: " + Long.toString(current));
		session.setAttribute(SMS_TIMESTAMP, Long.toString(current));
	}
}

