package dev.mayankg.design.principles.solid.ISP.refactored.service;

import dev.mayankg.design.principles.solid.ISP.refactored.entity.Entity;

import java.util.List;

//common interface to be implemented by all persistence services. 
interface PersistenceService<T extends Entity> {

    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);

    //Removed this method, as it was only applicable to one of the implementation class
//    public List<T> findByName(String name);
}