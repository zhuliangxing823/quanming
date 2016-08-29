package com.ycmedia.controller;

import com.ycmedia.entity.Customer;
import com.ycmedia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	/**
	 * 客户列表<br />
	 * Author;zhanglei<br />
	 * UpdateTime:2016年8月25日10:36:08
	 *
	 * @param
	 * @return customerList 客户列表数据
	 * */
	@RequestMapping(value = "/customer-list")
	@ResponseBody
	public ModelAndView getCustomerList() {
		List<Customer> customerList = new ArrayList<>();
		try {
			customerList = customerService.customerList();
		} catch (Exception e) {

		}
		return new ModelAndView("customer-list", "customerList", customerList);
	}


	/**
	 * 跳转至添加或修改页面<br />
	 * Author;zhanglei<br />
	 * UpdateTime:2016年8月25日13:24:03
	 *
	 * @param
	 * @return add-edit-customer.html 跳转页面
	 * */
	@RequestMapping(value = "/add-edit-customer")
	public ModelAndView  addEditCustomer(@RequestParam(value = "id")int id,@ModelAttribute(value="customer")Customer customer){
		if ( id > 0){
			customer = customerService.findCustomerById(id);
			customer.setId(id);
		}
		return id>0 ? new ModelAndView("add-edit-customer","customer",customer):new ModelAndView("add-edit-customer");
	}

	/**
	 * 添加或修改客户post提交<br />
	 * Author;zhanglei<br />
	 * UpdateTime:2016年8月25日13:24:03
	 *
	 * @param customer 顾客实体
	 * @return customer-list 重定向
	 * */
	@RequestMapping(value = "/add-edit-cus",method= RequestMethod.POST)
	public ModelAndView  addEditCustomer(@ModelAttribute(value="customer")Customer customer,Model model){
		try {
			//id等于0添加 否则修改
			if (customer.getId() == 0){
				customer.setUid(UUID.randomUUID().toString().replace("-", ""));
				customerService.addCustomer(customer);
			}else{
				customerService.updateCustomer(customer);
			}
			model.addAttribute("code", "200");
		} catch (Exception e) {
			model.addAttribute("code", "500");

		}
		return  new ModelAndView("redirect:/customer-list");
	}

	/**
	 * 删除客户<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月26日15:05:59
	 *
	 * @return customer-list 重定向
	 * */
	@RequestMapping(value = "/delete-customer")
	@ResponseBody
	public Map<String, Object> deleteCustomer(HttpServletRequest request){
		String[] idList =request.getParameter("id_list").split(",");
		Map<String, Object> result = new HashMap<>();
		try{
			customerService.deleteCustomer(idList);
			result.put("status",true);
			result.put("message","删除成功");
		}catch (Exception e){
			result.put("status",false);
			result.put("message","删除异常");
		}
		return result;
	}
}
