package com.qikemi.packages.verificateCode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qikemi.packages.verificateCode.bean.ValidateCode;

/**
 * Validate Code Servlet 
 * 
 * Create Date: 2014年10月5日 下午4:14:43
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/verificate-code>
 */
public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest reqeust,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		HttpSession session = reqeust.getSession();

		// Code Entity
		ValidateCode validateCode = new ValidateCode(120, 40, 5, 100);
		// Create
		ValidateCodeCreator validateCodeCreator = new ValidateCodeCreator();
		validateCodeCreator.createCode(validateCode);

		// 对存放的code进行base64加密处理
		session.setAttribute("code", validateCode.getCode());
		validateCodeCreator.write(response.getOutputStream());
	}
	/**
	 * web.xml 添加servlet <servlet>
	 * <servlet-name>validateCodeServlet</servlet-name>
	 * <servlet-class>com.qikemi
	 * .packages.verificateCode.ValidateCodeServlet</servlet-class> </servlet>
	 * <servlet-mapping> <servlet-name>validateCodeServlet</servlet-name>
	 * <url-pattern>*.images</url-pattern> </servlet-mapping>
	 * 
	 * 在地址栏输入XXX/dsna.images 测试
	 */

}