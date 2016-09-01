package com.ycmedia.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * @author 朱良兴 七牛 图片服务器 操作展示层
 *
 */
@Controller
public class QiniuImgController {

	UploadManager um = new UploadManager();
	public static final String AK = "rzPOFiue_68j1lOwApPw4qjSxf8BkXB1CGJF6R6j";
	public static final String SK = "TMqFfkz-2ASmgpk051gqPOx-sRdwvZHgbZAmwQ0g";
	Auth auth = Auth.create(AK, SK);

	/**
	 * @param fileName
	 *            文件地址
	 * @param dirBundle
	 *            文件目录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public Map<String, Object> uploadImgFile(@RequestParam("fileName") String fileName,
			@RequestParam("dirBundle") String dirBundle) throws Exception {
		// String token =auth.uploadToken(dirBundle);
		Map<String,Object> map  = new HashMap<String,Object>();
		String token = auth.uploadToken(dirBundle, null, 3600, null);
		String str=uploadFile(fileName,token);
//		String str=uploadFile("D:\\user\\1.gif",token);
		String lastFileName="http://o9gl8g305.bkt.clouddn.com//"+str;
		
		if(!lastFileName.equals("")){
			map.put("success", true);
			map.put("path", lastFileName);
		}else{
			map.put("success", false);
			map.put("path", "");
		}
		return map;
		
		
	}

	public String uploadFile(String path,String token) {
		String fileName= "quanmin_"+new Date().getTime()+".jpg";
		
		try {
			Response res = um.put(path, fileName,
					token);
			return fileName;
		} catch (QiniuException e) {
			
			return "";
		}
		
	}
	
	
	
	public void showAllFiles(File dir, String token) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {
				try {
					showAllFiles(fs[i], "");
				} catch (Exception e) {
				}
			} else {
				System.err.println(fs[i].getAbsolutePath());
				// 调用put方法上传
				Response res = um.put(fs[i].getAbsolutePath(), fs[i].getName(),
						token);
				// 打印返回的信息
				System.out.println(res.bodyString());

			}
		}
	}

}
