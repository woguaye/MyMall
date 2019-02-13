package com.poitest.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poitest.service.PoiTestService;
import com.poitest.service.impl.PoiTestServiceImpl;
import com.poitest.util.ComFunc;

public class PoiTestController extends HttpServlet {
	/**
	 * 如果是get请求就重写doget方法，如果是其他的也是一样对应的
	 * @throws IOException 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		if (ComFunc.checkNullOrEmpty(username)
				|| ComFunc.checkNullOrEmpty(password)) {
			try {
				resp.getWriter().println("username and password woring!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			PoiTestService poiTestService = new PoiTestServiceImpl();
			String user = poiTestService.login(password);
			if(username.equals(user)){
				
				resp.getWriter().println("welcome");
			}
		}
	}
}
