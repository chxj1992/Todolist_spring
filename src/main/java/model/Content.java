package model;

import java.sql.Timestamp;

/**
 * 内容数据模型
 * Author: chen
 * DateTime: 1/8/14 9:11 AM
 */
public class Content {

    private Integer contentId;

    private Integer userId;

    private String context;

    private Timestamp updateTime;


    public Content() {
    }

    public Content(Integer userId, String context) {
        this.userId = userId;
        this.context = context;
    }

    public Content(Integer contentId, Integer userId, String context, Timestamp updateTime) {
        this.contentId = contentId;
        this.userId = userId;
        this.context = context;
        this.updateTime = updateTime;
    }

    /********************************************
     * Getters
     *******************************************/

    public Integer getContentId() {
        return contentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getContext() {
        return context;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }


    /**************************************
     * Setters
     *************************************/

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setContext(String context) {
        this.context = context;
    }

}
