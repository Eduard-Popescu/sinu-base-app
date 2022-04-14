package ro.sd.a2.service.serviceImp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;
import ro.sd.a2.domain.entity.ClassBook;
import ro.sd.a2.repository.ClassBookRepository;
import ro.sd.a2.service.ClassBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ClassBookServiceImpl implements ClassBookService {

  private final ClassBookRepository classBookRepository;

  public ClassBookServiceImpl(ClassBookRepository classBookRepository) {
    this.classBookRepository = classBookRepository;
  }

  /**
   *
   * @param studentId
   * @return List<String>
   */
  @Override
  public List<String> getGradesForEachYears(String studentId) {

    if(studentId.isEmpty()){
      log.error("Student Id is empty");
    }
    List<ClassBook> classBooks = classBookRepository.getClassBookByUser(studentId);
    List<String> grades = new ArrayList<>();

    for (ClassBook classBook:classBooks){
      if(classBook.getClassBookYear() == 3){
        grades.add("Note Anul 3");
        log.debug("ClassBookYear in getGradesForEachYears:{}",classBook.getClassBookYear());
      }
      if(classBook.getClassBookYear() == 2){
        grades.add("Note Anul 2");
        log.debug("ClassBookYear in getGradesForEachYears:{}",classBook.getClassBookYear());
      }
      if(classBook.getClassBookYear() == 1){
        grades.add("Note Anul 1");
        log.debug("ClassBookYear in getGradesForEachYears:{}",classBook.getClassBookYear());
      }
    }
    Set<String> stringSet = new HashSet<>(grades);
    return new ArrayList<>(stringSet);
  }
}
