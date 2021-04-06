package com.obrutus.intellisend;

import java.io.File;
import java.io.IOException;


public final class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = args[0];
		Image img = new Image(new File(filePath));
		byte[] data = img.getText();
		img.createImage(data, "res/output.png");
	}

}
