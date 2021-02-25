package com.biketrade.dao; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.pojo.SBike;

import java.util.List;

 

@Repository
@Qualifier("bikeSolrRepository")
public interface BTSolrRepository extends SolrCrudRepository<SBike, Long> {

    @Query(value = "*:*")
    List<SBike> getBikes();

} 