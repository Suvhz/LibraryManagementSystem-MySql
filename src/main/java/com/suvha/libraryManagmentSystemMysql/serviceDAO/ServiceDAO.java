package com.suvha.libraryManagmentSystemMysql.serviceDAO;

import java.util.List;
import java.util.Map;

public interface ServiceDAO<T>{
	public T create(T t);
	public Map<String, String> delete(int id);
	public void deleteAll();
	public T update(T t);
	public T getById(long id);
	public List<T> getAll();
}
