package com.tapestry.app.data.pagedloop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PagedSource<T> implements Iterable<T> {

	private List<T> _source = new ArrayList<T>();
	private List<T> _pageSource = new ArrayList<T>();
	private Integer _iterableSize;

	public PagedSource(Iterable<T> source) {
		for (T aSource : source)
			_source.add(aSource);
	}

	/**
	 * @return
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<T> iterator() {
		return _pageSource.iterator();
	}

	public int getTotalRowCount() {
		if (_iterableSize != null)
			return _iterableSize;
		_iterableSize = 0;
		Iterator<?> it = _source.iterator();
		while (it.hasNext()) {
			it.next();
			_iterableSize++;
		}
		return _iterableSize;
	}

	public void prepare(int startIndex, int endIndex) {
		for (int i = startIndex; i <= endIndex; i++) {
			_pageSource.add(_source.get(i));
		}
	}
}
