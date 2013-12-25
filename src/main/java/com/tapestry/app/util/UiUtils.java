package com.tapestry.app.util;

import java.util.Date;
import java.util.Random;

public class UiUtils {

	public static String splitString(String str, String split) {
		int index = str.lastIndexOf(split);
		return str.substring(index + 1);
	}

	public static String splitStringPath(String str) {
		str = str.replace("/", "\\");
		int index = str.lastIndexOf("\\");
		return str.substring(index + 1);
	}

	public static String createFileName(String name) {
		Long randomNum = new Random().nextLong();
		String radomStr = randomNum.toString().substring(2, 5);
		String accessoryAutoName = new Date().getTime() + radomStr;
		String extendedName = splitString(name, ".");
		String fileName = accessoryAutoName;
		if (extendedName != null) {
			fileName = accessoryAutoName + "." + extendedName;
		}
		return fileName;
	}
}
