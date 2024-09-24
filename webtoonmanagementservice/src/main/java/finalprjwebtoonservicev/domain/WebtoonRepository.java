package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "webtoons", path = "webtoons")
public interface WebtoonRepository
    extends PagingAndSortingRepository<Webtoon, Long> {}
