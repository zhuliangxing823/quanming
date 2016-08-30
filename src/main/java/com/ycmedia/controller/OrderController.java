package com.ycmedia.controller;

import com.ycmedia.entity.Order;
import com.ycmedia.entity.Reback;
import com.ycmedia.service.OrderService;
import com.ycmedia.service.RebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;



	/**
	 * 订单列表<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月30日10:40:40
	 *
	 * @param
	 * @return orderList 订单列表数据(并跳转到列表页面)
	 * */
	@RequestMapping(value = "/order-list")
	@ResponseBody
	public ModelAndView getOrdreList() {
		List<Order> orderList = new ArrayList<>();
		try {
			orderList = orderService.orderList();
		} catch (Exception e) {

		}
		return new ModelAndView("order-list", "orderList", orderList);
	}
}
