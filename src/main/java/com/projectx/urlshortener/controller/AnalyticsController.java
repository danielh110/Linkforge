package com.projectx.urlshortener.controller;

import com.projectx.urlshortener.entity.UrlAnalytics;
import com.projectx.urlshortener.repository.UrlAnalyticsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final UrlAnalyticsRepository analyticsRepository;

    public AnalyticsController(UrlAnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    @GetMapping("/{code}")
    public Long getHits(@PathVariable String code) {
        return analyticsRepository.findByShortCode(code)
                .map(UrlAnalytics::getHitCount)
                .orElse(0L);
    }
}