package com.lviv.iot.soportua.repository;

import com.lviv.iot.soportua.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findAllByClient_Id(Long id);
}
