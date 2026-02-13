package com.jwportfolio.controller;

import com.jwportfolio.dto.Portfolio;
import com.jwportfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class GalleryController {

    private final PortfolioService portfolioService;

    @GetMapping
    public String gallery(
            @RequestParam(required = false) String category,
            Model model
    ) {
        List<Portfolio> works = category != null && !category.isBlank()
                ? portfolioService.findByCategory(category)
                : portfolioService.findAll();

        model.addAttribute("works", works);
        model.addAttribute("currentCategory", category != null ? category : "");
        return "gallery";
    }
}
