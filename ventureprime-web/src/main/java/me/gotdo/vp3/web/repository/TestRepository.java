package me.gotdo.vp3.web.repository;

import java.util.List;

import me.gotdo.vp3.web.model.Test;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
	
	List<Test> findByCreatorId(String id);
	
}
