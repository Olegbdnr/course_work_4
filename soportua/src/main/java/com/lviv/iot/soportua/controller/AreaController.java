package com.lviv.iot.soportua.controller;

import com.lviv.iot.soportua.domain.Area;
import com.lviv.iot.soportua.domain.MembershipPlan;
import com.lviv.iot.soportua.dto.AreaDto;
import com.lviv.iot.soportua.dto.MembershipPlanDto;
import com.lviv.iot.soportua.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/area")
public class AreaController {
    private final AreaService service;

    public AreaController(AreaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AreaDto> getAllAreas() {
        return service.getAll().stream().map(AreaDto::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDto> getAreaById(@PathVariable Long id) {
        return service.getById(id)
                .map(AreaDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AreaDto createArea(@RequestBody AreaDto areaDto) {
        Area area = AreaDto.toEntity(areaDto);
        return AreaDto.toDto(service.create(area));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaDto> update(@PathVariable Long id, @RequestBody AreaDto areaDto) {
        Area plan = AreaDto.toEntity(areaDto);
        return service.update(id, plan)
                .map(AreaDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
