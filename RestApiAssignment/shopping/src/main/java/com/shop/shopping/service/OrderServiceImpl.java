package com.shop.shopping.service;

import com.shop.shopping.Exception.NoEntityException;
import com.shop.shopping.model.Order;
import com.shop.shopping.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductServiceImpl productServiceImp;
    @Autowired
    EntityManager entityManager;
    private static List<Order> orders;
    private List<Map<String, String>> ordersMap = new ArrayList<Map<String, String>>();

    public List<Map<String, String>> getAll() {
        ordersMap.clear();
        toMap((List<Order>) orderRepository.findAll());
        return ordersMap;
    }

    public List<Map<String, String>> findByOrderName(String orderName) {
        ordersMap.clear();
        toMap(orderRepository.findByOrderName(orderName));
        return ordersMap;
    }

    public String addOrder(String orderName, Integer quantity, Integer product_id) {
        try {
            orderRepository.save(new Order(productServiceImp.findById(product_id), quantity, orderName));
            Iterable<Order> allOrders = orderRepository.findAll();
        } catch (NoEntityException e) {
            return "Product id - not found!";
        }
        return "Ok";
    }

    private void toMap(List<Order> orders) {
        for (Order item : orders) {
            ordersMap.add(new HashMap<String, String>() {{
                put("orderName", item.getOrderName());
                put("productId", item.getProduct().toString());
                put("quantity", String.valueOf(item.getQuantity()));
            }});
        }
    }

    public void updateOrder(Long orderId, long newProduct_Id, Integer newQuantity) throws NoEntityException {
        Order order = orderRepository.findById(Math.toIntExact(orderId)).orElseThrow(() ->
                new NoEntityException(orderId, "Order not found"));
        order.setProduct(productServiceImp.findById(newProduct_Id));
        order.setQuantity(newQuantity);
        orderRepository.save(order);
    }

    public void delOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}