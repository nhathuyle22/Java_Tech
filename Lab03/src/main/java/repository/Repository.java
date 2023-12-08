package org.example.repository;

import java.util.List;

public interface Repository<T, k>{
    boolean add(T t);
    T get(k id);
    List<T> getAll();
    boolean remove(int id);
    boolean remove(T t);
    boolean update(T t);
}
