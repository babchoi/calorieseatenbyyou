package com.ssu.calories;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ImageCrawler {
	private final static String apiKey = "7799cbeed74a61062e5acd32d27ee403";
	private static String uri = "";
	private static String downloadDir;
	
	private final static String fruits[] = {
		"감","귤","두리안","드래곤후르츠","딸기","라임","라즈베리","레몬","리치",
		"망고스틴","멜론","바나나","배","복숭아","블루베리","사과","석류","수박",
		"스위티","아보카도","오렌지","자몽","망고","앵두","자두","천혜향","체리",
		"코코넛","키위","파인애플","파파야","포도","참외","한라봉"
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Image Crawler Start");
		NaverParse parse = new NaverParse();
		
		if ( args.length >= 2 ) {
			downloadDir = args[1];
		}
		
		for(String fruit : fruits) {
			try{
	    		uri = "http://openapi.naver.com/search?key=" + apiKey + "&start=1&display=100&target=image&query=" + 
	    		URLEncoder.encode(fruit, "UTF-8");
	    		parse.parse(uri, fruit);
	    	}catch(UnsupportedEncodingException e){
	    		System.out.println(e);
	    	}
		}
		System.out.println("Image Crawler End");
		
	}

}
