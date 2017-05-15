package com.devon.demo.repository;

import com.devon.demo.model.Users;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;
import java.util.stream.Stream;

/**
 * Created by diwenlao on 5/11/17.
 */
public interface UsersRepository extends CassandraRepository<Users> {
    //Stream<Users> findByUsersSpecification(UsersSpecification specification);

    // Stream<Users> findAllById(UsersSpecification specification);

    Stream<Users> findAllById(UUID id);

//    @Override
//    List<Users> findAll(Specification<Users> spec);

}
