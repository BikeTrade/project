package com.biketrade.controller;

 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.pojo.SBike;

@RestController
@RequestMapping("/bike")
public class SolrController {
    
	@Autowired
	BTSolrRepository btSolrRepository;
	
    @GetMapping("/{id}")
    public Iterable<SBike> getBook(@PathVariable int id) {
        return btSolrRepository.findAll();
    }

 
}