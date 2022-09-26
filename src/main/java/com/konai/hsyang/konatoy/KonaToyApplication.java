package com.konai.hsyang.konatoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@EnableJpaAuditing
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class}) // 스프링부트 특성 중 하나인 어플리케이션 스프링 설정의 자동 구성에서 첨부파일 관련 자동 구성을 사용하지 않도록 명시. configuration에서 multipartResolver를 등록했기 깨문
public class KonaToyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KonaToyApplication.class, args);
    }

}
