package com.snsProject.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class UploadUtils {
	
	/**
	 * 上传
	 * @param fileName
	 * @param dir
	 * @param stream
	 * @param uid
	 * @param fileType
	 * @return
	 */
	public String upload(String fileName, String dir,InputStream stream,String fileType) {
		
		Calendar c = Calendar.getInstance(); 
		long name = c.getTimeInMillis();//取毫秒数
		String saveFile=null;
		int year = c.get(Calendar.YEAR);//年
    	int month = c.get(Calendar.MONTH)+1;//月
    	int day = c.get(Calendar.DAY_OF_MONTH);//日
		
		saveFile = dir+"/"+year+"/"+month+"/"+day+"/"+ name+"."+fileType;//保存文件
		//时间
    	File yearFile = new File(dir+year);//文件
    	if (!yearFile.isDirectory()) {//判断该文件夹是否存在，如果不存在则创建
			yearFile.mkdir();//创建文件夹
		}
		File monthFile = new File(dir+year+"/"+month);//文件
    	if (!monthFile.isDirectory()) {//判断该文件夹是否存在，如果不存在则创建
			monthFile.mkdir();//创建文件夹
		}
    	File dayFile = new File(dir+year+"/"+month+"/"+day);//文件
    	if (!dayFile.isDirectory()) {//判断该文件夹是否存在，如果不存在则创建
			dayFile.mkdir();//创建文件夹
		}
		try {
			OutputStream bos=new FileOutputStream(saveFile);
			int bytesRead=0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close(); 
            stream.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "upload/"+year+"/"+month+"/"+day+"/"+ name+"."+fileType;
	}
}
