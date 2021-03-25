package com.biketrade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.Address;

@Repository
public interface BTAddressRepository extends JpaRepository<Address ,Long>{

}
