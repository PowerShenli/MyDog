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
		if (!url.startsWith("jdbc:mysql://")) {
			url = "jdbc:mysql://"+url;
		}
		url = url + database +"?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false";
		return url;
	}

	public static String formatBasePath(String path) {
		return path.replace(".", "/");
	}
	
	public static String formatOutPath(String path) {
		return path.endsWith("/")?"path":path+"/";
	}
	
}
