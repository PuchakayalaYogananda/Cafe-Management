package com.example.cafe.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cafe.Dao.OrderDao;
import com.example.cafe.Entity.Order;


@Service
public class OrderServiceIpImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @SuppressWarnings("unused")
	@Autowired
    private FoodService foodService;

    @SuppressWarnings("unused")
	@Autowired
    private UserService userService;



    
    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderDao.findById(orderId).orElse(null);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderDao.deleteById(orderId);
    }

    @Override
    public Order saveOrder(Order order) {

        return orderDao.save(order);
    }

    @Override
    public List<Order> findOdersByUserId(long userId) {
        return orderDao.findByUserUserId(userId);
    }




}