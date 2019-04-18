package com.qianfeng.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianfeng.entity.Staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.ImportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
public class StaffImportExcelController {
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/staffbatch.do")
	@ResponseBody
	public void importExcel(@RequestParam MultipartFile excelFile, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			String fileName = excelFile.getOriginalFilename();
			// 获取上传文件的输入流
			InputStream inputStream = excelFile.getInputStream();
			// 调用工具类中方法，读取excel文件中数据
			List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);

			// 将对象先转为json格式字符串，然后再转为List<Staff> 对象
			ObjectMapper objMapper = new ObjectMapper();
			String infos = objMapper.writeValueAsString(sourceList);

			// json字符串转对象
			List<Staff> list = objMapper.readValue(infos, new TypeReference<List<Staff>>() {});

			// 批量添加
			staffService.addBatch(list);

			response.sendRedirect(request.getContextPath() + "/stafflist.html");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}
}
