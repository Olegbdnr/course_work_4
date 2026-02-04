package com.lviv.iot.soportua.dto;

import com.lviv.iot.soportua.domain.Membership;
import com.lviv.iot.soportua.domain.MembershipStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class MembershipDto {
    private Long id;
    private MembershipStatus status;
    private LocalDate startedAt;
    private LocalDate endsAt;
    private Long membershipPlanId;
    private Long clientId;

    public static MembershipDto toDto(Membership membership) {
        MembershipDto dto = new MembershipDto();

        dto.setId(membership.getId());
        dto.setStatus(membership.getStatus());
        dto.setStartedAt(membership.getStartedAt());
        dto.setEndsAt(membership.getEndsAt());
        dto.setMembershipPlanId(membership.getMembershipPlan().getId());
        dto.setClientId(membership.getClient().getId());

        return dto;
    }

    public static Membership toEntity(MembershipDto membershipDto) {
        Membership membership = new Membership();

        membership.setId(membershipDto.getId());
        membership.setStatus(membershipDto.getStatus());
        membership.setStartedAt(membershipDto.getStartedAt());
        membership.setEndsAt(membershipDto.getEndsAt());

        return membership;
    }
}
