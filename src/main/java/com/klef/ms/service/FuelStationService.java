package com.klef.ms.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.klef.ms.entity.FuelStation;
@Service
public interface FuelStationService {

	FuelStation insert(FuelStation entity);
	List<FuelStation> display();
	FuelStation displayById(Long id);
	String deleteById(Long id);
	FuelStation update(FuelStation entity);
	List<FuelStation> getbyName(String name);
	List<FuelStation> getByType(String type);
}
