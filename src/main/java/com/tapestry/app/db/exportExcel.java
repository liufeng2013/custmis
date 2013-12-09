package com.tapestry.app.db;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import com.tapestry.app.util.ExcelExportUtil;
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
		// "select user_id, age, name, time from user";

		ResultSet rs = mysqlUtils.executeQuery(sql);

		// 封装输出到序列
		List userlist = new ArrayList();

		while (rs.next()) {
			ResultSetMetaData rsm = rs.getMetaData();

			Map user = new LinkedHashMap();
			for (int i = 1; i <= rsm.getColumnCount(); i++) {
				String name = rsm.getColumnName(i).toUpperCase();
				int type = rsm.getColumnType(i);
				user.put(name,
						type == 2004 ? rs.getBlob(name) : rs.getString(name));
			}

			userlist.add(user);
		}

		// 写入到文件
		String file_name = "temp1";		
		ExcelExportUtil.writeObject(file_name, userlist);

		System.out.println("简单测下时间写到硬盘:" + System.currentTimeMillis());
		
		// 从文件读出
		List inUserList = (List)ExcelExportUtil.readObject(file_name);
		
		
		System.out.println("简单测下时间从硬盘读出:" + System.currentTimeMillis());
		
		// 删除文件
		ExcelExportUtil.deleteFile(file_name);

		// 使用freemarker生成xml
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("author", "test");
		param.put("createdate", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

		param.put("reportname", "电话营销日清单");
		param.put("info", "开始日期：2013-12-05  结束日期：2013-12-05  地市：全部   ");

		Map<String, Object> tableHead = new LinkedHashMap<String, Object>(); // 使用LinkedHashMap保证显示顺序不变
		tableHead.put("EPARCHY_CODE", "地市");
		tableHead.put("DEPART", "受理单元(员工部门)");
		tableHead.put("STAFF_ID_KF", "受理工号(客服工号)");
		tableHead.put("STAFF_ID_BSS", "BSS工号");
		tableHead.put("ACCEPT_TYPE", "来话/去话");
		tableHead.put("SERIAL_NUMBER", "受理号码");
		tableHead.put("TRADE_TYPE", "受理业务");

		param.put("tablehead", tableHead);

		Map<String, Object> tableFoot = new LinkedHashMap<String, Object>();
		tableFoot.put("staff", "制表人： 高莹");// 制表人： 高莹
		tableFoot.put("depart", "制表部门： 山东省分公司");// 制表部门： 山东省分公司
		tableFoot.put("date", "制表日期： 2013-12-06");// 制表日期： 2013-12-06

		param.put("tablefoot", tableFoot);

		param.put("userlist", inUserList);
		String strOutput = ExcelExportUtil.process("excel.ftl", param);

		// 将生成的目标内容生成文件
		String outFile_name = "日清单.xls";
		ExcelExportUtil.writeFile(outFile_name, strOutput);

		System.out.println("简单测下时间生成Excel:" + System.currentTimeMillis());

		// 压缩文件
		ExcelExportUtil.zipFile(outFile_name, "日清单20131209");
		
		// 删除文件
		ExcelExportUtil.deleteFile(outFile_name);

		System.out.println("简单测下时间生成完成压缩:" + System.currentTimeMillis());
	}
}
