package com.james.api.common.config;
import com.james.api.common.component.interceptor.AuthInterceptor;
//import com.james.api.common.component.interceptor.UserInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
//    private final UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/UserAuth/**", "/api/auth/**", "/api/news/**", "/api/articles/**",
                        "/api/boards/**", "/api/users/**", "/chat/**", "/ws-stomp/**", "/**", "api/**", "/chat/room/**",
                        "/api/admins/**", "/api/transactions/**", "/api/email/**");
    }

}
