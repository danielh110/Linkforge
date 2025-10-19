package com.projectx.urlshortener.repository;

import com.projectx.urlshortener.entity.UrlAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlAnalyticsRepository extends JpaRepository<UrlAnalytics, Long> {
    Optional<UrlAnalytics> findByShortCode(String shortCode);
}