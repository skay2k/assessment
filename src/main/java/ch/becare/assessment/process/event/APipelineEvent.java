package ch.becare.assessment.process.event;

import ch.becare.assessment.dao.entity.SessionStatusEnum;
import org.springframework.context.ApplicationEvent;

public abstract class APipelineEvent extends ApplicationEvent {
    private String sessionId;

    public abstract SessionStatusEnum getStage();

    public APipelineEvent(Object obj, String sessionId) {
        super(obj);
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

}
