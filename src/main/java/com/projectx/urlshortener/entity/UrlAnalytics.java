package com.projectx.urlshortener.entity;

import jakarta.persistence.*;

@Entity
public class UrlAnalytics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;

    private Long hitCount = 0L;

    public UrlAnalytics() {
    }

    public UrlAnalytics(String shortCode) {
        this.shortCode = shortCode;
        this.hitCount = 1L;
    }

    public Long getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void incrementHit() {
        this.hitCount++;
    }

    public Long getHitCount() {
        return hitCount;
    }
}