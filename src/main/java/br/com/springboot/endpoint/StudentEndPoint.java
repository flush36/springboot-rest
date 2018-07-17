package br.com.springboot.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.Error.CustomErrorType;
import br.com.springboot.model.Student;
import br.com.springboot.repository.StudentRepository;


@RestController
@RequestMapping("students")
public class StudentEndPoint {

	private final StudentRepository stundentDAO;
	
    @Autowired
    public  StudentEndPoint(StudentRepository stundentDAO) {
        this.stundentDAO = stundentDAO;
    }

   @GetMapping
    public ResponseEntity<?> listAll() {
        //System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
      return new ResponseEntity<>(stundentDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
    	Student stundent = stundentDAO.findOne(id);
    	if(stundent == null) {
    		return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<>(stundent, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
    	return new ResponseEntity<>(stundentDAO.save(student) , HttpStatus.OK);
    }
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
    	stundentDAO.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
    	stundentDAO.save(student);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}

