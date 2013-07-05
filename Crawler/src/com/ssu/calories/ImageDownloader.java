package com.ssu.calories;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public class ImageDownloader {
	final static int size = 1024;		// buffer size

	public static long download(String url, String downloadDir, String fruit) {
		// 밀리초 단위(*1000은 1초), 음수이면 이전 시각
		long time = System.currentTimeMillis ( ); 

		OutputStream outStream = null;
		URLConnection uCon = null;
		InputStream is = null;
		try {
			URL Url;
			byte[] buf;
			int byteRead;
			int byteWritten = 0;

			Url = new URL(url);
			System.out.println("-------Download Start--------");
			System.out.println("url:" + url);
			System.out.println(fruit + "_" + String.valueOf(time) + ".png");
			outStream = new BufferedOutputStream(new FileOutputStream(
					downloadDir + "\\" + fruit + "_" + String.valueOf(time) + ".png"));
			uCon = Url.openConnection();
			try { 
				is = uCon.getInputStream();
			} catch(FileNotFoundException e) {
				outStream.close();
				return -1;
			} 
			buf = new byte[size];
			while ((byteRead = is.read(buf)) != -1) {
				outStream.write(buf, 0, byteRead);
				byteWritten += byteRead;
			}
			System.out.println("Download Successfully.");
			System.out.println("of bytes  : " + byteWritten);
			System.out.println("-------Download End--------");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			time = -1;
		} catch (Exception e) {
			e.printStackTrace();
			time = -1;
		} finally {
			try {
				is.close();
				outStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				time = -1;
			}
		}
		return time;
	}
}
