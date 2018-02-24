package com.youxianqin.dockermgr.models;

public class Marathon {
    private Integer id;

    private String server;

    private String httpBasicAuthUser;

    private String httpBasicPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server == null ? null : server.trim();
    }

    public String getHttpBasicAuthUser() {
        return httpBasicAuthUser;
    }

    public void setHttpBasicAuthUser(String httpBasicAuthUser) {
        this.httpBasicAuthUser = httpBasicAuthUser == null ? null : httpBasicAuthUser.trim();
    }

    public String getHttpBasicPassword() {
        return httpBasicPassword;
    }

    public void setHttpBasicPassword(String httpBasicPassword) {
        this.httpBasicPassword = httpBasicPassword == null ? null : httpBasicPassword.trim();
    }
}