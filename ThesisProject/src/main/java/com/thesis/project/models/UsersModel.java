/*
 *  Revision History:
 *
 *  DATE/AUTHOR         COMMENT
 *  ---------------------------------------------------------------------
 *  Sep 15, 2013/Forsakendoll                                                       
 */
package com.thesis.project.models;

/**
 * TODO:Write class description
 * 
 * @author [[mailto:'jrp.mantaring@gmail.com']['James Rod P. Mantaring']]
 */
public class UsersModel
{
    /**
     * userName of the user
     */
    private String userName;

    /**
     * password of the user
     */
    private String password;

    /**
     * userType of the user
     */
    private String userType;

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword( String password )
    {
        this.password = password;
    }

    /**
     * @return the userType
     */
    public String getUserType()
    {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType( String userType )
    {
        this.userType = userType;
    }
}
