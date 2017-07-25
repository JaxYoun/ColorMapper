package com.example.demo.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

public class ValidateCodeUtil {
	// 图片的宽度。
	private static int width = 160;
	// 图片的高度。
	private static int height = 40;
	// 验证码字符个数
	private static int codeCount = 5;
	// 验证码干扰线数
	private static int lineCount = 80;
	// 验证码
	private static String code = null;
	// 验证码图片Buffer
	private static BufferedImage bufferedImage = null;
	// 随机字符序列
	final static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	public static void getDefaultValidateCode() {
		createCode();
	}

	public static void getFixedSizeValidateCode(int width, int height) {
		ValidateCodeUtil.width = width;
		ValidateCodeUtil.height = height;
		createCode();
	}

	public static void getFixedSizeAndComplicationValidateCode(int width, int height, int codeCount, int lineCount) {
		ValidateCodeUtil.width = width;
		ValidateCodeUtil.height = height;
		ValidateCodeUtil.codeCount = codeCount;
		ValidateCodeUtil.lineCount = lineCount;
		createCode();
	}

	// 生成验证码
	public static void createCode() {
		int x;
		int fontHeight;
		int codeY = 0;
		int red = 0;
		int green = 0;
		int blue = 0;

		x = width / (codeCount + 2);// 每个字符的宽度
		fontHeight = height - 2;// 字体的高度
		codeY = height - 4;

		// 图像buffer
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = bufferedImage.createGraphics();
		// 生成随机数
		Random random = new Random();
		// 将图像填充为白色
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);

		// 创建字体
		Font font = new Font("宋体", Font.BOLD, 20);
		graphics.setFont(font);

		int inde = 0;
		while (inde < lineCount) {
			int xs = random.nextInt(width);
			int ys = random.nextInt(height);
			int xe = xs + random.nextInt(width / 8);
			int ye = ys + random.nextInt(height / 8);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			graphics.setColor(new Color(red, green, blue));
			graphics.drawLine(xs, ys, xe, ye);
			inde++;
		}

		// randomCode记录随机产生的验证码
		StringBuffer randomCode = new StringBuffer();

		// 随机产生codeCount个字符的验证码。
		int idx = 0;
		while (idx < codeCount) {
			String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
			// 产生随机的颜色值，让输出的每个字符的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			graphics.setColor(new Color(red, green, blue));
			graphics.drawString(strRand, (idx + 1) * x, codeY);
			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
			idx++;
		}
		// 将四位数字的验证码保存到Session中。
		code = randomCode.toString();
	}

	public static void write(String path) throws IOException {
		OutputStream outputStream = new FileOutputStream(path);
		write(outputStream);
	}

	public static void write(OutputStream outputStream) throws IOException {
		ImageIO.write(bufferedImage, "png", outputStream);
		outputStream.close();
	}

	public static BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public static String getCode() {
		return code;
	}
}
