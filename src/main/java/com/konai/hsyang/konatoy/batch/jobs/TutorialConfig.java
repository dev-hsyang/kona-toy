package com.konai.hsyang.konatoy.batch.jobs;

import com.konai.hsyang.konatoy.batch.tasklets.TutorialTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TutorialConfig {

    private final JobBuilderFactory jobBuilderFactory;  // Job 빌더 생성용
    private final StepBuilderFactory stepBuilderFactory;    // Step 빌더 생성용

    // JobBuilderFactory 통해 tutorialJob 생성
    @Bean
    public Job tutorialJob() {
        return jobBuilderFactory.get("tutorialJob")
                .start(tutorialStep()) // step 설정
                .build();
    }

    // StepBuilderFactory 통해 tutorialStep 생성
    @Bean
    public Step tutorialStep() {
        return stepBuilderFactory.get("tutorialStep")
                .tasklet(new TutorialTasklet()) // Tasklet 설정
                .build();
    }
}
