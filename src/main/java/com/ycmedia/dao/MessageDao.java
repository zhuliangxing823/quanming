package com.ycmedia.dao;

import com.ycmedia.entity.MessageLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

	//信息列表
	List<MessageLog> messageList();

	//删除短信
	void deleteMessage(@Param("idList")String[] idList);
}
