package ch.becare.assessment.service.rest;

import ch.becare.assessment.dao.entity.SessionRecord;
import ch.becare.assessment.process.PipelineHelper;
import ch.becare.assessment.process.event.RecievedEvent;
import ch.becare.assessment.service.SessionDTO;
import ch.becare.assessment.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    SessionService sessionService;
    @Autowired
    PipelineHelper pipelineHelper;

    @PostMapping("/receive")
    //@RequestMapping (value ="/receive",method =RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE)
    public void receive(@RequestBody SessionDTO newSession) {
        SessionRecord session = sessionService.store(newSession);
        log.info("{} _Received session ID {} with data {}", LocalDateTime.now(), session.getSessionId(), session.getData().stream().collect(Collectors.toList()));
        pipelineHelper.publish(session);
    }
}
