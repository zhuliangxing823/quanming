package com.ycmedia.dao;

import com.ycmedia.entity.Order;
import com.ycmedia.entity.Reback;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

	//订单列表
	List<Order> orderList();
}
