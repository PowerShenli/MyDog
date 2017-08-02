package org.huangpu.mydog.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author xusihan on 2017.07.20
 *
 */
public class PathUtils {

	public static String parserMysqlPath(String url, String database) {
		if (!url.endsWith("/")) {
			url = url +"/";
		}
		if (!url.startsWith("http")) {
			url = "http://"+url;
		}
		url = url + database +"?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false";
		return url;
	}

	public static String formatBasePath(String path) {
		return path.replace("/", ".");
	}
	
	public static void main(String[] args) {
		String url = "http://haha/cpm";
		Pattern pattern = Pattern.compile("^(\\/(\\w+))*\\/?(\\.\\w{5,})?\\??([^.]+)?$");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			System.out.println(matcher.group(1));
		}
	}
}
