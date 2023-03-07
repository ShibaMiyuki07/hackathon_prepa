package com.main.Base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	private static String url = "jdbc:postgresql://containers-us-west-26.railway.app:7589/hackathon";
    private static String user="postgres";
    private static String passwd = "Kamisato";
	private  Connection connect;
	public  Connection setConnect()
	{
		if (connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connect;
	}
}
