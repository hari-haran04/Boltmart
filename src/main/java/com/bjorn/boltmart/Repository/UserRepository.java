package com.bjorn.boltmart.Repository;

import com.bjorn.boltmart.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    User findByKId(String kid);

}
