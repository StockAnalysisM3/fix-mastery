package com.fixmastery.users.controller;

import com.fixmastery.users.dao.ClientRepository;
import com.fixmastery.users.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ClientCommandLineRunner implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    // we will create id == username
    @Override
    public void run(String... args) throws Exception {
        String[] defaultUsers = {"bob", "jeff", "dave"};

        Arrays.stream(defaultUsers)
            .map(createUsersIfNonExistent)
            .forEach(ifExistsAddToClientRepo);
    }

    private Function<String, Optional<Client>> createUsersIfNonExistent = (client)
        -> !clientRepository.findByUserName(client).isPresent() ?
            Optional.of(new Client(client, client + "123", "password", "USER")) :
            Optional.empty();

    private Consumer<Optional<Client>> ifExistsAddToClientRepo = (client) -> {
        if(client.isPresent())
            clientRepository.save(client.get());

    };
}
