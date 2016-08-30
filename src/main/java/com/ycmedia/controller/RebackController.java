package com.ycmedia.controller;

import com.ycmedia.entity.MessageLog;
import com.ycmedia.entity.Reback;
import com.ycmedia.service.RebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class RebackController {

	@Autowired
	private RebackService rebackService;



	/**
	 * 意见反馈列表<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月29日14:57:14
	 *
	 * @param
	 * @return rebackList 意见反馈列表数据(跳转列表页面)
	 * */
	@RequestMapping(value = "/reback-list")
	@ResponseBody
	public ModelAndView getRebackList() {
		List<Reback> rebackList = new ArrayList<>();
		try {
			rebackList = rebackService.rebackList();
		} catch (Exception e) {

		}
		return new ModelAndView("reback-list", "rebackList", rebackList);
	}

	/**
	 * 删除意见反馈信息<br />
	 * Author:zhanglei<br />
	 * UpdateTime:2016年8月29日14:57:10
	 *
	 * @return Map 提示信息
	 * */
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/delete-reback")
	@ResponseBody
	public Map<String, Object> deleteReback(HttpServletRequest request){
		String[] idList =request.getParameter("id_list").split(",");
		Map<String, Object> result = new HashMap<>();
		try{
			rebackService.deleteReback(idList);
			result.put("status",true);
			result.put("message","删除成功");
		}catch (Exception e){
			result.put("status",false);
			result.put("message","删除异常");
		}
		return result;
	}

}
