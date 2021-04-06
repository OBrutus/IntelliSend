package com.obrutus.intellisend;

public enum ImageFormat {
	PNG("png"),
	JPG("jpg"),
	JPEG("jpeg");
    
	public final String label;
	
    private ImageFormat(String label) {
        this.label = label;
    }
}
