package com.hisign.xcky.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Base64Util {

	public static String getBase64Str(InputStream inputStream) {
		String result = null;
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			int b = 0;
			while (( b = inputStream.read()) != -1) {
				outputStream.write(b);
			}
			result = Base64Helper.encode(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
				}
			}
		}
		
		return result;
	}
	
	public static byte[] getByteDataFromBase64Str(String base64Str) throws IOException{
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    	return decoder.decodeBuffer(base64Str);
	}

}
