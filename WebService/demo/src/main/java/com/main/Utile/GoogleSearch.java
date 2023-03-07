package com.main.Utile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleSearch {
    
    
    public static ArrayList<Lien> search(String recherche) throws IOException {
    	String url =  "https://www.google.com/search?q="+URLEncoder.encode(recherche, "UTF-8");
        System.out.println("Fetching '"+url+"'...");
    	
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        ArrayList<Lien> retour = new ArrayList<>();


        //print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            if(!link.attr("abs:href").contains(".google.com") && !link.attr("abs:href").startsWith("https://translate.google.com/translate"))
            {
                 //print(" * a: %s  (%s)", link.attr("abs:href"), trim(link.text(), 35));
            	Lien lien = new Lien();
            	lien.setLien(link.attr("abs:href"));
            	lien.setTitre(trim(link.text(), 35));
            	retour.add(lien);
            }
           
        }
        return retour;
    }
    
    
    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
