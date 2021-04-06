package com.obrutus.intellisend;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Image {
	private BufferedImage bImage;
	private ImageFormat format;
	public Image(File imageFile) throws IOException {
		bImage = ImageIO.read(imageFile);
		this.format = ImageFormat.PNG;
	}

	public byte[] getText() throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, format.label, bos );
		byte[] data = bos.toByteArray();
		// System.out.println("byteArray : "+ Arrays.toString(data)+"\n Len: "+data.length);
		// analysis(data);
		return data;
	}

	private void analysis(byte[] data) {
		HashMap<Byte, Integer> map = new HashMap<>();
		for (byte b : data) {
			map.putIfAbsent(b, 0);
			map.replace(b, map.get(b)+1);
		}
		// send this map to python code in res/
	}

	public void createImage(byte[] data, String fileName) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		BufferedImage bImage = ImageIO.read(bis);
		ImageIO.write(bImage, format.label, new File(fileName));
		System.out.println("image created");
	}
}
