package com.projectx.urlshortener.repository;

import com.projectx.urlshortener.entity.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface URLRepo extends JpaRepository<ShortenedUrl, String> {
}
