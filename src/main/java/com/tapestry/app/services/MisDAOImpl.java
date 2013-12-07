package com.tapestry.app.services;

import java.io.Serializable;
import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.hibernate.Session;

public class MisDAOImpl implements MisDAO {
	private Session session;
	
	public MisDAOImpl(Session session){
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public <T, PK extends Serializable> T findByID(Class<T> type, PK id) {
		return (T)session.get(type, id);
	}

	@CommitAfter
	public <T> T create(T t) {
		session.persist(t);
		session.flush();
		session.refresh(t);
		//session.save(t);
		return t;
	}

	@CommitAfter
	public <T> T update(T t) {
		session.merge(t);
		return t;
	}

	@CommitAfter
	public <T, PK extends Serializable> void deleteByID(Class<T> type, PK id) {
		@SuppressWarnings("unchecked")
		T t = (T)session.get(type, id);
		session.delete(t);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findWithNameQuery(String queryName, int num) {
		return session.createQuery(queryName).setMaxResults(num).list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findWithQuery(String queryName) {
		return session.createQuery(queryName).list();
	}

}
