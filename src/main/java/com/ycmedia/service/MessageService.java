package com.ycmedia.service;

import com.ycmedia.dao.MessageDao;
import com.ycmedia.entity.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
	@Autowired
	private MessageDao messageDao;

	//短信列表
	public List<MessageLog> messageList() {return messageDao.messageList();}

	//删除短信
	public void deleteMessage(String[] idList) {messageDao.deleteMessage(idList);
	}

}
