package com.tapestry.app.util;

import org.apache.log4j.Logger;
import java.io.File;
import com.tapestry.app.data.IExcelset;
import com.tapestry.app.data.ExcelsetList;

public class DaoManager {

	protected Logger log = Logger.getLogger(getClass());

	private void setDatasetSerializable(IExcelset dataset, int pageCount,
			int pageSize) throws Exception {
		dataset.setSerializable(true);
		dataset.setSerializablePath("/" + FileMan.getUploadPath("5"));
		dataset.setSerializableId(FileMan.getUniqeName());

		File file = new File(dataset.getSerializablePath() + "/"
				+ dataset.getSerializableId());
		if (!file.exists())
			file.mkdir();
	}

	/*
	private IExcelset getTotalDataset(Connection conn, String sql,
			Parameter param, int rowCount, int maxPageSize) throws Exception {
		IExcelset dataset = new ExcelsetList();

		int pageCount = (int) Math.ceil(rowCount / maxPageSize);

		if (pageCount > 1) {
			setDatasetSerializable(dataset, pageCount, maxPageSize);
		}

		for (int i = 0; i < pageCount; i++) {
			Parameter subparam = new Parameter();
			subparam.addAll(param);
			String subsql = getPagingSql(sql, subparam, i * maxPageSize, i
					* maxPageSize + maxPageSize);

			IExcelset subset = queryList(conn, subsql, subparam);
			if (dataset.isSerializable())
				FileMan.writeObject(dataset.getSerializablePath() + "/"
						+ dataset.getSerializableId() + "/" + i, subset);
			else {
				dataset.addAll(queryList(conn, subsql, subparam));
			}
		}

		return dataset;
	}

	private IExcelset getTotalDataset(Connection conn, String sql, IData param,
			int rowCount, int maxPageSize) throws Exception {
		IExcelset dataset = new ExcelsetList();

		int pageCount = (int) Math.ceil(rowCount / maxPageSize);

		if (pageCount > 1) {
			setDatasetSerializable(dataset, pageCount, maxPageSize);
		}

		for (int i = 0; i < pageCount; i++) {
			IData subparam = new DataMap();
			subparam.putAll(param);
			String subsql = getPagingSql(sql, subparam, i * maxPageSize, i
					* maxPageSize + maxPageSize);

			IExcelset subset = queryList(conn, subsql, subparam);
			if (dataset.isSerializable())
				FileMan.writeObject(dataset.getSerializablePath() + "/"
						+ dataset.getSerializableId() + "/" + i, subset);
			else {
				dataset.addAll(queryList(conn, subsql, subparam));
			}
		}

		return dataset;
	}*/

	public static String getPagingSql(String sql, /* Parameter param, */int test,
			int start, int end) throws Exception {
		StringBuffer str = new StringBuffer();

		// switch (getDatabase()) {
		// case 1:
		// str.append("select * from (select row_.*, rownum rownum_ from (");
		// str.append(sql);
		// str.append(") row_ where rownum <= ?) where rownum_ > ?");
		// param.add(String.valueOf(end));
		// param.add(String.valueOf(start));
		// break;
		// case 5:
		// str.append(sql);
		// str.append(" limit ?, ?");
		// param.add(String.valueOf(start));
		// param.add(String.valueOf(end));
		// }

		return str.toString();
	}

	public static String getPagingSql(String sql, /* IData param, */int start,
			int end) throws Exception {
		StringBuffer str = new StringBuffer();

		// switch (getDatabase()) {
		// case 1:
		// str.append("select * from (select row_.*, rownum rownum_ from (");
		// str.append(sql);
		// str.append(") row_ where rownum <= :MAX_NUM) where rownum_ > :MIN_NUM");
		// break;
		// case 5:
		// str.append(sql);
		// str.append(" limit :MIN_NUM, :MAX_NUM");
		// }

		// param.put("MIN_NUM", String.valueOf(start));
		// param.put("MAX_NUM", String.valueOf(end));

		return str.toString();
	}
}
