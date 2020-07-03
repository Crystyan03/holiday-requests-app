package de.arvato.vacationrequestui.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class SecurityUtils {

    public static Cookie getJwtCookie(HttpServletRequest request) {
        AtomicReference<Cookie> jwtCookie = new AtomicReference<>();
        if (request.getCookies() != null) {
            Arrays.stream(request.getCookies())
                    .filter(c -> "JWT".equals(c.getName()))
                    .findAny().ifPresent(cookie -> {
                jwtCookie.set(cookie);
            });
        }

        return jwtCookie.get();
    }
}
