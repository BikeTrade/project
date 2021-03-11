package com.biketrade.controller;

 
import java.util.List;

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
public class BTSolrController {
    
	@Autowired
	BTSolrRepository btSolrRepository;
	
	@Autowired
	SolrTemplate solrTemplate;
	
    @GetMapping("/{filter}")
    public List<SBike> getBikes(@PathVariable String filter) {    	 
        return btSolrRepository.getBikes(filter);
    }
    
}