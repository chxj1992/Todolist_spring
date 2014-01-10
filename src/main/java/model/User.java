package model;

import java.sql.Timestamp;

/**
 * 用户模型
 * Author: chen
 * DateTime: 1/7/14 2:47 PM
 */
public class User {

    private Integer userId;

    private String userName;

    private String password;

    private Timestamp createTime;

    public User() {}

    public User(Integer userId, String userName, String password, Timestamp createTime) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createTime = createTime;
    }

    /****************************************
     * Getters
     ***************************************/

    public Integer getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    /****************************************
     * Setters
     ***************************************/

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
