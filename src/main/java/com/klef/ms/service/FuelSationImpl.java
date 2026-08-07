package com.klef.ms.service;

import java.util.List;


import com.klef.ms.entity.FuelStation;
import com.klef.ms.repository.FuelStationRepository;

public class FuelSationImpl implements FuelStationService{
private FuelStationRepository  repo;
	@Override
	public FuelStation insert(FuelStation entity) {
		if(!repo.existsById(entity.getId())) {
			return repo.save(entity);
		}else {
			return null;
		}
	}

	@Override
	public List<FuelStation> display() {
		return repo.findAll();
	}

	@Override
	public FuelStation displayById(Long id) {
		if(repo.existsById(id)) {
		return null;
		}else {
			return repo.findById(id).get();
		}
	}

	@Override
	public String deleteById(Long id) {
		if(repo.existsById(id)) {
			 repo.deleteById(id);
			 return "SuccessFully Deleted";
			 
			}else {
				return "Id Not Found"+id;
			}
	}

	@Override
	public FuelStation update(FuelStation entity) {
		if(repo.existsById(entity.getId())) {
			FuelStation f=repo.findById(entity.getId()).get();
			f.setName(entity.getName());
			f.setLocation(entity.getLocation());
			f.setType(entity.getType());
			f.setCreatedAt(entity.getCreatedAt());
			f.setUpdatedAt(entity.getUpdatedAt());
			f.setStatus(entity.isStatus());
			return repo.save(f);
			
		}else {
			return null;
		}
	}

	@Override
	public List<FuelStation> getbyName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<FuelStation> getByType(String type) {
		return repo.findByType(type);
	}
	

}
