package com.URL.Shortener.service;

import com.projectx.urlshortener.entity.ShortenedUrl;
import com.projectx.urlshortener.exception.NotFoundException;
import com.projectx.urlshortener.repository.URLRepo;
import com.projectx.urlshortener.service.URLService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ContextConfiguration(classes = {URLServiceTest.class})
@RunWith(SpringRunner.class)
class URLServiceTest {

    @InjectMocks
    private URLService service;

    @Mock
    private URLRepo repo;

    ShortenedUrl shortenedUrl;
    String urlStr;
    Date date;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        date = new Date();
        shortenedUrl = new ShortenedUrl();
        shortenedUrl.setShortenedURL("randomurl");
        shortenedUrl.setFullURL("http://localhost:8081/" + date.getTime());
        shortenedUrl.setDate(date);
        urlStr = "http://localhost:8081";
    }

    @Test
    void testSave() {
        Mockito.when(repo.save(any(ShortenedUrl.class))).thenReturn(shortenedUrl);
        ShortenedUrl actualRes = service.save(urlStr);
        assertThat(actualRes).isEqualTo(shortenedUrl);
    }

    @Test
    void testGet_Exist() throws NotFoundException {
        Mockito.when(repo.findById(anyString())).thenReturn(Optional.of(shortenedUrl));
        String actualRes = service.get("randomurl");
        assertThat(actualRes).isEqualTo(shortenedUrl.getFullURL());
    }

    @Test
    void testGet_NotExist() {
        Mockito.when(repo.findById(anyString())).thenReturn(Optional.empty());
        Throwable exception = assertThrows(NotFoundException.class, () -> {
            service.get("randomurl1");
        });

        String expectedMessage = "url not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
