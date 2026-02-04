package com.lviv.iot.soportua.service;

import com.lviv.iot.soportua.domain.Area;
import com.lviv.iot.soportua.repository.AreaRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaService extends ServiceCRUD<Area, Long, AreaRepository>{

    protected AreaService(AreaRepository repository) {
        super(repository);
    }

    @Override
    protected void updateFields(Area existing, Area newEntity) {
        existing.setName(newEntity.getName());
        existing.setAreaType(newEntity.getAreaType());
        existing.setDescription(newEntity.getDescription());
        existing.setPricePerHour(newEntity.getPricePerHour());
        existing.setCapacity(newEntity.getCapacity());
        existing.setIndoor(newEntity.isIndoor());
        existing.setLength(newEntity.getLength());
        existing.setWidth(newEntity.getWidth());
    }
}
