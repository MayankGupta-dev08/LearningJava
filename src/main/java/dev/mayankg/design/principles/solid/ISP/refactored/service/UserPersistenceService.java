package dev.mayankg.design.principles.solid.ISP.refactored.service;

import dev.mayankg.design.principles.solid.ISP.refactored.entity.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Stores UserEntity entities
class UserPersistenceService implements PersistenceService<UserEntity> {
    private static final Map<Long, UserEntity> USERS = new HashMap<>();

    @Override
    public void save(UserEntity user) {
        synchronized (USERS) {
            USERS.put(user.getId(), user);
        }
    }

    @Override
    public void delete(UserEntity user) {
        synchronized (USERS) {
            USERS.remove(user.getId());
        }
    }

    @Override
    public UserEntity findById(Long id) {
        synchronized (USERS) {
            return USERS.get(id);
        }
    }

    public List<UserEntity> findByName(String name) {
        synchronized (USERS) {
            return USERS.values().stream()
                    .filter(u -> u.getName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }
    }
}