package me.gotdo.vp3.web.repository;

import me.gotdo.vp3.web.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
	
	Company findByName(String name);
	
}
