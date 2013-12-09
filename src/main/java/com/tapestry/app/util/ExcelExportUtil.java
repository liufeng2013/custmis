package com.tapestry.app.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.Map;
import java.util.Random;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ExcelExportUtil {

	private static ExcelExportUtil excelExportUtil = null;
	private Configuration cfg = null;

	// 通过freeMarker模板生成目标信息
	private ExcelExportUtil() {
		cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(),
				"/com/tapestry/app/freemarker/templete/");
	}

	private static Template getTemplate(String name) throws IOException {
		if (excelExportUtil == null) {
			excelExportUtil = new ExcelExportUtil();
		}
		return excelExportUtil.cfg.getTemplate(name);
	}

	public static String process(String templatefile,
			@SuppressWarnings("rawtypes") Map param) throws IOException,
			TemplateException {
		Template template = ExcelExportUtil.getTemplate(templatefile);
		StringWriter sw = new StringWriter();
		template.process(param, sw);
		return sw.toString();
	}

	// 压缩文件
	public static void zip(File[] files, String zip_name) throws Exception {
		// 实例化压缩包文件
		FileOutputStream fos = new FileOutputStream(zip_name + ".zip");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ZipOutputStream zos = new ZipOutputStream(bos);// 压缩包

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ZipEntry ze = null;
		byte[] buf;
		int len;

		for (int i = 0; i < files.length; i++) {
			fis = new FileInputStream(files[i].getAbsoluteFile());
			bis = new BufferedInputStream(fis);
			ze = new ZipEntry(files[i].getName());// 这是压缩包名里的文件名
			zos.putNextEntry(ze);// 写入新的 ZIP 文件条目并将流定位到条目数据的开始处

			buf = new byte[1024];
			while ((len = bis.read(buf)) != -1) {
				zos.write(buf, 0, len);
				zos.flush();
			}
		}

		bis.close();
		zos.close();
	}

	public static void zipFile(String file_name, String zip_name)
			throws Exception {
		File files[] = { new File(file_name) };
		zip(files, zip_name);
	}

	public static void zipFiles(String[] file_names, String zip_name)
			throws Exception {
		File files[] = new File[file_names.length];
		for (int i = 0; i < file_names.length; i++) {
			files[i] = new File(file_names[i]);
		}

		zip(files, zip_name);
	}

	// 将信息写入到目标文件
	public static void writeFile(File file, String str) throws Exception {
		FileWriter outfile = new FileWriter(file);
		outfile.write(str);
		outfile.close();
	}

	public static void writeFile(String file_name, String str) throws Exception {
		writeFile(new File(file_name), str);
	}

	// 将信息写入到对象文件
	public static void writeObject(File file, Object obj) throws Exception {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				file));
		out.writeObject(obj);
		out.close();
	}

	public static void writeObject(String file_name, Object obj)
			throws Exception {
		writeObject(new File(file_name), obj);
	}

	// 读出对象文件内容
	public static Object readObject(File file) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object obj = in.readObject();
		in.close();
		return obj;
	}

	public static Object readObject(String file_name) throws Exception {
		return readObject(new File(file_name));
	}

	// 刪除文件
	public static boolean deleteFile(String full_name) throws Exception {
		File file = new File(full_name);
		if (file.exists())
			return file.delete();
		return false;
	}

	public static boolean deleteFile(String file_path, String file_name)
			throws Exception {
		File file = new File(file_path, file_name);
		if (file.exists())
			return file.delete();
		return false;
	}

	// 生成临时文件/文件夹名
	public static String getUniqeName() throws Exception {
		return String.valueOf(System.currentTimeMillis())
				+ Math.abs(new Random().nextInt());
	}
}