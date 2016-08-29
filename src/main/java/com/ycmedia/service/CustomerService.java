package com.ycmedia.service;

import com.ycmedia.dao.CustomerDao;
import com.ycmedia.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	//客户列表
	public List<Customer> customerList() {return customerDao.customerList();}

	//编辑客户
	public Customer findCustomerById(int id) {return customerDao.findCustomerById(id);}

	//添加客户
	public void addCustomer(Customer customer) {customerDao.addCustomer(customer);}

	//编辑客户
	public void updateCustomer(Customer customer) {customerDao.updateCustomer(customer);}

	//删除客户
	public void deleteCustomer(String[] idList) {customerDao.deleteCustomer(idList);
	}
}
