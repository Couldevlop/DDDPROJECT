package com.openlab.comptabilite.domaine.article.model;

import com.openlab.comptabilite.domaine.article.ArticleProvider;

public class Article {
    private long idArticle;
    private String reference;
    private double nbrVues;
    private ArticleProvider articleProvider;


    private Article(ArticleBuilder build) {
        this.idArticle = build.idArticle;
        this.reference = build.reference;
        this.nbrVues = build.nbrVues;
        this.articleProvider = build.articleProvider;
    }


    public static class ArticleBuilder{
        private long idArticle;
        private String reference;
        private double nbrVues;
        private ArticleProvider articleProvider;


        public ArticleBuilder idArticle(long idArticle){
            this.idArticle = idArticle;
            return this;
        }

        public ArticleBuilder reference(String reference){
            this.reference = reference;
            return this;
        }

        public ArticleBuilder nbrVues(double nbrVues){
            this.nbrVues = nbrVues;
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

    public String getReference() {
        return reference;
    }

    public double getNbrVues() {
        return nbrVues;
    }

    public ArticleProvider getArticleProvider() {
        return articleProvider;
    }
}
