package com.lviv.iot.soportua.dto;

import com.lviv.iot.soportua.domain.Area;
import com.lviv.iot.soportua.domain.AreaBooking;
import com.lviv.iot.soportua.domain.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AreaBookingDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long areaId;
    private Long clientId;

    public static AreaBookingDto toDto(AreaBooking areaBooking) {
        AreaBookingDto dto = new AreaBookingDto();
        dto.setId(areaBooking.getId());
        dto.setStartTime(areaBooking.getStartTime());
        dto.setEndTime(areaBooking.getEndTime());
        dto.setAreaId(areaBooking.getArea().getId());
        dto.setClientId(areaBooking.getClient().getId());

        return dto;
    }

    public static AreaBooking toEntity(AreaBookingDto areaBookingDto) {
        AreaBooking areaBooking = new AreaBooking();
        areaBooking.setId(areaBookingDto.getId());
        areaBooking.setStartTime(areaBookingDto.getStartTime());
        areaBooking.setEndTime(areaBookingDto.getEndTime());

        return areaBooking;
    }
}
