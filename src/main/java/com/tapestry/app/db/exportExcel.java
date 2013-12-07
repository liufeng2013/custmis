package com.tapestry.app.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.tapestry.app.util.MessageTempleteManager;

public class exportExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("简单测下时间Start:" + System.currentTimeMillis());
		
		// 获取数据库内容
		MysqlUtils mysqlUtils = new MysqlUtils();

		String sql = "select eparchy_code, depart, staff_id_kf, staff_id_bss, accept_type, serial_number, trade_type from trade"; 
				//"select user_id, age, name, time from user";

		ResultSet rs = mysqlUtils.executeQuery(sql);

		// 封装输出到序列
		List userlist = new ArrayList();

		while (rs.next()) {
			ResultSetMetaData rsm = rs.getMetaData();

			Map user = new LinkedHashMap();
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String name = rsm.getColumnName(i).toUpperCase();
				int type = rsm.getColumnType(i);
				user.put(name, type == 2004 ? rs.getBlob(name) : rs.getString(name));
			}

			userlist.add(user);
		}

		//System.out.println(userlist.size());
		for (int j = 0; j < 10; j++) {
			Map temp = (Map) userlist.get(j);
			//System.out.println("NAME:" + temp.get("NAME"));
			//System.out.println(temp.toString());
		}

		// 写入到文件
		String file_name = "temp1";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file_name));
		out.writeObject(userlist);
		out.close();
		
		System.out.println("简单测下时间写到硬盘:" + System.currentTimeMillis());
		
		// 使用freemarker生成xml
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("reportname", "电话营销日清单");
		param.put("info", "开始日期：2013-12-05  结束日期：2013-12-05  地市：全部   ");
		
		Map<String, Object> tableHead = new LinkedHashMap<String, Object>();
		tableHead.put("EPARCHY_CODE", "地市");
		tableHead.put("DEPART", "受理单元(员工部门)");
		tableHead.put("STAFF_ID_KF", "受理工号(客服工号)");
		tableHead.put("STAFF_ID_BSS", "BSS工号");
		tableHead.put("ACCEPT_TYPE", "来话/去话");
		tableHead.put("SERIAL_NUMBER", "受理号码");
		tableHead.put("TRADE_TYPE", "受理业务");
		
		param.put("tablehead", tableHead);
		
		param.put("userlist", userlist);
		String strOutput = MessageTempleteManager.process("excel.ftl", param);
		//System.out.println(strOutput);
		
		// 将生成的目标内容生成文件
		String outFile_name = "excel.xls";
		FileWriter outfile = new FileWriter(outFile_name);
		//FileOutputStream outfile = new FileOutputStream(new File(outFile_name));
		//outfile.write(strOutput.getBytes("GBK"));
		outfile.write(strOutput);
		outfile.close();
		
		System.out.println("简单测下时间End:" + System.currentTimeMillis());
		
		// 压缩文件
		String zip_name = "excel.zip";
		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(new File(zip_name)));
		zipout.putNextEntry(new ZipEntry(outFile_name));
		FileInputStream in = new FileInputStream(outFile_name);
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		int len = -1;
		while ((len = in.read(buffer)) != -1) {
			zipout.write(buffer, 0, len);
		}
		in.close();
	}
}
