package ch.becare.assessment.process;

import ch.becare.assessment.dao.entity.SessionRecord;
import ch.becare.assessment.dao.entity.SessionStatusEnum;
import ch.becare.assessment.process.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

@Controller
public class PipelineHelper {
    private static final Logger log = LoggerFactory.getLogger(PipelineHelper.class);

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public SessionStatusEnum nextStage(SessionStatusEnum status){
        switch (status) {
            case RECEIVED:
                return SessionStatusEnum.STEP_1;
            case STEP_1:
                return SessionStatusEnum.STEP_2;
            case STEP_2:
                return SessionStatusEnum.PROCESSED;
            default:
                return SessionStatusEnum.RECEIVED;
        }
    }

    public APipelineEvent createEvent(String sessionId, SessionStatusEnum status) {
        switch (status) {
            case STEP_1:
                return new Stage1Event(this, sessionId);
            case STEP_2:
                return new Stage2Event(this, sessionId);
            case PROCESSED:
                return new ProcessedEvent(this, sessionId);
            default:
                return new RecievedEvent(this, sessionId);
        }
    }

    public void publish(String sessionId, SessionStatusEnum status){
        applicationEventPublisher.publishEvent(createEvent(sessionId, status ));
    }

    public void publish(SessionRecord session){
        publish(session.getSessionId(),session.getStatusEnum());
    }

}
