package com.jwportfolio.controller;

import com.jwportfolio.dto.Portfolio;
import com.jwportfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    private final PortfolioService portfolioService;

    @GetMapping("/all")
    public ResponseEntity<List<Portfolio>> getAll() {
        return ResponseEntity.ok(portfolioService.findAll());
    }

    @GetMapping("/illustration")
    public ResponseEntity<List<Portfolio>> getIllustration() {
        return ResponseEntity.ok(portfolioService.findByCategory("illustration"));
    }

    @GetMapping("/animation")
    public ResponseEntity<List<Portfolio>> getAnimation() {
        return ResponseEntity.ok(portfolioService.findByCategory("animation"));
    }

    @GetMapping("/design")
    public ResponseEntity<List<Portfolio>> getDesign() {
        return ResponseEntity.ok(portfolioService.findByCategory("design"));
    }
}
