package me.gotdo.vp3.web.repository;

import me.gotdo.vp3.web.model.VPUser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VPUserRepository extends MongoRepository<VPUser, String> {

}
