package ch.becare.assessment.process;

import ch.becare.assessment.process.event.RecievedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Async
public class RecievedEventListener extends APipelineEventListener {
    private static final Logger log = LoggerFactory.getLogger(RecievedEventListener.class);

    @EventListener
    public void onApplicationEvent(RecievedEvent event) {
        try {
            TimeUnit.MILLISECONDS.sleep(new Double(Math.random() * (2000 - 1000)).longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onStage(event);
    }
}
