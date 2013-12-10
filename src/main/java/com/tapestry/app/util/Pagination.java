package com.tapestry.app.util;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tapestry.app.db.MysqlUtils;

public class Pagination {
	private int totalRow; // 总记录数
	private int totalPage; // 总页数
	private int currentPage = 1; // 当前页码，从1计起
	private int numPerPage; // 每页记录数
	private String sql; // 查询语句
	MysqlUtils mysqlUtils = new MysqlUtils();

	public Pagination(String sql, int numPerpage) {
		this.setSql(sql);
		this.setNumPerPage(numPerpage);
		String totalSql = "select count(1) from (" + sql + ") t";
		this.setTotalRow(getTotalRow(totalSql)); // 设置总行数
		this.setTotalPage(); // 计算总页数
	}

	// 获取总行数
	public int getTotalRow(String sql) {
		int totalRow = 0;
		try {
			ResultSet rs = mysqlUtils.executeQuery(sql);
			totalRow = rs.next() ? rs.getInt(1) : 0;
			rs.getStatement().close();
		} catch (Exception e) {

		}

		return totalRow;
	}

	// 获得分页语句(mysql)
	public String getPagingSql(String sql, Map param, int start, int end) {
		StringBuffer str = new StringBuffer();
		str.append(sql);
		str.append(" limit ?, ?");
		param.put("MIN_NUM", String.valueOf(start));
		param.put("MAX_NUM", String.valueOf(end));

		return str.toString();
	}

	public String getTotalList() throws Exception{
		String strPath = ExcelExportUtil.getPath("2") + "/" + ExcelExportUtil.getUniqeName();
		File file = new File(strPath);
		if(!file.exists()){
			file.mkdirs();
		}

		for(int i = 0; i < totalPage; i++) {
			Map subparam = new HashMap();
			String subsql = getPagingSql(sql, subparam, i * numPerPage, numPerPage);

			List subset = mysqlUtils.queryList(subsql, subparam);
				
			ExcelExportUtil.writeObject(strPath + "/" + i, subset);
		}
		
		return strPath;
	}

	/**
	 * 取得下一页内容 Oracle
	 * 
	 * @return 下页内容的列表
	 */
	public List getNextPage() throws Exception {

		Map param = null;

		if (currentPage > totalPage)
			return null;
		int startIndex = (currentPage - 1) * numPerPage + 1;
		int endIndex = 0;
		if (currentPage == totalPage)
			endIndex = totalRow;
		else
			endIndex = currentPage * numPerPage;
		StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		paginationSQL.append(sql);
		paginationSQL.append("  ) temp where ROWNUM <= " + endIndex);
		paginationSQL.append(" ) WHERE  num >= " + startIndex);
		List list = mysqlUtils.queryList(paginationSQL.toString(), param);
		currentPage++;
		return list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {

		if (totalRow % numPerPage == 0)
			totalPage = totalRow / numPerPage;
		else
			totalPage = totalRow / numPerPage + 1;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
