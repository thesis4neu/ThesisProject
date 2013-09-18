package com.thesis.project.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String username = request.getParameter( "username" ).isEmpty() ? "" : request.getParameter( "username" );
        String password = request.getParameter( "password" ).isEmpty() ? "" : request.getParameter( "password" );
        UsersModel userModel = null;

        UsersDAO usersDAO = new UsersDAO();
        try
        {
            userModel = usersDAO.getAuthentication( username, password );
            testDrools( userModel );

            // authenticate user, if exist allocate proper controller for the user
            if( authenticateUser( userModel ) )
            {
                allocateProperController( userModel.getUserType(), request, response );
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    /**
     * @param userModel model to verify
     * @return
     */
    public boolean authenticateUser( UsersModel userModel )
    {
        return ( userModel.getPassword().trim().length() != 0 && userModel.getUserType().trim().length() != 0 && userModel.getUserName().trim().length() != 0 );
    }

    /**
     * forward request to the proper controller depending on userType
     * 
     * @param userType userType of the user who logged in
     * @throws IOException
     * @throws ServletException
     */
    public void allocateProperController( String userType, HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException
    {
        RequestDispatcher requestDispatcher = null;

        if( userType.equalsIgnoreCase( "admin" ) )
        {
            requestDispatcher = request.getRequestDispatcher( "admin" );
        }

        requestDispatcher.forward( request, response );
        return;
    }

    /**
     * Test Drools out.
     * 
     * @param userModel object to be evaluated
     */
    public void testDrools( UsersModel userModel )
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
