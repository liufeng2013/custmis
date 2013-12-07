package com.tapestry.app.data;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface IExcelset extends List {

	public abstract String getSerializableId();
	public abstract void setSerializableId(String paramString);
	public abstract String getSerializablePath();
	public abstract void setSerializablePath(String paramString);
	public abstract boolean isSerializable();
	public abstract void setSerializable(boolean paramBoolean);
}
