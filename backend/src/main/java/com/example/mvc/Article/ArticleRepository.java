package com.example.mvc.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // JpaRepository는 CRUD + 정렬 및 페이징 기능이 추가로 들어가 있고
    // CrudRepository는 기본 CRUD 기능만을 지원한다
}
