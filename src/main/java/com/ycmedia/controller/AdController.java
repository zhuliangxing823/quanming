package com.ycmedia.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycmedia.entity.Creative;
import com.ycmedia.entity.CreativeTpl;
import com.ycmedia.entity.User;
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
	
	Creative creative = new Creative();
	
	CreativeTpl tpl = new CreativeTpl();

	/**
	 * 查询广告列表
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	// @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
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
	
	/**tpl-add
	 * 跳转到编辑广告
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/product-edit")
	public ModelAndView  toEditAd(@RequestParam("id")String id ,Creative creative){
		creative = adservice.findAdById(id);
		return new ModelAndView("product-add" ,"creative",creative );
	}
	
	/**
	 * 
	 * 跳转到编辑广告
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/tpl-add")
	public ModelAndView  toTplAdd(@ModelAttribute(value="tpl")CreativeTpl tpl){
		return new ModelAndView("tpl-add" );
	}
	
	
	/**
	 * 审核内容修改
	 * @param creative
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editAd")
	public ModelAndView  editAdReason(@ModelAttribute(value="creative")Creative creative,Model model ){
		try {
			adservice.updateCreative(creative);
			model.addAttribute("success", true);
		} catch (Exception e) {
			model.addAttribute("success", false);
			
		}
		return  new ModelAndView("redirect:/product-list");
	}

}
