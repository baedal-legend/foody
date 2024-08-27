package com.sparta.baedallegend.order.repo;

import com.sparta.baedallegend.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
}