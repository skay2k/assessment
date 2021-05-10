package ch.becare.assessment;

import ch.becare.assessment.service.SessionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.LinkedHashMap;

@SpringBootTest
class AssessmentApplicationTests {

//	@Test
//	void contextLoads() {
//	}

    @Test
    public void testJson() throws Exception {
        ObjectMapper mapperObj = new ObjectMapper();

        LinkedHashMap<String, Double> data = new LinkedHashMap<>();
        data.put("name", 23.2d);
        data.put("site", 34.5d);

        // convert map to JSON String
        SessionDTO rs = new SessionDTO();
        rs.setBegin(new Date());

        rs.setData(data);
        String jsonResp = mapperObj.writeValueAsString(rs);
        System.out.println(jsonResp);

    }
}
