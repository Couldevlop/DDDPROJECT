package com.openlab.comptabilite.domaine.article;

import com.openlab.comptabilite.domaine.article.model.Article;

import java.util.Optional;

public interface ArticleProvider {
    Article registerArticle(Article article);
    Optional<Article> findByIdArticle(long id);
    Optional<Article> findByRef(String ref);
    void removeArticleById(long idArticle);
}
