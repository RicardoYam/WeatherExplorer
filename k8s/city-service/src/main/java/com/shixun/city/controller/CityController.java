package com.shixun.city.controller;

import com.shixun.city.entity.City;
import com.shixun.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/city", produces = "application/json;charset=UTF-8")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public City getCityByName(@RequestParam("name") String name) {
        return cityService.findCityByName(name);
    }

    @GetMapping("findAll")
    public List<City> getAllCity() {
        return cityService.findAllCity();
    }
}
