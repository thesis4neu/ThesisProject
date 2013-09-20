package com.thesis.project.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
        IOException
    {
        request.getSession().setAttribute( "username", request.getSession().getAttribute( "username" ) );
        request.getSession().setAttribute( "username", request.getSession().getAttribute( "usertype" ) );

        RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/JSPs/student/body/student_home.jsp" );
        rd.forward( request, response );
        return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
        IOException
    {
        doGet( request, response );
	}

    /**
     * @param queryStringParam requested query string
     * @return jsp path to view
     */
    private String pageToView( String queryStringParam )
    {
        // pages hasn't decided yet
        String path = null;
        if( queryStringParam.equals( "home" ) )
        {
            path = "WEB-INF/JSPs/admin-tutor/body/admin_home.jsp";
        }
        else if( queryStringParam.equals( "flt" ) )
        {
            path = "WEB-INF/JSPs/admin-tutor/body/FLT.jsp";
        }
        else if( queryStringParam.equals( "modules" ) )
        {
            path = "WEB-INF/JSPs/admin-tutor/body/modules.jsp";
        }
        else if( queryStringParam.equals( "users" ) )
        {
            path = "WEB-INF/JSPs/admin-tutor/body/users.jsp";
        }
        else
        {

        }
        return path;
    }

}
