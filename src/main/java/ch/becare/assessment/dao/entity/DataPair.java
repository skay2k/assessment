package ch.becare.assessment.dao.entity;

import javax.persistence.*;

@Entity
public class DataPair {

    @Id
    @GeneratedValue
    private long id;

    private String sessionId;

    private String key;
    private Double value;

    public DataPair() {
    }

    public DataPair(String sessionId,
                    String key,
                    Double value) {
        this.sessionId = sessionId;
        this.key = key;
        this.value = value;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        value = value;
    }
    public String toString(){
        return String.format("{\"%s\":%s}", key, value);
    }
}
