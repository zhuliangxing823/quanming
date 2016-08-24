package com.ycmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycmedia.dao.AdDao;
import com.ycmedia.entity.Creative;
import com.ycmedia.entity.CreativeTpl;

@Service
public class AdService {
	
	@Autowired
	private AdDao adDao;

	public List<Creative> getAdList() {
		return adDao.getAdList();
	}

	public List<CreativeTpl> getCreativeTpl() {
		
		return adDao.getCreativeTpl();
	}

}
