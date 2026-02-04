package com.lviv.iot.soportua.repository;

import com.lviv.iot.soportua.domain.AreaBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaBookingRepository extends JpaRepository<AreaBooking, Long> {
}
