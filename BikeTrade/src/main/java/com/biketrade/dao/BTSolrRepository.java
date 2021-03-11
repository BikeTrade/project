package com.biketrade.dao; 
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.pojo.SBike;

 

@Repository
@Qualifier("bikeSolrRepository")
public interface BTSolrRepository extends SolrCrudRepository<SBike, Long> {
//fq = brand:?0 & fq = running:[?1 TO ?2]
    @Query(value = "fq = brand:?0 ")
    List<SBike> getBikes(String brand);
    
    List<SBike> findByBrandAndRunningBetween(String brand,String start,String end);
    
  //  List<SBike> findByModelNameAndfindByBrand(String modelName,String location);

} 