package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.Client;
import com.lviv.iot.soportua.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends ServiceCRUD<Client, Long, ClientRepository>{

    protected ClientService(ClientRepository repository) {
        super(repository);
    }

    @Override
    protected void updateFields(Client existing, Client newEntity) {
        existing.setFirstName(newEntity.getFirstName());
        existing.setLastName(newEntity.getLastName());
        existing.setPhoneNumber(newEntity.getPhoneNumber());
        existing.setEmail(newEntity.getEmail());
        existing.setProfilePhotoUrl(newEntity.getProfilePhotoUrl());
        existing.setBonusBalance(newEntity.getBonusBalance());
    }
}
