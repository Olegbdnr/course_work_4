package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.Membership;
import com.lviv.iot.soportua.repository.MembershipRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public class MembershipService extends ServiceCRUD<Membership, Long>{

    protected MembershipService(MembershipRepository repository) {
        super(repository);
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
