package com.main.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Model.Matiere;

@RestController
public class MatiereController {
	
	@GetMapping("/matiere")
	public ArrayList<Matiere> selectAll() throws SQLException
	{
		return new Matiere().read();
	}
}
