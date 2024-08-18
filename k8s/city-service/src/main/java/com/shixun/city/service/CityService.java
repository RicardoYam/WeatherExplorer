package com.shixun.city.service;

import com.shixun.city.entity.City;
import com.shixun.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findCityByName(String name) {
        return cityRepository.findByCityName(name);
    }

    public List<City> findAllCity() {
        return cityRepository.findAll();
    }
}
