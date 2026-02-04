package com.lviv.iot.soportua.dto;

import com.lviv.iot.soportua.domain.AccessType;
import com.lviv.iot.soportua.domain.MembershipCategory;
import com.lviv.iot.soportua.domain.MembershipPlan;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class MembershipPlanDto {
    private Long id;
    private String name;
    private MembershipCategory category;
    private Set<AccessType> allowedAccess;
    private int price;
    private int discountPercent;
    private int durationInMonth;

    public static MembershipPlanDto toDto(MembershipPlan plan) {
        MembershipPlanDto dto = new MembershipPlanDto();

        dto.setId(plan.getId());
        dto.setName(plan.getName());
        dto.setCategory(plan.getCategory());
        dto.setAllowedAccess(plan.getAllowedAccess());
        dto.setPrice(plan.getPrice());
        dto.setDiscountPercent(plan.getDiscountPercent());
        dto.setDurationInMonth(plan.getDurationInMonth());

        return dto;
    }

    public static MembershipPlan toEntity(MembershipPlanDto planDto) {
        MembershipPlan plan = new MembershipPlan();

        plan.setId(planDto.getId());
        plan.setName(planDto.getName());
        plan.setCategory(planDto.getCategory());
        plan.setAllowedAccess(planDto.getAllowedAccess());
        plan.setPrice(planDto.getPrice());
        plan.setDiscountPercent(planDto.getDiscountPercent());
        plan.setDurationInMonth(planDto.getDurationInMonth());

        return plan;
    }
}
