/*
 *  Revision History:
 *
 *  DATE/AUTHOR         COMMENT
 *  ---------------------------------------------------------------------
 *  Sep 15, 2013/Forsakendoll                                                       
 */
package com.thesis.project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.thesis.project.models.UsersModel;
import com.thesis.project.utilities.DatabaseCommunication;

/**
 * TODO:Write class description
 * 
 * @author [[mailto:'jrp.mantaring@gmail.com']['James Rod P. Mantaring']]
 */
public class UsersDAO
{
    /**
     * Data source instance
     */
    private final DataSource dataSource;

    /**
     * 
     */
    public UsersDAO()
    {
        dataSource = DatabaseCommunication.getInstance().getDataSource();
    }

    /**
     * @param username username of the user who logged in
     * @param password password of the user who logged in
     * @return userModel of the user who logged in, if exist
     * @throws SQLException method should be implemented with try catch
     */
    public UsersModel getAuthentication( String username, String password ) throws SQLException
    {
        Connection connection = dataSource.getConnection();

        //model instance
        UsersModel userModel = null;

        PreparedStatement myUsers =
            connection.prepareStatement( "SELECT usertype FROM users WHERE username = ? and password = ?" );
        myUsers.setString( 1, username );
        myUsers.setString( 2, password );
        ResultSet rs = myUsers.executeQuery();
        if( rs.next() )
        {
            userModel = new UsersModel();
            userModel.setUserName( username );
            userModel.setPassword( password );
            userModel.setUserType( rs.getString( "usertype" ) );
        }
        rs.close();
        myUsers.close();
        connection.close();

        return userModel;
    }
}
