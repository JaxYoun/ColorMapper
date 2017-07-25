package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

@RestController
@RequestMapping(value = "/QRCode")
public class QRCodeController {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private static final int WIDTH = 167;
	private static final int HEIGHT = 167;
	private static String FORMAT = "gif";

	private static final Logger logger = Logger.getLogger(ColorMapController.class);
	private static final ObjectMapper jacksonMapper = new ObjectMapper();

	@PostMapping(value = "/getQRCode")
	public void getQRCode(HttpServletRequest request, HttpServletResponse response, String originCode, String destPath) throws Exception {
		response.setContentType("image/png");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		String format = "gif";
		writeToStream(originCode, format, response.getOutputStream());
		writeToFile(originCode, format, destPath);
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static void writeToFile(String str, String format, String filePath) throws Exception {
		// 二维码的图片格式
		if (StringUtils.isNotEmpty(format)) {
			FORMAT = format;
		}
		Hashtable hints = new Hashtable();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
		BufferedImage image = toBufferedImage(bitMatrix);
		if (!ImageIO.write(image, FORMAT, new File(filePath))) {
			throw new IOException("Could not write an image of format " + format + " to " + filePath);
		}
	}

	public static void writeToStream(String str, String format, OutputStream stream) throws Exception {
		// 二维码的图片格式
		Hashtable hints = new Hashtable();
		if (StringUtils.isNotEmpty(format)) {
			FORMAT = format;
		}
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
		BufferedImage image = toBufferedImage(bitMatrix);
		if (!ImageIO.write(image, FORMAT, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

}
