package ro.sd.a2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.service.FeeService;
import ro.sd.a2.service.TopicClassBookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Assignment2SdApplicationTests {

    @Autowired
    private TopicClassBookService topicClassBookService;

    @Autowired
    private FeeService feeService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllGradesForAStudent(){
        List<StudentGradeDTO> studentGradeDTOList = topicClassBookService.studentGrades("1",3);
        assertNotNull(studentGradeDTOList);
        for(StudentGradeDTO studentGradeDTO : studentGradeDTOList){
            System.out.println("Topic name:"+studentGradeDTO.getTopicName()+"\n"
                +"Year:"+ studentGradeDTO.getYear()+"\n"+
                "Semester:"+ studentGradeDTO.getSemester()+"\n"+
                "Grade:"+ studentGradeDTO.getGrade()+"\n"+
                "Examination: "+ studentGradeDTO.getExaminationMethod()+"\n");
        }
    }

    @Test
    public void testStudentPayFeeWithSuccess(){
        String result = feeService.pay("1");
        assertEquals("Success",result);
    }

    @Test
    public void testStudentPayFeeWithoutSuccess(){
        String result = feeService.pay("200");
        assertNotEquals("Success",result);
    }


}
