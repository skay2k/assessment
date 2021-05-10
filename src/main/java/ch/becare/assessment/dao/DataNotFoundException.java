package ch.becare.assessment.dao;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(Class clazz, Object id) {
        super(clazz.getName() + " not found :" + String.valueOf(id));
    }

}
