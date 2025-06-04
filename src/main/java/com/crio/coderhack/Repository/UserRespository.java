package com.crio.coderhack.Repository;

//import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crio.coderhack.Entities.User;
@Repository
public interface UserRespository extends MongoRepository<User,String> {
    
}
