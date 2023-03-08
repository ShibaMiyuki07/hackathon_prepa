package com.main.Controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Model.Etudiant;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
	
	@PostMapping("/login")
	public Etudiant login(@RequestBody Etudiant etudiant) throws SQLException
	{
 		return new Etudiant().login(etudiant);
	}
}
