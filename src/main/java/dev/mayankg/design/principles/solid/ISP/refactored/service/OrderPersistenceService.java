package dev.mayankg.design.principles.solid.ISP.refactored.service;

import dev.mayankg.design.principles.solid.ISP.refactored.entity.OrderEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class OrderPersistenceService implements PersistenceService<OrderEntity> {
    private static final Map<Long, OrderEntity> ORDERS = new HashMap<>();

    @Override
    public void save(OrderEntity order) {
        synchronized (ORDERS) {
            ORDERS.put(order.getId(), order);
        }
    }

    @Override
    public void delete(OrderEntity order) {
        synchronized (ORDERS) {
            ORDERS.remove(order);
        }
    }

    @Override
    public OrderEntity findById(Long id) {
        synchronized (ORDERS) {
            return ORDERS.get(id);
        }
    }

    public List<OrderEntity> findByDate(String orderDate) {
        synchronized (ORDERS) {
            return ORDERS.values().stream()
                    .filter(u -> u.getOrderPlacedOn().toString().equalsIgnoreCase(orderDate))
                    .collect(Collectors.toList());
        }
    }
}