package com.rek.web;

import java.io.IOException;

import com.rek.web.dao.Aliendao;
import com.rek.web.model.Alien;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;


public class getAlienController extends HttpServlet {
	
	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("aid"));
		
		Aliendao dao = new Aliendao();
		Alien a1 = dao.getAlien(uid);
		
		request.setAttribute("alien", a1);
		
		RequestDispatcher rd = request.getRequestDispatcher("showAlienJSP.jsp");
		rd.forward(request, response);
	}

	

}
