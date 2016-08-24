package com.ycmedia.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ycmedia.entity.Creative;

@Repository
public interface AdDao {

	List<Creative> getAdList();

}
