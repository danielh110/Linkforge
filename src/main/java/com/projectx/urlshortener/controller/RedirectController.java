package com.projectx.urlshortener.controller;

import com.projectx.urlshortener.entity.ShortenedUrl;
import com.projectx.urlshortener.exception.NotFoundException;
import com.projectx.urlshortener.service.URLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {

    private final URLService service;

    public RedirectController(URLService service) {
        this.service = service;
    }

    @GetMapping("/{shortURL}")
    public RedirectView redirect(@PathVariable String shortURL) throws NotFoundException {
        return new RedirectView(service.get(shortURL));
    }

    @PostMapping("/shorten")
    public ResponseEntity<ShortenedUrl> saveNewURL(@RequestParam(name = "linkData") String linkData) {
        return ResponseEntity.ok(service.save(linkData));
    }
}
