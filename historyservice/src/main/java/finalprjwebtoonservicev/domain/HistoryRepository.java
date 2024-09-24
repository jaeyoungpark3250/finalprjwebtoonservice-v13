package finalprjwebtoonservicev.domain;

import finalprjwebtoonservicev.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "histories", path = "histories")
public interface HistoryRepository
    extends PagingAndSortingRepository<History, Long> {

    Optional<History> findById(String userId);}
