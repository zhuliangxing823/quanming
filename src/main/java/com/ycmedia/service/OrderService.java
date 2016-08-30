package com.ycmedia.service;

import com.ycmedia.dao.OrderDao;
import com.ycmedia.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	//订单列表
	public List<Order> orderList() {return orderDao.orderList();}
}
