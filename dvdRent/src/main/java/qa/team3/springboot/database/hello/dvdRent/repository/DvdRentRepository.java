package qa.team3.springboot.database.hello.dvdRent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.team3.springboot.database.hello.dvdRent.model.DvdRentDataModel;

@Repository
public interface DvdRentRepository extends JpaRepository<DvdRentDataModel, Long>{

}