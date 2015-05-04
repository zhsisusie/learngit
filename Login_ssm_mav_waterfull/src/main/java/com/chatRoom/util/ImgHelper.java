package com.chatRoom.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class ImgHelper {
	/**
	 * 将byte数组以Base64方式编码为字符串
	 */
	public static String encode(byte[]bytes){
		return new BASE64Encoder().encode(bytes);
	}
	/**
	 * 将Base64方式编码的字符串解码为byte数组
	 * @throws IOException 
	 */
	public static byte[]decode(String encodeStr) throws IOException{
		byte[]bt=null;
		BASE64Decoder decoder=new BASE64Decoder();
		bt=decoder.decodeBuffer(encodeStr);
		return bt;
	}
	
	/**
	 * 将图片以Base64方式编码为字符串
	 * @throws IOException 
	 */
	public static String encodeImage(String imgUrl) throws IOException{
		FileInputStream fis=new FileInputStream(imgUrl);
		byte[]rs=new byte[fis.available()];
		fis.read(rs);//将数据读取到rs中
		fis.close();
		return encode(rs);
	}
}
