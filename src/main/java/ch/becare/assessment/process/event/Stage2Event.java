package ch.becare.assessment.process.event;

import ch.becare.assessment.dao.entity.SessionStatusEnum;

public class Stage2Event extends APipelineEvent {
    public SessionStatusEnum getStage() {
        return SessionStatusEnum.STEP_2;
    }

    public Stage2Event(Object obj, String sessionId) {
        super(obj, sessionId);
    }
}
