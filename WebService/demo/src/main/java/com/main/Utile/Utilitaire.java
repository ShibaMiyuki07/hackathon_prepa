package com.main.Utile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.main.Model.Matiere;
import com.main.Model.Note_etudiant_matiere;

public class Utilitaire {
	public ArrayList<Lien> suggestion(String idEtudiant,String idmatiere) throws SQLException, IOException
	{
		Note_etudiant_matiere retour = new Note_etudiant_matiere().select(idEtudiant, idmatiere);
		Matiere matiere = new Matiere().select(idmatiere);
		String suggestion = "";
		if(retour.getNote() > 10)
		{
			suggestion = "exercice "+matiere.getNomMatiere().replace(" ", "");
		}
		else
		{
			suggestion = "tuto "+matiere.getNomMatiere().replace(" ", "");
		}
		return GoogleSearch.search(suggestion);
	}
}
