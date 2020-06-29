package com.yoga.User.util;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Supplier;

@Service
public class WebClientUtil {

    public Supplier<String> invokeSecurityForPwd(final String pwd) {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8085").build();
        return () -> (webClient.post().uri("/encrypt")
                .bodyValue(pwd)
                .retrieve()
                .bodyToMono(String.class)
                .block());
    }
}
