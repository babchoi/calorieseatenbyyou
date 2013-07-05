package com.ssu.calories;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ImageCrawler {
	private final static String apiKey = "7799cbeed74a61062e5acd32d27ee403";
	private static String uri = "";
	private static String downloadDir;
	
	private final static String fruits[] = {
		"��","��","�θ���","�巡���ĸ���","����","����","�����","����","��ġ",
		"����ƾ","���","�ٳ���","��","������","��纣��","���","����","����",
		"����Ƽ","�ƺ�ī��","������","�ڸ�","����","�޵�","�ڵ�","õ����","ü��",
		"���ڳ�","Ű��","���ξ���","���ľ�","����","����","�Ѷ��"
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
