package com.openlab.edition.domaine.model.article;

public class Article {
    private long idArticle;
    private String title;
    private Status status;
    private String content;
    private String domaine;


    public long getIdArticle() {
        return idArticle;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }

    public String getDomaine() {
        return domaine;
    }
}
