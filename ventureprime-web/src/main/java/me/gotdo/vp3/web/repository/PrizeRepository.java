package me.gotdo.vp3.web.repository;

import me.gotdo.vp3.web.model.Prize;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrizeRepository extends MongoRepository<Prize, String> {
	
	Prize findByName(String name);

}
