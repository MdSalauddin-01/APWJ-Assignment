package com.data.oauth.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserApi {

    private static final Logger logger = LoggerFactory.getLogger(UserApi.class);

    @GetMapping("/me")
    public Map<String, Object> getCurrentUser(@AuthenticationPrincipal OAuth2User user) {
        logger.info("Accessing protected endpoint: /api/user/me");

        Map<String, Object> userInfo = new HashMap<>();
        if (user != null) {
            userInfo.put("name", user.getAttribute("name"));
            userInfo.put("email", user.getAttribute("email"));
        }
        return userInfo;
    }
}