package dev.mayankg.design.principles.solid.ISP.orginal.service;

import dev.mayankg.design.principles.solid.ISP.orginal.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Stores UserEntity entities
class UserPersistenceService implements PersistenceService<UserEntity> {
    private static final Map<Long, UserEntity> USERS = new HashMap<>();

    @Override
    public void save(UserEntity entity) {
        synchronized (USERS) {
            USERS.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(UserEntity entity) {
        synchronized (USERS) {
            USERS.remove(entity.getId());
        }
    }

    @Override
    public UserEntity findById(Long id) {
        synchronized (USERS) {
            return USERS.get(id);
        }
    }

    @Override
    public List<UserEntity> findByName(String name) {
        synchronized (USERS) {
            return USERS.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
    }
}