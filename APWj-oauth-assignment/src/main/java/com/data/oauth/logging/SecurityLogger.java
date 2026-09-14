package com.data.oauth.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class SecurityLogger {

    private static final Logger logger = LoggerFactory.getLogger(SecurityLogger.class);

    @EventListener
    public void onAppStartup(ApplicationReadyEvent event) {
        logger.info("Application startup complete. System is ready.");
    }

    @EventListener
    public void onLoginSuccess(AuthenticationSuccessEvent event) {
        logger.info("Successful user login: {}", event.getAuthentication().getName());
    }

    @EventListener
    public void onLoginFailure(AbstractAuthenticationFailureEvent event) {
        logger.warn("Failed authentication attempt: {}", event.getException().getMessage());
    }

    @EventListener
    public void onLogoutSuccess(LogoutSuccessEvent event) {
        logger.info("User logout successful.");
    }
}