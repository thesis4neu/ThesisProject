/*
 *  Revision History:
 *
 *  DATE/AUTHOR         COMMENT
 *  ---------------------------------------------------------------------
 *  Sep 15, 2013/Forsakendoll                                                       
 */
package com.thesis.project.utilities;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * TODO:Write class description
 * 
 * @author [[mailto:'jrp.mantaring@gmail.com']['James Rod P. Mantaring']]
 */
public class DatabaseCommunication
{
    public static DatabaseCommunication getInstance()
    {
        return DatabaseCommunicationHolder.INSTANCE;
    }

    /**
     * private declaration of dataSource variable to avoid instanciation
     */
    private DataSource dataSource;

    /**
     * @param source of the connection
     * @return returns the data source of the instance
     */
    public synchronized DataSource getDataSource( String source )
    {
        if( dataSource == null )
        {
            InitialContext cxt = null;
            try
            {
                cxt = new InitialContext();
            }
            catch( NamingException e )
            {

            }

            try
            {
                dataSource = ( DataSource ) cxt.lookup( "java:/comp/env/" + source );
            }
            catch( NamingException e )
            {

            }
        }
        return dataSource;
    }

    /**
     * @return returns data source instance
     */
    public synchronized DataSource getDataSource()
    {
        if( dataSource == null )
        {
            InitialContext cxt = null;
            try
            {
                cxt = new InitialContext();
            }
            catch( NamingException e )
            {

            }
            try
            {
                dataSource = ( DataSource ) cxt.lookup( "java:/comp/env/jdbc/THESIS" );
            }
            catch( NamingException e )
            {

            }
        }
        return dataSource;
    }

    /**
     * TODO:Write class description
     * 
     * @author [[mailto:jrp.mantaring@gmail.com]['James Rod P. Mantaring']]
     */
    private static class DatabaseCommunicationHolder
    {
        /**
         * instanciates DatabaseCommunication
         */
        public static final DatabaseCommunication INSTANCE = new DatabaseCommunication();
    }
}
