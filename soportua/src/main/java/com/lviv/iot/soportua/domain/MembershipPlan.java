package com.lviv.iot.soportua.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "membership_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private MembershipCategory category;

    @ElementCollection(targetClass = AccessType.class)
    @CollectionTable(name = "access_type", joinColumns = @JoinColumn(name = "membership_plan_id"))
    @Enumerated(EnumType.STRING)
    private Set<AccessType> allowedAccess;

    @Column
    private int price;

    @Column
    private int discountPercent;

    @Column
    private int durationInMonth;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MembershipCategory getCategory() {
        return category;
    }

    public Set<AccessType> getAllowedAccess() {
        return allowedAccess;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(MembershipCategory category) {
        this.category = category;
    }

    public void setAllowedAccess(Set<AccessType> allowedAccess) {
        this.allowedAccess = allowedAccess;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDurationInMonth(int durationInMonth) {
        this.durationInMonth = durationInMonth;
    }

    public int getDurationInMonth() {
        return durationInMonth;
    }
}
