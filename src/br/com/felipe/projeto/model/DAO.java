package br.com.felipe.projeto.model;
import java.util.ArrayList;

public interface DAO<T> {
    public boolean save(T t);
	public boolean update(T t);
	public boolean delete(T t);
	public abstract ArrayList<?> findAll();
	public T findbyID(int id);
}