package com.biketrade.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.pojo.SBike;

@RestController
@RequestMapping("/bike")
public class BTSolrController {
    
	@Autowired
	BTSolrRepository btSolrRepository;
	
	@Autowired
	SolrTemplate solrTemplate;
	
    @GetMapping("/details")
    public List<SBike> getBikes(@RequestParam String filter,@RequestParam String priceRangeFilter,
    		@RequestParam String kmRangeFilter,@RequestParam String cityRangeFilter) {   
        return btSolrRepository.getBikes(filter,priceRangeFilter,kmRangeFilter,cityRangeFilter);
    }
    
}