package JRissanen.POProjekti.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SportRepository extends CrudRepository<Sport, Long> {
	
	List<Sport> findByDate(LocalDate localDate);

}
