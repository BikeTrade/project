package com.biketrade.cronjob;

 

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeState;
import com.biketrade.model.BikeStatus;
import com.biketrade.pojo.SBike;
import com.biketrade.service.IBTBikeDetailsService;

@Component
public class ScheduledTasks {


	 @Autowired
	IBTBikeDetailsService bikeDetailService;
	 
	 @Autowired
	 BTSolrRepository solrRepository;

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
 
	@Scheduled(fixedRate = 6000)
	public void reportCurrentTime() {

		 List<Bike> bikes= bikeDetailService.findByStatus(BikeStatus.APPROVED);
		 if(!bikes.isEmpty()) {
			 List<SBike> converted = new ArrayList<SBike>();
		 
			 bikes.forEach(bike->{converted.add(new SBike(bike));});
			 
			 solrRepository.saveAll(converted);
		 }else
		 {
			 LOG.info("No approved bikes");			 
		 }
		 
	}
	
	@Scheduled(fixedRate = 10000)
	public void removeSoldBikes() {
		List<Bike> bikes = bikeDetailService.findByState(BikeState.SOLD);
		if (!bikes.isEmpty()) {
			bikes.forEach(bike -> {
				solrRepository.deleteById(bike.getId());
			});

		}
	}
	
	@Scheduled(fixedRate = 20000)
	public void removeCanceledBikes() {
		List<Bike> bikes = bikeDetailService.findByStatus(BikeStatus.CANCELLED);
		if (!bikes.isEmpty()) {
			bikes.forEach(bike -> {
				solrRepository.deleteById(bike.getId());
			});

		}
	}
	
	
	
}