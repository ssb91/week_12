package qa.team3.springboot.database.hello.newApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.team3.springboot.database.hello.newApi.model.NewApiDataModel;

@Repository
public interface NewApiRepository extends JpaRepository<NewApiDataModel, Long>{

}
