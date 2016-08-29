package com.ycmedia.dao;

import com.ycmedia.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao {

	//客户列表
	List<Customer> customerList();

	//编辑客户
	Customer findCustomerById(@Param("id")int id);

	//添加客户
	int addCustomer(Customer customer);

	//编辑客户
	void updateCustomer(@Param("customer")Customer customer);

	//删除客户
	void deleteCustomer(@Param("idList")String[] idList);


}
