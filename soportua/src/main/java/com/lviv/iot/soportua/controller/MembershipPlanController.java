package com.lviv.iot.soportua.controller;

import com.lviv.iot.soportua.domain.MembershipPlan;
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
    public List<MembershipPlan> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipPlan> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MembershipPlan create(@RequestBody MembershipPlan plan) {
        return service.create(plan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipPlan> update(@PathVariable Long id, @RequestBody MembershipPlan plan) {
        return service.update(id, plan)
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