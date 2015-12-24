package com.google.zxing.client.j2se;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;
import org.apache.commons.io.FileUtils;

/**
 * 带logo的二维码
 */
public class MatrixToImageWriterEx {
	private MatrixToImageWriterEx() {
	}

	public static BufferedImage write2File(BitMatrix matrix, String format,
			String imageSavePath, MatrixToImageConfig config)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix, config);
		if (!ImageIO.write(image, format, new File(imageSavePath))) {
			throw new IOException((new StringBuilder(
					"Could not write an image of format ")).append(format)
					.append(" to ").append(imageSavePath).toString());
		} else {
			return image;
		}
	}

	public static void overlapImage(BufferedImage image, String imgSavePath,
			File logoPath, String formate,int logoCent) {
		try {
			if(logoPath != null && logoPath.exists()){
				Graphics2D g = image.createGraphics();
				BufferedImage logo = ImageIO.read(logoPath);
				int width = image.getWidth() / logoCent;
				int height = image.getHeight() / logoCent;
				int x = (image.getWidth() - width) / 2;
				int y = (image.getHeight() - height) / 2;
				g.drawImage(logo, x, y, width, height, null);
				g.dispose();
			}
			ImageIO.write(image, formate, new File(imgSavePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		return toBufferedImage(matrix, DEFAULT_CONFIG);
	}

	public static BufferedImage toBufferedImage(BitMatrix matrix,
			MatrixToImageConfig config) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				config.getBufferedImageColorModel());
		int onColor = config.getPixelOnColor();
		int offColor = config.getPixelOffColor();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? onColor : offColor);
			}
		}
		return image;
	}

	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		writeToFile(matrix, format, file, DEFAULT_CONFIG);
	}

	public static void writeToFile(BitMatrix matrix, String format, File file,
			MatrixToImageConfig config) throws IOException {
		BufferedImage image = toBufferedImage(matrix, config);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException((new StringBuilder(
					"Could not write an image of format ")).append(format)
					.append(" to ").append(file).toString());
		}
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream) throws IOException {
		writeToStream(matrix, format, stream, DEFAULT_CONFIG);
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream, MatrixToImageConfig config) throws IOException {
		BufferedImage image = toBufferedImage(matrix, config);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException((new StringBuilder(
					"Could not write an image of format ")).append(format)
					.toString());
		}
	}

	private static final MatrixToImageConfig DEFAULT_CONFIG = new MatrixToImageConfig();
}
