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
	
	private int imgWidth = 100;  // 定义图片的width
	private int imgHeight = 40;  // 定义图片的height
	private int codeCount = 4;   // 定义图片上显示验证码的个数
	private int fontWidth = 20;
	private int fontSize = 24;
	private int codeY = 30;

	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
			'K', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z',  '2', '3', '4', '5', '6', '7', '8', '9' };

	@RequestMapping("/verification_code")
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		log.debug("verification_code");
		
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
		// Graphics2D gd = buffImg.createGraphics();
		// Graphics2D gd = (Graphics2D) buffImg.getGraphics();
		Graphics gd = buffImg.getGraphics();
		// 创建一个随机数生成器类
		Random random = new Random();
		// 填充背景色
		gd.setColor(new Color(0xcee1ef));
		gd.fillRect(0, 0, imgWidth, imgHeight);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Fixedsys", Font.BOLD, fontSize);
		// 设置字体。
		gd.setFont(font);

		// 画边框。
		gd.setColor(new Color(0xdcdcdc));
		gd.drawRect(0, 0, imgWidth - 1, imgHeight - 1);

		// 随机产生干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(new Color(0x3c5361));
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(imgWidth);
			int y = random.nextInt(imgHeight);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			gd.drawLine(x, y, x + xl, y + yl);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		//int red = 9, green = 95, blue = 167;
		gd.setColor(new Color(9, 95, 167));

		// 随机产生codeCount数字的验证码。
		for (int i = 0, x = 10; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			//red = random.nextInt(255);
			//green = random.nextInt(255);
			//blue = random.nextInt(255);

			// 用随机产生的颜色将验证码绘制到图像中。
			//gd.setColor(new Color(red, green, blue));
			gd.drawString(code, x, codeY);
			x += fontWidth;

			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
		// 将四位数字的验证码保存到Session中。
		HttpSession session = request.getSession();
		session.setAttribute(KEY, randomCode.toString().toLowerCase());

		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
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
		// 60秒内只发送一次
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

