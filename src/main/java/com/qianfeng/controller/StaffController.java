package com.qianfeng.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qianfeng.common.JsonBean;
import com.qianfeng.entity.Staff;
import com.qianfeng.service.StaffService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@ResponseBody
public class StaffController<list> {

	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "/photoupload.do", method = RequestMethod.POST)
	public String uploadHead(@RequestParam("file") MultipartFile file, HttpSession session) {
		try {
			if (file != null) {
				//获取上传文件的原名
                String fileName = file.getOriginalFilename();
				//截取扩展名
				String extName = fileName.substring(fileName.lastIndexOf("."));
				List list = new ArrayList();
				list.add(".jpg");
				list.add(".png");
				list.add(".jpeg");
				list.add(".gif");
				if(list.contains(extName.toLowerCase())){

					//01获取服务器项目部署的路径，并在根目录下创建 myphoto 目录
					String realPath = session.getServletContext().getRealPath("myphoto");
					//02也可以直接定义文件路径
					//String realPath = "D:\\space\\SSMBase\\src\\main\\webapp\\img";

					String photoFileName = new Date().getTime()+extName;
					String descPath = realPath + "\\" + photoFileName;
					System.out.println(descPath);
					file.transferTo(new File(realPath, photoFileName));
					return descPath;//成功
				}else {
					return "-1";//文件类型不正确
				}
			}else {
				return "0";//上传文件为空
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "-1";//上传异常
		}
	}

	@RequestMapping("/staffpage.do")
	public Map<String, Object> listStaff(int page){
		PageHelper.startPage(page, 10);
		Map<String, Object> map = new HashMap<>();
		try {
			List<VStaff> list = staffService.sstaffFindAll();
			long total = ((Page)list).getTotal();
			map.put("code", 0); // 0表示成功
			map.put("msg", "");
			map.put("count", total);
			map.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

    @RequestMapping("/staffadd.do")
    public void addStaff(Staff sta, HttpServletRequest request, HttpServletResponse response) throws IOException {
        staffService.saddStaff(sta);
        response.sendRedirect(request.getContextPath() + "/stafflist.html");
    }

    @RequestMapping("/staffdelete.do")
	public JsonBean deleteStaff(String no){
		staffService.sdeleteStaffByNo(no);
		return JsonUtils.createJsonBean(1, null);
	}
	
	@RequestMapping("/staffquery.do")
	public JsonBean queryStaffByNo(String no){
        Staff staff = staffService.sfindStaffByNo(no);
		return JsonUtils.createJsonBean(1, staff);
	}
	
	@RequestMapping("/staffupdate.do")
	public void updateStaff(Staff sta, HttpServletRequest request, HttpServletResponse response) throws IOException {
        staffService.supdateStaff(sta);
		response.sendRedirect(request.getContextPath() + "/stafflist.html");
	}

	@RequestMapping("/staffall.do")
	public List<Staff> selectAllRecruiter(){
		return staffService.selectAllRecruiter();
	}
}
