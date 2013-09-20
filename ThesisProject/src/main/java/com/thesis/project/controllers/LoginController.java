package com.thesis.project.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.drools.KnowledgeBase;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.thesis.project.AI.IntelligenceManager;
import com.thesis.project.DAO.UsersDAO;
import com.thesis.project.models.UsersModel;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
        IOException
    {
        RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/JSPs/login.jsp" );
        rd.forward( request, response );
        return;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
        IOException
    {
        HttpSession session = request.getSession();

        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );

        UsersModel userModel = null;
        UsersDAO usersDAO = new UsersDAO();

        try
        {
            userModel = usersDAO.getAuthentication( username, password );


            // authenticate user, if exist allocate proper controller for the user
            if( userModel != null )
            {
                // test drools
                testDrools( userModel );

                session.setAttribute( "username", userModel.getUserName() );
                session.setAttribute( "usertype", userModel.getUserType() );

                allocateProperController( userModel.getUserType(), request, response );
            }
            else
            {
                request.setAttribute( "errorMessage", "Invalid Username / Password " );
                doGet( request, response );
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
            request.setAttribute( "errorMessage", "Internal Error" );
            doGet( request, response );
        }
    }

    /**
     * forward request to the proper controller depending on userType
     * 
     * @param userType userType of the user who logged in
     * @throws IOException
     * @throws ServletException
     */
    private void allocateProperController( String userType, HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = null;

        if( userType.equalsIgnoreCase( "admin" ) )
        {
            requestDispatcher = request.getRequestDispatcher( "admin" );
        }
        else if( userType.equalsIgnoreCase( "student" ) )
        {
            requestDispatcher = request.getRequestDispatcher( "student" );
        }
        else if( userType.equalsIgnoreCase( "tutor" ) )
        {
            requestDispatcher = request.getRequestDispatcher( "tutor" );
        }
        else
        {
            requestDispatcher = request.getRequestDispatcher( "WEB-INF/JSPs/login.jsp" );
        }

        requestDispatcher.forward( request, response );
        return;
    }

    /**
     * Test Drools out.
     * 
     * @param userModel object to be evaluated
     */
    private void testDrools( UsersModel userModel )
    {
        IntelligenceManager im = new IntelligenceManager();
        try
        {
            // load up the knowledge base
            KnowledgeBase kbase = im.readKnowledgeBase( "Rules.drl" );
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger( ksession, "test" );
            // go !         
            ksession.insert( userModel );
            ksession.fireAllRules();
            logger.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

}
