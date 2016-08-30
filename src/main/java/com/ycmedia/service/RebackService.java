package com.ycmedia.service;

import com.ycmedia.dao.RebackDao;
import com.ycmedia.entity.Reback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebackService {
	@Autowired
	private RebackDao rebackDao;

	//短信列表
	public List<Reback> rebackList() {return rebackDao.rebackList();}

	//删除短信
	public void deleteReback(String[] idList) {rebackDao.deleteReback(idList);
	}

}
