package finalprjwebtoonservicev.infra;

import finalprjwebtoonservicev.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "histories", path = "histories")
public interface HistoriesRepository
    extends PagingAndSortingRepository<Histories, Long> {}
