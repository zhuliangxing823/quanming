package com.ycmedia.entity;

import com.alibaba.fastjson.JSONObject;

public class ParseString {
	
	
	public static void main(String[] args) {
		String txt="1. 2012年5月30日中国银行安徽省分行发放的贷记卡（美元账户）。截至2015年10月，信用额度60,000，已使用额度16,273。最近5年内有1个月处于逾期状态，没有发生过90天以上逾期。";
		
		JSONObject json = new JSONObject();
		txt=txt.replace("。", "，");
		
		
		String [] strs = txt.split("，");
		
		for (String str:strs) {
			
			if(str.contains("（")){
				json.put("账户", str.split("（")[1].substring(0, str.split("（")[1].length()-3));
				System.err.println(str.split("（")[1].substring(0, str.split("（")[1].length()-3));
			}
			if(str.contains("截至")){
				System.err.println(str.substring(2, str.length()));
				json.put("截至", str.substring(2, str.length()));
			}
			if(str.contains("信用额度")){
				System.err.println(str.substring(4, str.length()));
				json.put("信用额度", str.substring(4, str.length()));
			}
			if(str.contains("已使用")){
				System.err.println(str.substring(5, str.length()));
				json.put("已使用额度", str.substring(5, str.length()));
			}
			if(str.contains("逾期")){
				System.err.println("");
			}
			
		}
				
				
		
	}

}
