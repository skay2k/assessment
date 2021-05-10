package ch.becare.assessment.process.event;

import ch.becare.assessment.dao.entity.SessionStatusEnum;

public class ProcessedEvent extends APipelineEvent {

    public SessionStatusEnum getStage() {
        return SessionStatusEnum.PROCESSED;
    }

    public ProcessedEvent(Object obj, String sessionId) {
        super(obj, sessionId);
    }

}