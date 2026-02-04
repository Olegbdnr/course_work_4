package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.Client;
import com.lviv.iot.soportua.domain.Membership;
import com.lviv.iot.soportua.domain.MembershipPlan;
import com.lviv.iot.soportua.repository.ClientRepository;
import com.lviv.iot.soportua.repository.MembershipPlanRepository;
import com.lviv.iot.soportua.repository.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService extends ServiceCRUD<Membership, Long, MembershipRepository>{
    private final MembershipPlanRepository membershipPlanRepository;
    private final ClientRepository clientRepository;

    protected MembershipService(MembershipRepository repository,
                                MembershipPlanRepository membershipPlanRepository,
                                ClientRepository clientRepository) {
        super(repository);
        this.membershipPlanRepository = membershipPlanRepository;
        this.clientRepository = clientRepository;
    }

    public Membership create(Membership membership, Long membershipPlanId, Long clientId) {
        MembershipPlan membershipPlan = membershipPlanRepository
                .findById(membershipPlanId)
                .orElseThrow();
        Client client = clientRepository
                .findById(clientId)
                .orElseThrow();
        membership.setMembershipPlan(membershipPlan);
        membership.setClient(client);
        return repository.save(membership);
    }

    public List<Membership> getAllByClientId(Long clientId) {
        return repository.findAllByClient_Id(clientId);
    }

    @Override
    protected void updateFields(Membership existing, Membership newEntity) {
        existing.setStatus(newEntity.getStatus());
        existing.setStartedAt(newEntity.getStartedAt());
        existing.setEndsAt(newEntity.getEndsAt());
        existing.setMembershipPlan(newEntity.getMembershipPlan());
        existing.setClient(newEntity.getClient());
    }
}
