package com.main.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.Utile.Lien;
import com.main.Utile.Utilitaire;

@RestController
public class SuggestionController {
	
	@GetMapping("/suggestion/{idetudiant}/{idmatiere}")
	public ArrayList<Lien> getSuggestion(@PathVariable("idetudiant") String idetudiant,@PathVariable("idmatiere") String idmatiere) throws IOException, SQLException
	{
		return new Utilitaire().suggestion(idetudiant, idmatiere);
	}
}
