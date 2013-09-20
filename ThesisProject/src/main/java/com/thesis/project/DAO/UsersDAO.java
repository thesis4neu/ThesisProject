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
import java.util.ArrayList;
import java.util.List;

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
            connection.prepareStatement( "SELECT usertype, exist FROM users WHERE username = ? and password = ?" );
        myUsers.setString( 1, username );
        myUsers.setString( 2, password );
        ResultSet rs = myUsers.executeQuery();
        if( rs.next() )
        {
            userModel = new UsersModel();
            userModel.setUserName( username );
            userModel.setPassword( password );
            userModel.setUserType( rs.getString( "usertype" ) );
            userModel.setExist( rs.getBoolean( "exist" ) );
        }
        rs.close();
        myUsers.close();
        connection.close();

        return userModel;
    }

    /**
     * Temporary Implementation until the other users of the system is implemented
     * 
     * @param userType userType of the users needed
     * @return list of all users of a specific user type
     * @throws SQLException method should be implemented with try catch
     */
    public List<UsersModel> getUsersOfSpecificType( String userType) throws SQLException
    {
        Connection connection = dataSource.getConnection();

        

        //List that will hold all users
        List<UsersModel> listOfUsers = new ArrayList<UsersModel>();

        //temporary query till the students and the other users of the system is implemented
        PreparedStatement user = connection.prepareStatement( "SELECT * FROM users WHERE usertype = ?" );
        user.setString( 1, userType );
        ResultSet rs = user.executeQuery();
        while( rs.next() )
        {
            //model instance
            UsersModel userModel = new UsersModel();

            userModel.setUserName( rs.getString( "username" ) );
            userModel.setPassword( rs.getString( "password" ) );
            userModel.setUserType( rs.getString( "usertype" ) );
            userModel.setExist( rs.getBoolean( "exist" ) );

            listOfUsers.add( userModel );
        }
        rs.close();
        user.close();
        connection.close();

        return listOfUsers;
    }
}
