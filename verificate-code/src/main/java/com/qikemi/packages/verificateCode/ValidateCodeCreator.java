package com.qikemi.packages.verificateCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import com.qikemi.packages.verificateCode.bean.ValidateCode;

/**
 * Validate Code Creator
 * 
 * Create Date: 2014年10月5日 下午3:01:58 Author XieXianbin<a.b@hotmail.com> Source
 * Repositories Address: <https://github.com/qikemi/verificate-code>
 */
public class ValidateCodeCreator {

	// 验证码buffImg
	private BufferedImage buffImg = null;

	public void createCode(ValidateCode validateCode) {

		int x = 0, fontHeight = 0, codeY = 0;
		int red = 0, green = 0, blue = 0;
		// 每个字符的宽度
		x = validateCode.getWidth() / (validateCode.getCodeCount() + 2);
		// 字体的高度
		fontHeight = validateCode.getHeight() - 2;
		codeY = validateCode.getHeight() - 4;

		// 图像buffer
		buffImg = new BufferedImage(validateCode.getWidth(),
				validateCode.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// 生成随机数
		Random random = new Random();
		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, validateCode.getWidth(), validateCode.getHeight());

		// 创建字体
		ImgFontByte imgFont = new ImgFontByte();
		Font font = imgFont.getFont(fontHeight);
		g.setFont(font);

		for (int i = 0; i < validateCode.getLineCount(); i++) {
			int xs = random.nextInt(validateCode.getWidth());
			int ys = random.nextInt(validateCode.getHeight());
			int xe = xs + random.nextInt(validateCode.getWidth() / 8);
			int ye = ys + random.nextInt(validateCode.getHeight() / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawLine(xs, ys, xe, ye);
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount个字符的验证码
		for (int i = 0; i < validateCode.getCodeCount(); i++) {
			String strRand = String
					.valueOf(validateCode.getCodeSequence()[random
							.nextInt(validateCode.getCodeSequence().length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * x, codeY);
			// 将产生的四个随机数组合在一起
			randomCode.append(strRand);
		}
		// 验证码
		validateCode.setCode(randomCode.toString());
	}

	public void write(String path) throws IOException {
		OutputStream outputStream = new FileOutputStream(path);
		this.write(outputStream);
	}

	public void write(OutputStream outputStream) throws IOException {
		ImageIO.write(buffImg, "png", outputStream);
		outputStream.close();
	}

}
