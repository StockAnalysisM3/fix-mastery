package com.fixmastery.users.service;

import com.fixmastery.users.dao.ClientRepository;
import com.fixmastery.users.model.Client;
import com.fixmastery.users.security.ClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Client> clientQuery = clientRepository.findByUserName(userName);
        clientQuery.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return clientQuery.map(ClientDetails::new).get();
    }

    public Iterable<Client> getAllUsers() {
        return clientRepository.findAll();
    }


}
