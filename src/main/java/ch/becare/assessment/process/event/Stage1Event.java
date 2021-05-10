package ch.becare.assessment.process.event;

import ch.becare.assessment.dao.entity.SessionStatusEnum;

public class Stage1Event extends APipelineEvent {

    public SessionStatusEnum getStage() {
        return SessionStatusEnum.STEP_1;
    }

    public Stage1Event(Object obj, String sessionId) {
        super(obj, sessionId);
    }

}
