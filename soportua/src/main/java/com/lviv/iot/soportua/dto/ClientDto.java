package com.lviv.iot.soportua.dto;

import com.lviv.iot.soportua.domain.Client;
import com.lviv.iot.soportua.domain.Membership;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String profilePhotoUrl;
    private String email;
    private String phoneNumber;
    private int bonusBalance;
    private List<Long> membershipsId;

    public static ClientDto toDto(Client client) {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setProfilePhotoUrl(client.getProfilePhotoUrl());
        dto.setEmail(client.getEmail());
        dto.setPhoneNumber(client.getPhoneNumber());
        dto.setBonusBalance(client.getBonusBalance());
        dto.setMembershipsId(client.getMemberships()
                .stream()
                .map(Membership::getId)
                .toList());
        return dto;
    }

    public static Client toEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setProfilePhotoUrl(clientDto.getProfilePhotoUrl());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setBonusBalance(clientDto.getBonusBalance());

        return client;
    }
}
