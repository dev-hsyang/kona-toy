package com.konai.hsyang.konatoy.batch.tasklets;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class TutorialTasklet implements Tasklet {


    // Tasklet에서는 @BeforeStep, @AfterStep을 통해 execute 배치 실행 전 후에 event를 등록하여 실행시킬 수 있다.
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>executed tasklet !!");
        return RepeatStatus.FINISHED;
    }

}
