package ch.becare.assessment.process;

import ch.becare.assessment.process.event.Stage2Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Async
public class Stage2EventListener extends APipelineEventListener {
    private static final Logger log = LoggerFactory.getLogger(Stage2EventListener.class);

    @EventListener
    public void onApplicationEvent(Stage2Event event) {
        log.info("{} _Session ID {} Entered stage {}", LocalDateTime.now(), event.getSessionId(), event.getStage());
        try {
            TimeUnit.MILLISECONDS.sleep(new Double(Math.random() * (2000 - 1000)).longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onStage(event);
    }
}
