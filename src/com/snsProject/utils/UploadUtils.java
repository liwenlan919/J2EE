package com.snsProject.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class UploadUtils {
	
	/**
	 * �ϴ�
	 * @param fileName
	 * @param dir
	 * @param stream
	 * @param uid
	 * @param fileType
	 * @return
	 */
	public String upload(String fileName, String dir,InputStream stream,String fileType) {
		
		Calendar c = Calendar.getInstance(); 
		long name = c.getTimeInMillis();//ȡ������
		String saveFile=null;
		int year = c.get(Calendar.YEAR);//��
    	int month = c.get(Calendar.MONTH)+1;//��
    	int day = c.get(Calendar.DAY_OF_MONTH);//��
		
		saveFile = dir+"/"+year+"/"+month+"/"+day+"/"+ name+"."+fileType;//�����ļ�
		//ʱ��
    	File yearFile = new File(dir+year);//�ļ�
    	if (!yearFile.isDirectory()) {//�жϸ��ļ����Ƿ���ڣ�����������򴴽�
			yearFile.mkdir();//�����ļ���
		}
		File monthFile = new File(dir+year+"/"+month);//�ļ�
    	if (!monthFile.isDirectory()) {//�жϸ��ļ����Ƿ���ڣ�����������򴴽�
			monthFile.mkdir();//�����ļ���
		}
    	File dayFile = new File(dir+year+"/"+month+"/"+day);//�ļ�
    	if (!dayFile.isDirectory()) {//�жϸ��ļ����Ƿ���ڣ�����������򴴽�
			dayFile.mkdir();//�����ļ���
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
