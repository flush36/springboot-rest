package br.com.springboot.endpoint;

import br.com.springboot.Error.CustomErrorType;
import br.com.springboot.model.Student;
import br.com.springboot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("students")
public class StudentEndPoint {

    private DateUtil dateUtil;

    @Autowired
    public  StudentEndPoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll() {
        //System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
      return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }


   public  ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
        Student student = new Student();
       student.setId(id);
       int index = Student.studentList.indexOf(student);
        if(index == -1) {
            return new ResponseEntity<>(new CustomErrorType("student not found"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
        }
    }

}

