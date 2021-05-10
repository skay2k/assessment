package ch.becare.assessment.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class SessionRecord {

    @Id
    private String sessionId;

    @Enumerated(EnumType.STRING)
    private SessionStatusEnum statusEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;
    private Date begin;
    private Date end;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="sessionId", referencedColumnName="sessionId")
    private List<DataPair> data;

    public SessionStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(SessionStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<DataPair> getData() {
        return data;
    }

    public void setData(List<DataPair> data) {
        this.data = data;
    }
}
