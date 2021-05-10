package ch.becare.assessment.service;

import ch.becare.assessment.dao.entity.User;
import ch.becare.assessment.dao.DataNotFoundException;
import ch.becare.assessment.dao.SessionRepository;
import ch.becare.assessment.dao.UserRepository;
import ch.becare.assessment.dao.entity.DataPair;
import ch.becare.assessment.dao.entity.SessionRecord;
import ch.becare.assessment.dao.entity.SessionStatusEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SessionService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    ModelMapper modelMapper;

    public SessionRecord store(SessionDTO newSession) {
        SessionRecord session = modelMapper.map(newSession, SessionRecord.class);
        String userEmail = newSession.getUser();
        User user = userRepository.findByEmail(newSession.getUser()).orElseThrow(() -> new DataNotFoundException(User.class, userEmail));
        session.setUser(user);
        session.setSessionId(createNewId(newSession));
        session.setStatusEnum(SessionStatusEnum.RECEIVED);
        List<DataPair> dataPairs = new ArrayList<>();
        newSession.getData().entrySet().stream().forEach(entry -> dataPairs.add(new DataPair(session.getSessionId(), entry.getKey(), entry.getValue())));
        //for (Map.Entry<String, Double> entry : newSession.getData().entrySet()) {
        // dataPairs.add(new DataPair(session.getSessionId(), entry.getKey(), entry.getValue()));
        //}
        session.setData(dataPairs);
        sessionRepository.save(session);
        return session;
    }

    public SessionRecord get(String sessionId) {
        return sessionRepository.findById(sessionId).get();
    }

    public SessionRecord updateStatus(String sessionId, SessionStatusEnum statusEnum) {
        SessionRecord session = sessionRepository.findById(sessionId).get();
        session.setStatusEnum(statusEnum);
        sessionRepository.save(session);
        return session;
    }

    public String createNewId(SessionDTO newSession) {
        return newSession.getUser() + "-" + System.currentTimeMillis();
    }
}
