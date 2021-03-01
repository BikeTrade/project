package com.biketrade.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.pojo.SBike;

@RestController
@RequestMapping("/bike")
public class SolrController {
    
	@Autowired
	BTSolrRepository btSolrRepository;
	
	@Autowired
	SolrTemplate solrTemplate;
	
    @GetMapping("/{filter}/{start}/{end}")
    public Iterable<SBike> getBikes(@PathVariable String filter,@PathVariable Double start,@PathVariable Double end) {
    	 
        return btSolrRepository.getBikes(filter,start,end);
    }
    
    
    @PostMapping("/save")
    public SBike saveBike(@RequestBody SBike sbike) {  
    	
    	System.out.println(sbike);
    	return btSolrRepository.save(sbike);    	
    }
    

 
}