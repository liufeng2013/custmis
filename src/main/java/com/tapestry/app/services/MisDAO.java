package com.tapestry.app.services;

import java.io.Serializable;
import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

public interface MisDAO {

	<T, PK extends Serializable> T findByID(Class<T> type, PK id);
	
	@CommitAfter
	<T> T create(T t);
	
	@CommitAfter
	<T> T update(T t);
	
	@CommitAfter
	<T, PK extends Serializable> void deleteByID(Class<T> type, PK id);
	
	<T> List<T> findWithNameQuery(String queryName, int num);
	<T> List<T> findWithQuery(String queryName);
}
