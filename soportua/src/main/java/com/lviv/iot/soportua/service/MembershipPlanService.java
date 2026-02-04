package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.MembershipPlan;
import com.lviv.iot.soportua.repository.MembershipPlanRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class MembershipPlanService extends ServiceCRUD<MembershipPlan, Long, MembershipPlanRepository>{

    public MembershipPlanService(MembershipPlanRepository repository) {
        super(repository);
    }

    @Override
    protected void updateFields(MembershipPlan existing, MembershipPlan newEntity) {
        existing.setName(newEntity.getName());
        existing.setCategory(newEntity.getCategory());
        existing.setAllowedAccess(new HashSet<>(newEntity.getAllowedAccess()));
        existing.setPrice(newEntity.getPrice());
        existing.setDiscountPercent(newEntity.getDiscountPercent());
        existing.setDurationInMonth(newEntity.getDurationInMonth());
    }
}
