/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;

/**
 *
 * @author anastasios
 */
public interface Dao<T> {

    boolean create(T t);

    boolean update(T t);

    boolean delete(int id);

    T find(int id);

    Collection<T> findAll();
}
