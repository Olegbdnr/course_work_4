package com.lviv.iot.soportua.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private AreaType areaType;

    @Column(nullable = false)
    private String description;

    @Column
    private int pricePerHour;

    @Column
    private int capacity;

    @Column
    private boolean isIndoor;

    @Column
    private int length;

    @Column
    private int width;
}
