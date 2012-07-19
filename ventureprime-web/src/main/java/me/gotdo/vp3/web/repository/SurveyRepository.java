package me.gotdo.vp3.web.repository;

import me.gotdo.vp3.web.model.Survey;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends MongoRepository<Survey, String> {

}
