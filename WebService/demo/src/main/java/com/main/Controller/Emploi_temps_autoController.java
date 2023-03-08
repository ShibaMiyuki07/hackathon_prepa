package com.main.Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.Model.Emploi_temps_auto;
import com.main.View.V_Emploi_Matiere_Jour;

@RestController
@RequestMapping("/emploi_auto")
public class Emploi_temps_autoController {
	
	@GetMapping("/{idetudiant}")
	public ArrayList<V_Emploi_Matiere_Jour> emploiAuto(@PathVariable("idetudiant") String id) throws SQLException
	{
		return new Emploi_temps_auto().creation_Auto(id);
	}
}
