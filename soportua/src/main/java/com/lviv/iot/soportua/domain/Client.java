package com.lviv.iot.soportua.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String profilePhotoUrl;

    @Column
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private int bonusBalance;

    @OneToMany(mappedBy = "client")
    private List<Membership> memberships = new ArrayList<>();
}
