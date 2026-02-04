package com.lviv.iot.soportua.dto;

import com.lviv.iot.soportua.domain.Area;
import com.lviv.iot.soportua.domain.AreaType;
import com.lviv.iot.soportua.domain.Client;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaDto {
    private Long id;
    private String name;
    private AreaType areaType;
    private String description;
    private int pricePerHour;
    private int capacity;
    private boolean isIndoor;
    private int length;
    private int width;

    public static AreaDto toDto(Area area) {
        AreaDto dto = new AreaDto();
        dto.setId(area.getId());
        dto.setName(area.getName());
        dto.setAreaType(area.getAreaType());
        dto.setDescription(area.getDescription());
        dto.setPricePerHour(area.getPricePerHour());
        dto.setCapacity(area.getCapacity());
        dto.setIndoor(area.isIndoor());
        dto.setLength(area.getLength());
        dto.setWidth(area.getWidth());

        return dto;
    }

    public static Area toEntity(AreaDto areaDto) {
        Area area = new Area();
        area.setId(areaDto.getId());
        area.setName(areaDto.getName());
        area.setAreaType(areaDto.getAreaType());
        area.setDescription(areaDto.getDescription());
        area.setPricePerHour(areaDto.getPricePerHour());
        area.setCapacity(areaDto.getCapacity());
        area.setIndoor(areaDto.isIndoor());
        area.setLength(areaDto.getLength());
        area.setWidth(areaDto.getWidth());

        return area;
    }
}
