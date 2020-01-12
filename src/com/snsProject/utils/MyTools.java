package com.snsProject.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class MyTools {

	/*
	 * md5����
	 */
	public static String md5(String pass) {
		String str = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			byte[] by = md5.digest(pass.getBytes());
			for (int i = 0; i < by.length; i++) {
				str += Byte.toString(by[i]);
			}
		} catch (Exception e) {
			System.out.println("�������ʧ��");
		}
		return str;
	}

	/*
	 * ���ַ������н���gbk����
	 */
	public static String getGBK(String str) {
		String newStr = null;
		try {
			if (str == "") {
				return null;
			} else {
				return new String(str.getBytes("iso8859-1"), "UTF-8");
			}
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * �ر�������ݿ�����
	 */
	public static void closeAll(ResultSet rst, Connection con,
			PreparedStatement psmt) {
		try {
			if (rst != null)
				rst.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();

		} catch (Exception e) {
			System.out.println("���ݿ�ر��쳣");
		}
	}

	/**
	 * ���ݴ����IP���������Ӧ��ֵ����ȷ����Χ
	 * 
	 * @param ip
	 * @return int 
	 */
	public static int GetRange(String ip) {

		String[] ips = new String[4];
		ips = ip.split("\\.");// �˴�.��Ҫת��,split������������ʽ
		int num = Integer.parseInt(ips[0]) * 256 * 256 * 256
				+ Integer.parseInt(ips[1]) * 256 * 256
				+ Integer.parseInt(ips[2]) * 256 + Integer.parseInt(ips[0]);
		return num;
	}



	public static String getSimpleDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(new Date());
	}

	
	/**
	 * ���ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	
	
	
	// ����Σ���ַ�
	public static String filterStr(String str) {
		str = str.replaceAll(";", "��");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("'", "��");
		// str = str.replaceAll("/", "");
		str = str.replaceAll("%", "��");
		str = str.replaceAll("\"", "��");
		return str;
	}
	
	/**
	 * �ж��ļ��Ƿ�ΪͼƬ�ļ�(GIF,PNG,JPG)
	 * 
	 * @param srcFileName
	 * @return
	 */
	public static boolean isImage(String srcFileName) {
		FileInputStream imgFile = null;
		byte[] b = new byte[10];
		int l = -1;
		try {
			imgFile = new FileInputStream(srcFileName);
			l = imgFile.read(b);
			imgFile.close();
		} catch (Exception e) {
			return false;
		}
		if (l == 10) {
			byte b0 = b[0];
			byte b1 = b[1];
			byte b2 = b[2];
			byte b3 = b[3];
			byte b6 = b[6];
			byte b7 = b[7];
			byte b8 = b[8];
			byte b9 = b[9];
			if (b0 == (byte) 'G' && b1 == (byte) 'I' && b2 == (byte) 'F') {
				return true;
			} else if (b1 == (byte) 'P' && b2 == (byte) 'N' && b3 == (byte) 'G') {
				return true;
			} else if (b6 == (byte) 'J' && b7 == (byte) 'F' && b8 == (byte) 'I'
					&& b9 == (byte) 'F') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * �ϴ��ļ�
	 */
	public static boolean copy(File src, File dst) {
		try {
			int buffer_size = 16 * 1024;
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						buffer_size);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						buffer_size);
				byte[] buffer = new byte[buffer_size];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
				return true;
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
