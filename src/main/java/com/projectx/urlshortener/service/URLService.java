package com.projectx.urlshortener.service;

import com.projectx.urlshortener.entity.ShortenedUrl;
import com.projectx.urlshortener.exception.NotFoundException;
import com.projectx.urlshortener.repository.URLRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class URLService {

    final URLRepo repo;

    public URLService(URLRepo repo) {
        this.repo = repo;
    }

    public ShortenedUrl save(String urlStr) {
        ShortenedUrl linkData = ShortenedUrl.builder()
                .fullURL(urlStr)
                .shortenedURL(generateShortURL())
                .date(new Date())
                .build();

        return repo.save(linkData);
    }

    public String get(String compressedLink) throws NotFoundException {
        Optional<ShortenedUrl> linkData = repo.findById(compressedLink);
        if (linkData.isEmpty()) {
            throw new NotFoundException("linkData not found");
        }
        return linkData.get().getFullURL();
    }

    private String generateShortURL() {
        String validCharacters = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int idLength = 10;
        StringBuilder randomId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < idLength; i++) {
            randomId.append(validCharacters.charAt(random.nextInt(validCharacters.length())));
        }
        return randomId.toString();
    }


}
