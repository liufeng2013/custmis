package com.tapestry.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtils {

	private final String drive = "com.mysql.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3307/test?characterEncoding=utf8";
	private final String name = "root";
	private final String password = "admin";
	private Connection con = null;

	public MysqlUtils() {// 构造方法加载数据库驱动
		try {
			Class.forName(drive).newInstance();
		} catch (Exception e) {
			System.out.println("数据库加载失败！");
		}
	}

	public boolean creatConnection() {// 创建数据库连接

		try {
			con = DriverManager.getConnection(url, name, password);
			con.setAutoCommit(true);
		} catch (SQLException e) {

		}
		return true;
	}

	public boolean executeUpdate(String sql) {// 对数据表的增加，修改和删除的操作
		if (con == null) {
			creatConnection();
		}
		try {
			Statement s = con.createStatement();
			int i = s.executeUpdate(sql);
			System.out.println("操作成功，所影响的记录数为：" + String.valueOf(i));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ResultSet executeQuery(String sql) {// 数据库的查询操作
		ResultSet rs;
		try {
			if (con == null) {
				creatConnection();
			}
			Statement s = con.createStatement();
			rs = s.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			return null;
		}

	}

	public void closeConnection() {// 关闭数据库连接
		if (con == null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
