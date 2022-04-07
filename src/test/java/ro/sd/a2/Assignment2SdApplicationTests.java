package ro.sd.a2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.sd.a2.domain.entity.dto.StudentGradeDTO;
import ro.sd.a2.service.TopicClassBookService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Assignment2SdApplicationTests {

    @Autowired
    private TopicClassBookService topicClassBookService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetAllGradesForAStudent(){
        List<StudentGradeDTO> studentGradeDTOList = topicClassBookService.studentGrades("1");
        assertNotNull(studentGradeDTOList);
        for(StudentGradeDTO studentGradeDTO : studentGradeDTOList){
            System.out.println("Topic name:"+studentGradeDTO.getTopicName()+"\n"
                +"Year:"+ studentGradeDTO.getYear()+"\n"+
                "Semester:"+ studentGradeDTO.getSemester()+"\n"+
                "Grade:"+ studentGradeDTO.getGrade()+"\n"+
                "Examination: "+ studentGradeDTO.getExaminationMethod()+"\n");
        }
    }

}
