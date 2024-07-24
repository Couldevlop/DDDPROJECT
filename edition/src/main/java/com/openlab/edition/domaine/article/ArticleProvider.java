package com.openlab.edition.domaine.article;

import com.openlab.edition.domaine.article.model.Article;

import java.util.Optional;

public interface ArticleProvider {
    Article register(Article article);
    Optional<Article> findArticleById(Long id);
}
