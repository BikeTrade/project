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
    @Query(value = "q = brand:?0 AND priceRange:?1 AND kmRange:?2 AND bLocation:?3")
    List<SBike> getBikes(String brand,String priceRange,String kmRange,String cityRangeFilter);
    
    List<SBike> findByBrandAndRunningBetween(String brand,String start,String end);
    
  //  List<SBike> findByModelNameAndfindByBrand(String modelName,String location);

} 