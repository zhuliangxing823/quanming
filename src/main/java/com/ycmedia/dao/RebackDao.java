package com.ycmedia.dao;

import com.ycmedia.entity.Reback;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebackDao {

	//意见反馈列表
	List<Reback> rebackList();

	//删除
	void deleteReback(@Param("idList") String[] idList);
}
