package i.vk.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import i.vk.entity.OrderDetails;
import i.vk.repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;

    public void insertOrder() {
        OrderDetails order = new OrderDetails();
        order.setOrderName("I Phone 15 pro Max");
        Date todayDate = new Date();
        order.setOrderOn(todayDate);
        repo.save(order);
    }
}
