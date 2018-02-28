package com.youxianqin.dockermgr.models;

public class Permission {
    private Integer id;

    private String comment;

    private String name;

    private String url;

    private Boolean crossService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Boolean getCrossService() {
        return crossService;
    }

    public void setCrossService(Boolean crossService) {
        this.crossService = crossService;
    }
}