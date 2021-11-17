package JRissanen.POProjekti.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SportDataRepository extends CrudRepository<SportData, Long> {

}
