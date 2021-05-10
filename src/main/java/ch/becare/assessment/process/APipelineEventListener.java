package ch.becare.assessment.process;

import ch.becare.assessment.dao.entity.SessionStatusEnum;
import ch.becare.assessment.process.event.APipelineEvent;
import ch.becare.assessment.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
//@Async
public abstract class APipelineEventListener {
    private static final Logger log = LoggerFactory.getLogger(APipelineEventListener.class);

    @Autowired
    SessionService sessionService;
    @Autowired
    PipelineHelper pipelineHelper;

    public void onStage(APipelineEvent pipelineEvent){
        SessionStatusEnum nextStage= pipelineHelper.nextStage(pipelineEvent.getStage());

        //SessionRecord sessionRecord=sessionService.get(event.getSessionId());
        sessionService.updateStatus(pipelineEvent.getSessionId(), nextStage);

        pipelineHelper.publish(pipelineEvent.getSessionId(), nextStage);
    }
}
