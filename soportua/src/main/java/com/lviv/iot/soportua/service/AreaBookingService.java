package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.AreaBooking;
import com.lviv.iot.soportua.repository.AreaBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaBookingService extends ServiceCRUD<AreaBooking, Long, AreaBookingRepository>{
    protected AreaBookingService(AreaBookingRepository repository) {
        super(repository);
    }

    @Override
    protected void updateFields(AreaBooking existing, AreaBooking newEntity) {
        existing.setId(newEntity.getId());
        existing.setStartTime(newEntity.getStartTime());
        existing.setEndTime(newEntity.getEndTime());
        existing.setArea(newEntity.getArea());
        existing.setClient(newEntity.getClient());
    }
}
