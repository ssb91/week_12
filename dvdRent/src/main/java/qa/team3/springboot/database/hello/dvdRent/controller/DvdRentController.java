package qa.team3.springboot.database.hello.dvdRent.controller;


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

import qa.team3.springboot.database.hello.dvdRent.exception.ResourceNotFoundException;
import qa.team3.springboot.database.hello.dvdRent.model.*;
import qa.team3.springboot.database.hello.dvdRent.repository.DvdRentRepository;


@RestController
@RequestMapping("/api")

public class DvdRentController {

@Autowired
DvdRentRepository myRepository;
	

@PostMapping("/dvd")
public DvdRentDataModel createDvd(@Valid @RequestBody DvdRentDataModel mSDM) {

return myRepository.save(mSDM);

}

@GetMapping("dvd/{id}")
public DvdRentDataModel getDvdbyID(@PathVariable(value = "id") 
Long dvdID) {
	
	return myRepository.findById(dvdID).orElseThrow(() -> new ResourceNotFoundException("DvdRentDataModel","id", dvdID));

}

@GetMapping("/dvd")
public List<DvdRentDataModel> getAllDvds(){
	
	return myRepository.findAll();
}



@PutMapping("/dvd/{id}")
public DvdRentDataModel updateDvd(@PathVariable(value = "id") Long dvdID,
		@Valid @RequestBody DvdRentDataModel dvdDetails) {
	
DvdRentDataModel mSDM = myRepository.findById(dvdID).orElseThrow(()-> new ResourceNotFoundException("Dvd", "id", dvdID));
	
	mSDM.setTitle(dvdDetails.getTitle());
	mSDM.setPrice(dvdDetails.getPrice());	
	
	DvdRentDataModel updateData = myRepository.save(mSDM);
	
	return updateData;
	
}


@DeleteMapping("/dvd/{id}")
public ResponseEntity<?> deleteDvd(@PathVariable(value="id") Long dvdID) {
	
	DvdRentDataModel mSDM = myRepository.findById(dvdID).orElseThrow(()-> new ResourceNotFoundException("Dvd", "id", dvdID));

	myRepository.delete(mSDM);
	return ResponseEntity.ok().build();
	
}


}