package com.klef.ms.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klef.ms.entity.FuelStation;
import com.klef.ms.service.FuelStationService;

@RestController
@RequestMapping("/fuel")
public class FuelStationController {
	private FuelStationService service;
	@GetMapping("/all")
	public ResponseEntity<?> getall(){
		List<FuelStation> list=service.display();
		if(list.size()!=0) {
			return  ResponseEntity.status(200).body(service.display());
		}else {
			return ResponseEntity.status(404).body("Not Records Found");
		}
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insert(@RequestBody FuelStation entity) {
		return ResponseEntity.status(201).body(service.insert(entity));
	}
	@PutMapping("/modify")
	public ResponseEntity<?> update(@RequestBody FuelStation entity){
		FuelStation f=service.update(entity);
		if(f==null)
		return ResponseEntity.ok(f);
		else
			return ResponseEntity.status(401).body("Not found with Id");
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id){
		return  ResponseEntity.status(200).body(service.deleteById(id));
	}
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<List<FuelStation>> get(@PathVariable String name){
		List<FuelStation> list=service.getbyName(name);

			return ResponseEntity.status(200).body(list);
		
	}
	@GetMapping("/getbyType/{name}")
	public ResponseEntity<List<FuelStation>> getByType(@PathVariable ("name")String type){
		List<FuelStation> list=service.getByType(type);
			return ResponseEntity.status(200).body(list);
	
	}
	
	
}
