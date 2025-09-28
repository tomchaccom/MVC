package com.example.mvc.Article;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;

    // 글 목록
    @GetMapping
    public String list(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "list";
    }

    // 작성 폼
    @GetMapping("/new")
    public String newForm(@ModelAttribute("articleForm") ArticleForm articleForm) {
        return "new";
    }

    // 글 저장
    @PostMapping("/new")
    public String create(@ModelAttribute("articleForm") ArticleForm form) {
        articleRepository.save(form.toEntity());
        return "redirect:/articles";
    }

    // 글 상세 조회
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElseThrow();
        model.addAttribute("article", article);
        return "detail";
    }

    // 수정 폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Article article = articleRepository.findById(id).orElseThrow();
        ArticleForm form = new ArticleForm(article.getTitle(), article.getContent(), article.getAuthor());
        model.addAttribute("articleForm", form);
        model.addAttribute("id", article.getId());
        return "edit";
    }

    // 글 수정
    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute("articleForm") ArticleForm form) {
        Article updatedArticle = form.toEntity(id);
        articleRepository.save(updatedArticle);
        return "redirect:/articles/" + id;
    }

    // 글 삭제
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }
}
