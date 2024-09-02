package com.sparta.baedallegend.domains.order.repo;

import com.sparta.baedallegend.domains.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, String> {

}
