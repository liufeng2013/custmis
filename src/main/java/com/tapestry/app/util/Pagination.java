package com.tapestry.app.util;

public class Pagination {
	public static final int MAX_PAGE_SIZE = 500;
	public static final int MAX_RECODE_SIZE = 2147483647;
	private boolean batch;
	private boolean range;
	private boolean needCount = true;
	private boolean onlyCount = false;
	private int start;
	private int size;
	private int count;
	private int currPage;

	public Pagination() throws Exception {
	}

	public Pagination(boolean batch) throws Exception {
		setBatch(batch);
	}

	public Pagination(boolean batch, int size) throws Exception {
		setBatch(batch, size);
	}

	public int getMaxPageSize() throws Exception {
		return 500;
	}

	public void setBatch(boolean batch) throws Exception {
		this.batch = batch;
		this.size = getMaxPageSize();
		if (batch)
			this.range = true;
	}

	public void setBatch(boolean batch, int size) throws Exception {
		this.batch = batch;
		this.size = size;
		if (batch)
			this.range = true;
	}

	public void setRange(int start, int size) {
		this.range = true;
		this.start = start;
		this.size = size;
	}

	public boolean isBatch() {
		return this.batch;
	}

	public boolean isRange() {
		return this.range;
	}

	public boolean isNeedCount() {
		return this.needCount;
	}

	public void setNeedCount(boolean needCount) {
		this.needCount = needCount;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		return this.start;
	}

	public int getSize() {
		return this.size;
	}

	public int getCurrPage() {
		return this.currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public boolean isOnlyCount() {
		return this.onlyCount;
	}

	public void setOnlyCount(boolean onlyCount) {
		this.onlyCount = onlyCount;
	}
}
