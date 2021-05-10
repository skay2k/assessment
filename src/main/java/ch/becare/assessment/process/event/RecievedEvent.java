package ch.becare.assessment.process.event;

import ch.becare.assessment.dao.entity.SessionStatusEnum;

public class RecievedEvent extends APipelineEvent {

    public SessionStatusEnum getStage() {
        return SessionStatusEnum.RECEIVED;
    }

    public RecievedEvent(Object obj, String sessionId) {
        super(obj, sessionId);
    }

}