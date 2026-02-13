package com.jwportfolio.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwportfolio.dto.Portfolio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Portfolio> portfolioList = Collections.emptyList();

    @PostConstruct
    public void loadPortfolioData() {
        try {
            ClassPathResource resource = new ClassPathResource("data/portfolio.json");
            try (InputStream is = resource.getInputStream()) {
                portfolioList = objectMapper.readValue(is, new TypeReference<List<Portfolio>>() {});
            }
        } catch (IOException e) {
            throw new RuntimeException("portfolio.json 로드 실패", e);
        }
    }

    public List<Portfolio> findAll() {
        return portfolioList;
    }

    public List<Portfolio> findByCategory(String category) {
        return portfolioList.stream()
                .filter(p -> category.equalsIgnoreCase(p.getCategory()))
                .toList();
    }

    public Optional<Portfolio> findById(Long id) {
        return portfolioList.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst();
    }
}
