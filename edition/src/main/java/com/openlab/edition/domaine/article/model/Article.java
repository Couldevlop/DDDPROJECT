package com.openlab.edition.domaine.article.model;

import com.openlab.edition.domaine.article.ArticleProvider;
import com.openlab.edition.domaine.article.Status;

public class Article {
    private long idArticle;
    private String title;
    private Status status;
    private String content;
    private String domaine;
    private ArticleProvider articleProvider;



    private Article(ArticleBuilder builder) {
        this.idArticle = builder.idArticle;
        this.title = builder.title;
        this.status = builder.status;
        this.content = builder.content;
        this.domaine = builder.domaine;
        this.articleProvider = builder.articleProvider;
    }


    public static class ArticleBuilder{
        private long idArticle;
        private String title;
        private Status status;
        private String content;
        private String domaine;
        private ArticleProvider articleProvider;

        public ArticleBuilder idArticle(Long idArticle){
            this.idArticle = idArticle;
            return this;
        }

        public ArticleBuilder title(String title){
            this.title = title;
            return this;
        }


        public ArticleBuilder status(Status status){
            this.status = status;
        return this;
        }


        public ArticleBuilder content(String content){
            this.content = content;
            return this;
        }

        public ArticleBuilder domaine(String domaine){
            this.domaine = domaine;
            return this;
        }


        public ArticleBuilder articleProvider(ArticleProvider articleProvider){
            this.articleProvider = articleProvider;
            return this;
        }

        public Article build(){
            return new Article(this);
        }
    }


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

    public ArticleProvider getArticleProvider() {
        return articleProvider;
    }
}





