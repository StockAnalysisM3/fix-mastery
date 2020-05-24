package com.fixmastery.orders.dao;

import com.fixmastery.orders.dto.OrderData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderData, Long> {}
