package com.main.Controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.Model.Cycle;

@RestController
public class CycleController {
	
	@PostMapping("/cycle")
	public void create(@RequestBody Cycle cycle) throws SQLException
	{
		new Cycle().create(cycle);
	}
	
	@GetMapping("/cycle/{idEtudiant}")
	public Cycle selectbyEtudiant(@PathVariable("idEtudiant") String id) throws SQLException
	{
		return new Cycle().selectByEtudiant(id);
	}
	
	
}
