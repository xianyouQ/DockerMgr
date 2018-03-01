package com.youxianqin.dockermgr.models;

public class RoleUser {
    private Integer id;



    private Integer userId;


    private User user;

    private Integer serivceId;
    private Integer baseRoleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSerivceId() {
        return serivceId;
    }

    public void setSerivceId(Integer serivceId) {
        this.serivceId = serivceId;
    }

    public Integer getBaseRoleId() {
        return baseRoleId;
    }

    public void setBaseRoleId(Integer baseRoleId) {
        this.baseRoleId = baseRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}