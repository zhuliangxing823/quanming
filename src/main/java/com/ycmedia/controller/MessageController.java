package com.ycmedia.controller;

import com.ycmedia.entity.MessageLog;
import com.ycmedia.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;



	/**
	 * 短信列表<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月29日13:52:43
	 *
	 * @param
	 * @return messageList 客户列表数据(跳转列表页面)
	 * */
	@RequestMapping(value = "/message-list")
	@ResponseBody
	public ModelAndView getMessageList() {
		List<MessageLog> messageList = new ArrayList<>();
		try {
			messageList = messageService.messageList();
		} catch (Exception e) {

		}
		return new ModelAndView("message-list", "messageList", messageList);
	}

	/**
	 * 删除短信<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月29日14:29:42
	 *
	 * @return Map 提示信息
	 * */
	@RequestMapping(value = "/delete-message")
	@ResponseBody
	public Map<String, Object> deleteMessage(HttpServletRequest request){
		String[] idList =request.getParameter("id_list").split(",");
		Map<String, Object> result = new HashMap<>();
		try{
			messageService.deleteMessage(idList);
			result.put("status",true);
			result.put("message","删除成功");
		}catch (Exception e){
			result.put("status",false);
			result.put("message","删除异常");
		}
		return result;
	}

}
