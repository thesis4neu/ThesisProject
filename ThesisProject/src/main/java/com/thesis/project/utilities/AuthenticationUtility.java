/*
 *  Revision History:
 *
 *  DATE/AUTHOR         COMMENT
 *  ---------------------------------------------------------------------
 *  Sep 18, 2013/Forsakendoll                                                      
 */
package com.thesis.project.utilities;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * TODO:Write class description
 *
 * @author [[mailto:'jrp.mantaring@gmail.com']['James Rod P. Mantaring']]
 */
public class AuthenticationUtility
{
    /**
     * @param request
     * @param response
     * @param session
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean isNotLoggedIn( HttpServletRequest request, HttpServletResponse response, HttpSession session )
        throws ServletException, IOException
    {
        RequestDispatcher rd;

        if( session == null || session.getAttribute( "usertype" ) == null )
        {
            request.setAttribute( "errorMessage", "Please log in first." );
            rd = request.getRequestDispatcher( "WEB-INF/JSPs/login.jsp" );
            rd.forward( request, response );
            return true;
        }
        return false;
    }

    /**
     * @param request
     * @param response
     * @param session
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean isUserExist( HttpServletRequest request, HttpServletResponse response, HttpSession session )
        throws ServletException, IOException
    {
        return !( session == null || session.getAttribute( "usertype" ) == null );
    }
}
