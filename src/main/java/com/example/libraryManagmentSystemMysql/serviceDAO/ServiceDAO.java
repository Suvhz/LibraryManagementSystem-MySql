package com.example.libraryManagmentSystemMysql.serviceDAO;

import java.util.List;
import java.util.Map;

public interface ServiceDAO<T>{
	public T create(T t);
	public Map<String, String> delete(int id);
	public void deleteAll();
	public T update(T t);
	public T getById(int id);
	public List<T> get();
	public List<T> getAll();
}
