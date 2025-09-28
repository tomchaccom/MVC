package com.example.mvc.Article;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class ArticleForm {
    private Long id; // 추가
    private String title;
    private String content;
    private String author;

    public ArticleForm(Long id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public ArticleForm(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public Article toEntity(Long id) {
        return new Article(id, title, content, author);
    }
    public Article toEntity() {
        return new Article(title,content,author);
    }
}
