    package com.example.mvc.Article;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;

    import java.time.LocalDateTime;

    /*
    * 필드: id(Long), title(String), content(String), author(String), createdAt(LocalDateTime)
    @PrePersist를 이용해 createdAt 자동 저장(각자 자료를 찾아서 방법과 구조를 이해할 것)
    *
    * */

    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public class Article {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String content;
        private String author;

        private LocalDateTime createdAt;

        @PrePersist // Entity 가 DB에 Insert(영속화) 되기 전에 실행되는 메소드를 의미, @preUpdate도 있음
        protected void onCreate() {
            this.createdAt = LocalDateTime.now();
        }
        // @PerPersist를 사용하면 정확하게 DB에 저장되는 시점으로 createdAt이 저장, 객체의 생성 시점과는 다름
    }
