package com.lviv.iot.soportua.controller;

import com.lviv.iot.soportua.domain.MembershipPlan;
import com.lviv.iot.soportua.dto.MembershipPlanDto;
import com.lviv.iot.soportua.service.MembershipPlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-plans")
public class MembershipPlanController {

    private final MembershipPlanService service;

    public MembershipPlanController(MembershipPlanService service) {
        this.service = service;
    }

    @GetMapping
    public List<MembershipPlanDto> getAll() {
        return service.getAll().stream().map(MembershipPlanDto::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipPlanDto> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(MembershipPlanDto::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MembershipPlanDto create(@RequestBody MembershipPlanDto planDto) {
        MembershipPlan plan = MembershipPlanDto.toEntity(planDto);
        return MembershipPlanDto.toDto(service.create(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipPlanDto> update(@PathVariable Long id, @RequestBody MembershipPlanDto planDto) {
        MembershipPlan plan = MembershipPlanDto.toEntity(planDto);
        return service.update(id, plan)
                .map(MembershipPlanDto::toDto)
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