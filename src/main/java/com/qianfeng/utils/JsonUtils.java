package com.qianfeng.utils;


import com.qianfeng.common.JsonBean;

public class JsonUtils {
	public static JsonBean createJsonBean(int code, Object info) {
		JsonBean jsonBean = new JsonBean();
		jsonBean.setCode(code);
		jsonBean.setInfo(info);
		return jsonBean;
	}
}
