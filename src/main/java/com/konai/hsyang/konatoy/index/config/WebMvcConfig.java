package com.konai.hsyang.konatoy.index.config;

import com.konai.hsyang.konatoy.login.config.LoginInterceptor;
import com.konai.hsyang.konatoy.mypage.config.MypageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**", "/mypage/**");
        registry.addInterceptor(new MypageInterceptor())
                .addPathPatterns("/mypage/**")
                .excludePathPatterns("/api/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
