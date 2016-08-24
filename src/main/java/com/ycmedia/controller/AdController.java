package com.ycmedia.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycmedia.entity.Creative;
import com.ycmedia.entity.CreativeTpl;
import com.ycmedia.service.AdService;

/**
 * 广告controller
 * 
 * @author zhuliangxing
 *
 */
@Controller
public class AdController {

	@Autowired
	private AdService adservice;

	/**
	 * 查询广告列表
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/product-list")
	@ResponseBody
	public ModelAndView getAdList(
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate) {
		List<Creative> list = new ArrayList<Creative>();
		try {
			list = adservice.getAdList();
		} catch (Exception e) {

		}

		return new ModelAndView("product-list", "list", list);
	}

	/**
	 * 查询创意模板
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping(value = "/creativetpl-list")
	@ResponseBody
	public ModelAndView getCreativeList(
			@RequestParam(value = "beginDate", required = false) Date beginDate,
			@RequestParam(value = "endDate", required = false) Date endDate) {
		List<CreativeTpl> list = new ArrayList<CreativeTpl>();
		try {
			list = adservice.getCreativeTpl();
		} catch (Exception e) {

		}

		return new ModelAndView("creativetpl-list", "list", list);
	}

}
