package com.lviv.iot.soportua.controller;

import com.lviv.iot.soportua.domain.Client;
import com.lviv.iot.soportua.domain.Membership;
import com.lviv.iot.soportua.domain.MembershipPlan;
import com.lviv.iot.soportua.dto.ClientDto;
import com.lviv.iot.soportua.dto.MembershipDto;
import com.lviv.iot.soportua.service.ClientService;
import com.lviv.iot.soportua.service.MembershipPlanService;
import com.lviv.iot.soportua.service.MembershipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final MembershipService membershipService;
    private final MembershipPlanService membershipPlanService;

    public ClientController(ClientService service,
                            MembershipService membershipService,
                            MembershipPlanService membershipPlanService) {
        this.clientService = service;
        this.membershipService = membershipService;
        this.membershipPlanService = membershipPlanService;
    }

    @GetMapping
    public List<ClientDto> getAll() {
        return clientService.getAll().stream().map(ClientDto::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id) {
        return clientService.getById(id)
                .map(ClientDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientDto create(@RequestBody ClientDto clientDto) {
        Client client = ClientDto.toEntity(clientDto);
        Client response = clientService.create(client);
        return ClientDto.toDto(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        Client client = ClientDto.toEntity(clientDto);
        return clientService.update(id, client)
                .map(ClientDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientService.getById(id).isPresent()) {
            clientService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/memberships")
    public List<MembershipDto> getAllMemberships() {
        return membershipService.getAll().stream().map(MembershipDto::toDto).toList();
    }

    @GetMapping("/{id}/memberships")
    public List<MembershipDto> getAllClientsMemberships(@PathVariable Long id) {
        return membershipService.getAllByClientId(id).stream().map(MembershipDto::toDto).toList();
    }

    @GetMapping("/memberships/{id}")
    public ResponseEntity<MembershipDto> getMembershipById(@PathVariable Long id) {
        return membershipService.getById(id)
                .map(MembershipDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{clientId}/memberships")
    public MembershipDto createMembership(@PathVariable Long clientId,
                                      @RequestBody MembershipDto membershipDto) {
        Long membershipPlanId = membershipDto.getMembershipPlanId();
        Membership membership = MembershipDto.toEntity(membershipDto);
        Membership response = membershipService.create(membership, membershipPlanId, clientId);
        return MembershipDto.toDto(response);
    }

    @PutMapping("/{id}/memberships/{membershipId}")
    public ResponseEntity<MembershipDto> update(@PathVariable Long id,
                                                @PathVariable Long membershipId,
                                                @RequestBody MembershipDto membershipDto) {
        MembershipPlan plan = membershipPlanService.
                getById(membershipDto.getMembershipPlanId())
                .orElseThrow();
        Client client = clientService.getById(id).orElseThrow();
        Membership membership = MembershipDto.toEntity(membershipDto);
        membership.setMembershipPlan(plan);
        membership.setClient(client);

        return membershipService.update(membershipId, membership)
                .map(MembershipDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}/memberships/{membershipId}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable Long membershipId) {
        if (membershipService.getById(membershipId).isPresent()) {
            membershipService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
