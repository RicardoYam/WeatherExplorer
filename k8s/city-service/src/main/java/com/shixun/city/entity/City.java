package com.shixun.city.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country")
    private String country;

    @Column(name = "lattitude")
    private BigDecimal lattitude;

    @Column(name = "longitude")
    private BigDecimal longitude;
}
