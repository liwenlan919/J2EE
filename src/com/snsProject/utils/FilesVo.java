package com.snsProject.utils;

import java.io.File;


public class FilesVo {
	
 	private File myFile;
    private String contentType;
    private String fileName;
    private String imageFileName;
    private String caption;
	
    public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getMyFileContentType() {
		return contentType;
	}
	public void setMyFileContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getMyFileFileName() {
		return fileName;
	}
	public void setMyFileFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
}
