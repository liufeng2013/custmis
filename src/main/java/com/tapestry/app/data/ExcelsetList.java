package com.tapestry.app.data;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "serial", "rawtypes" })
public class ExcelsetList extends ArrayList implements IExcelset {

	private String serializableId;
	private String serializablePath;
	private boolean serializable;

	public ExcelsetList() {
	}

	@SuppressWarnings("unchecked")
	public ExcelsetList(List list) {
		addAll(list);
	}

	public String getSerializableId() {
		return this.serializableId;
	}

	public void setSerializableId(String serializableId) {
		this.serializableId = serializableId;
	}

	public String getSerializablePath() {
		return this.serializablePath;
	}

	public void setSerializablePath(String serializablePath) {
		this.serializablePath = serializablePath;
	}

	public boolean isSerializable() {
		return this.serializable;
	}

	public void setSerializable(boolean serializable) {
		this.serializable = serializable;
	}
}
