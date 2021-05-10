package ch.becare.assessment.dao;

import ch.becare.assessment.dao.entity.SessionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<SessionRecord, String> {

    //List<Employee> findByName(@Param("name") String name);

}
