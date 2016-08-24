package com.ycmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycmedia.dao.AdDao;
import com.ycmedia.entity.Creative;

@Service
public class AdService {
	
	@Autowired
	private AdDao adDao;

	public List<Creative> getAdList() {
		return adDao.getAdList();
	}

}
