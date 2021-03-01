package com.biketrade.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biketrade.model.ImageModel;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findByName(String name);

}