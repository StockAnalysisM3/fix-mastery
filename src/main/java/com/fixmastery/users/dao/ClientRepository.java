package com.fixmastery.users.dao;

import com.fixmastery.users.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, String> {
    Optional<Client> findByUserName(String userName);
}
