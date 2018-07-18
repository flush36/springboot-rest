package br.com.springboot.endpoint;

import br.com.springboot.Error.ResourceNotFoundException;
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
        verifyIfStudentsExists(id);
    	Student stundent = stundentDAO.findOne(id);
    	return new ResponseEntity<>(stundent, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student) {
    	return new ResponseEntity<>(stundentDAO.save(student) , HttpStatus.OK);
    }
    
    @DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfStudentsExists(id);
    	stundentDAO.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        verifyIfStudentsExists(student.getId());
    	stundentDAO.save(student);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentByName(@PathVariable String name) {
        return new ResponseEntity<>(stundentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    private void verifyIfStudentsExists(Long id) {
        if (stundentDAO.findOne(id) == null)
            throw new ResourceNotFoundException("Student not found for ID: " +id);
    }

}

