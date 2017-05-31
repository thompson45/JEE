package com.zenika.library.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/podium/*")
public class ControllerServlet extends HttpServlet {

	/** UID */
	private static final long serialVersionUID = -3011210046930652555L;
	
	public void doGet(ServletRequest req,  ServletResponse res) throws ServletException, IOException
	{
		//HttpServletRequest.getRequestURL()
		
	}
}
