package me.gotdo.vp3.web.repository;

import me.gotdo.vp3.web.model.TestLevel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestLevelRepository extends MongoRepository<TestLevel, String> {
	
	TestLevel findByFriendlyName(String friendlyName);
	
}
