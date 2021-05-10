package ch.becare.assessment.process;

import ch.becare.assessment.process.event.ProcessedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Async
public class ProcessedEventListener extends APipelineEventListener {
    private static final Logger log = LoggerFactory.getLogger(ProcessedEventListener.class);

    @EventListener
    public void onApplicationEvent(ProcessedEvent event) {
        log.info("{} _Session ID {} Entered final stage", LocalDateTime.now(), event.getSessionId());
        //applicationEventPublisher.publishEvent(new Stage2Event(this, event.getSessionId()));
    }
}
