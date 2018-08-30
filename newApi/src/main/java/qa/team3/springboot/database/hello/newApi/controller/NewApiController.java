package qa.team3.springboot.database.hello.newApi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.team3.springboot.database.hello.newApi.exception.ResourceNotFoundException;
import qa.team3.springboot.database.hello.newApi.model.*;
import qa.team3.springboot.database.hello.newApi.repository.NewApiRepository;

@RestController
@RequestMapping("/api")

public class NewApiController {

@Autowired
NewApiRepository myRepository;
	

@PostMapping("/person")
public NewApiDataModel createPerson(@Valid @RequestBody NewApiDataModel mSDM) {

return myRepository.save(mSDM);

}

@GetMapping("person/{id}")
public NewApiDataModel getPersonbyID(@PathVariable(value = "id") 
Long personID) {
	
	return myRepository.findById(personID).orElseThrow(() -> new ResourceNotFoundException("NewApiDataModel","id", personID));

}

@GetMapping("/person")
public List<NewApiDataModel> getAllPeople(){
	
	return myRepository.findAll();
}



@PutMapping("/person/{id}")
public NewApiDataModel updatePerson(@PathVariable(value = "id") Long personID,
		@Valid @RequestBody NewApiDataModel personDetails) {
	
NewApiDataModel mSDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person", "id", personID));
	
	mSDM.setName(personDetails.getName());
	mSDM.setAddress(personDetails.getAddress());
	mSDM.setAge(personDetails.getAge());	
	
	NewApiDataModel updateData = myRepository.save(mSDM);
	
	
	return updateData;
	
	
}


@DeleteMapping("/person/{id}")
public ResponseEntity<?> deletePerson(@PathVariable(value="id") Long personID) {
	
	NewApiDataModel mSDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("Person", "id", personID));

	myRepository.delete(mSDM);
	return ResponseEntity.ok().build();
	
}


}