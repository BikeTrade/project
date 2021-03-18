package com.biketrade.cronjob;

 

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.biketrade.dao.BTSolrRepository;
import com.biketrade.dao.BTUserRepository;
import com.biketrade.model.Bike;
import com.biketrade.model.BikeStatus;
import com.biketrade.model.User;
import com.biketrade.pojo.SBike;
import com.biketrade.service.IBTBikeDetailsService;

@Component
public class ScheduledTasks {


	 @Autowired
	IBTBikeDetailsService bikeDetailService;
	 
	 @Autowired
	 BTSolrRepository solrRepository;

	private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
 
	@Scheduled(fixedRate = 6000000)
	public void reportCurrentTime() {

		 List<Bike> bikes= bikeDetailService.findByStatus(BikeStatus.APPROVED);
		 if(!bikes.isEmpty()) {
		 List<SBike> converted = new ArrayList<SBike>(); bikes.forEach(bike->{
		 converted.add(new SBike(bike));});
		 solrRepository.saveAll(converted);
		 }else
		 {
			 LOG.info("No approved bikes");
			 
		 }
		 
	}
}