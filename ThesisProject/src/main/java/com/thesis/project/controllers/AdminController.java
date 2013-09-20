package com.thesis.project.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thesis.project.DAO.UsersDAO;
import com.thesis.project.models.UsersModel;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Dispatcher of admin controller
     */
    RequestDispatcher rd = null;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
        IOException
    {
        HttpSession session = request.getSession();
        // BZ 1
        /*if( AuthenticationUtility.isNotLoggedIn( request, response, session ) )
        {*/
            String queryStringParam = request.getParameter( "main" );

            request.getSession().setAttribute( "username", request.getSession().getAttribute( "username" ) );
            request.getSession().setAttribute( "usertype", request.getSession().getAttribute( "usertype" ) );


            rd = request.getRequestDispatcher( "WEB-INF/JSPs/admin-tutor/body/admin_home.jsp" );

            if( queryStringParam != null )
            {
                if( queryStringParam.trim().length() > 0 )
                {
                pageToView( queryStringParam, request, response );
                }
            }
        //BZ 3 I think all controllers will have same request since I'm only passing same request to the method
            rd.forward( request, response );
            return;
        /*}*/
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
    private void pageToView( String queryStringParam, HttpServletRequest request, HttpServletResponse response )
    {
        String path = null;
        if( queryStringParam.equals( "home" ) )
        {
            rd = request.getRequestDispatcher( "WEB-INF/JSPs/admin-tutor/body/admin_home.jsp" );
        }
        else if( queryStringParam.equals( "flt" ) )
        {
            rd = request.getRequestDispatcher( "WEB-INF/JSPs/admin-tutor/body/FLT.jsp" );
        }
        else if( queryStringParam.equals( "modules" ) )
        {
            rd = request.getRequestDispatcher( "WEB-INF/JSPs/admin-tutor/body/modules.jsp" );
        }
        else if( queryStringParam.equals( "users" ) )
        {
            manageUsersController( request, response );
        }
        else
        {

        }
    }

    /**
     * ManageUsers Controller
     * 
     * @param request request from the main dispatcher
     * @param response request from the main dispatcher
     * @throws IOException exception
     * @throws ServletException exception
     */
    private void manageUsersController( HttpServletRequest request, HttpServletResponse response )
    {
        UsersDAO usersDAO = new UsersDAO();

        try
        {
            List<UsersModel> userList = usersDAO.getUsersOfSpecificType( "student" );
            if( userList != null )
            {
                request.setAttribute( "userList", userList );
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        rd = request.getRequestDispatcher( "WEB-INF/JSPs/admin-tutor/body/users.jsp" );

    }
}
