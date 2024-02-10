package dev.mayankg.design.principles.solid.ISP.orginal.service;

import dev.mayankg.design.principles.solid.ISP.orginal.entity.Entity;
import java.util.List;

//common interface to be implemented by all persistence services. 
interface PersistenceService<T extends Entity> {

    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);

    public List<T> findByName(String name);
}