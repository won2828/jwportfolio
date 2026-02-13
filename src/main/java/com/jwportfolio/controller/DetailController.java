package com.jwportfolio.controller;

import com.jwportfolio.dto.Portfolio;
import com.jwportfolio.service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/detail")
@RequiredArgsConstructor
public class DetailController {

    private final PortfolioService portfolioService;

    @GetMapping
    public String detail(
            @RequestParam Long id,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        Portfolio work = portfolioService.findById(id)
                .orElse(null);

        if (work == null) {
            return "redirect:/";
        }

        List<Portfolio> allWorks = portfolioService.findAll();
        int index = -1;
        for (int i = 0; i < allWorks.size(); i++) {
            if (id.equals(allWorks.get(i).getId())) {
                index = i;
                break;
            }
        }

        Portfolio prevWork = index > 0 ? allWorks.get(index - 1) : null;
        Portfolio nextWork = index >= 0 && index < allWorks.size() - 1 ? allWorks.get(index + 1) : null;

        model.addAttribute("work", work);
        model.addAttribute("prevWork", prevWork);
        model.addAttribute("nextWork", nextWork);
        return "detail";
    }
}
