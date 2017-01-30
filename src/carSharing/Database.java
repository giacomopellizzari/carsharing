package carSharing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.crypto.Data;

import org.apache.commons.lang.StringEscapeUtils;


public class Database {

	public void getAuto(ArrayList<Auto> a1) {

		Connection cn = null;
		Statement st;
		ResultSet rs;

		String sql;
		;

		{
			// ________________________________connessione
			try

			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (

			ClassNotFoundException e11)

			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try

			{
				new java.io.File("src").getCanonicalPath();
			} catch (

			IOException e)

			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try

			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (

			SQLException e2)

			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret

			String marca;
			String modello;
			String targa;
			float costo_giornaliero;
			sql = "SELECT * FROM auto";
			System.out.println(sql);
			// ________________________________query
			try {
				a1.clear();
				st = cn.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Success");
				while (rs.next()) {
					marca = rs.getString("marca");
					modello = rs.getString("modello");
					targa = rs.getString("targa");
					costo_giornaliero = rs.getFloat("costo_giornaliero");
					a1.add(new Auto(marca, modello, targa, costo_giornaliero));
				}
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} // chiusura connessione
		}
	}

	public void getSoci(ArrayList<Soci> a1) {

		Connection cn = null;
		Statement st;
		ResultSet rs;

		String sql;
		;

		{
			// ________________________________connessione
			try

			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (

			ClassNotFoundException e11)

			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try

			{
				new java.io.File("src").getCanonicalPath();
			} catch (

			IOException e)

			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try

			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (

			SQLException e2)

			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret

			String cf;
			String nome;
			String cognome;
			String indirizzo;
			sql = "SELECT * FROM soci";
			System.out.println(sql);
			// ________________________________query
			try {
				a1.clear();
				st = cn.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Success");
				while (rs.next()) {
					cf = rs.getString("cf");
					nome = rs.getString("nome");
					cognome = rs.getString("cognome");
					indirizzo = rs.getString("indirizzo");
					a1.add(new Soci(cf, nome, cognome, indirizzo));
				}
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} // chiusura connessione
		}
	}

	public void getNoleggi(ArrayList<Noleggi> a1) {

		Connection cn = null;
		Statement st;
		ResultSet rs;

		String sql;
		;

		{
			// ________________________________connessione
			try

			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (

			ClassNotFoundException e11)

			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try

			{
				new java.io.File("src").getCanonicalPath();
			} catch (

			IOException e)

			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try

			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (

			SQLException e2)

			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret

			String codNoleggio;
			String auto;
			String socio;
			String dataFine;
			String dataInizio;
			boolean restituita;
			sql = "SELECT * FROM noleggi";
			System.out.println(sql);
			// ________________________________query
			try {
				a1.clear();
				st = cn.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Success");
				while (rs.next()) {
					codNoleggio = rs.getString("codice_noleggio");
					auto = rs.getString("auto");
					socio = rs.getString("socio");
					dataInizio = rs.getString("inizio");
					dataFine = rs.getString("fine");
					restituita = rs.getBoolean("auto_restituita");
					a1.add(new Noleggi(codNoleggio, auto, socio, dataInizio, dataFine, restituita));
				}
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} // chiusura connessione
		}
	}
	
	public void cercaNoleggi(String s,String s1,Main m){

		Connection cn = null;
		Statement st;
		ResultSet rs;

		String sql;
		;

		{
			// ________________________________connessione
			try

			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (

			ClassNotFoundException e11)

			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try

			{
				new java.io.File("src").getCanonicalPath();
			} catch (

			IOException e)

			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try

			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (

			SQLException e2)

			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret

			sql = "SELECT * FROM noleggi WHERE inizio>'" + s + "' AND fine<'" + s1 + "'";
			System.out.println(sql);
			// ________________________________query
			try {
				st = cn.createStatement();
				rs = st.executeQuery(sql);
				System.out.println("Success");
				while (rs.next()) {
					m.nol(rs.getString("codice_noleggio"));
				}
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			}
			}
	}
	
	
	
	public void Elimina(ArrayList<Noleggi> a1, int id){
		Connection cn = null;
		Statement st;
		//ResultSet rs;
		String sql;
		{
			// ________________________________connessione
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (
			ClassNotFoundException e11)
			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try
			{
				new java.io.File("src").getCanonicalPath();
			} catch (
			IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (
			SQLException e2)
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
			
			sql = "Delete from Noleggi "+ "where codice_noleggio ="+ id;
			
			System.out.println(sql);
			// ________________________________query
			try {
				st = cn.createStatement();
				st.execute(sql);
				System.out.println("Success");
				
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} // chiusura connessione
		}
	}
	
	public void EliminaAuto(ArrayList<Auto> a1, String id){
		Connection cn = null;
		Statement st;
		//ResultSet rs;
		String sql;
		String sql2;
		{
			// ________________________________connessione
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			} catch (
			ClassNotFoundException e11)
			{
				System.out.println("ClassNotFoundException: ");
				System.err.println(e11.getMessage());
			} // fine try-catch

			try
			{
				new java.io.File("src").getCanonicalPath();
			} catch (
			IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try
			{
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			} catch (
			SQLException e2)
			{
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
			
			sql = "Delete from Auto "+ "where targa ="+"'"+ id +"'";
			sql2 = "Delete from noleggi where auto ="+"'"+ id +"'";
			System.out.println(sql);
			System.out.println(sql2);
			// ________________________________query
			try {
				st = cn.createStatement();
				st.execute(sql);
				st.execute(sql2);
				System.out.println("Success");
				
			} catch (SQLException e1) {
				System.out.println("errore:" + e1.getMessage());
			} // fine try-catch
			try {
				cn.close();
			} catch (

			SQLException e11)

			{
				// TODO Auto-generated catch block
				e11.printStackTrace();
			} // chiusura connessione
		}
	}
	
		public void Aggiungi(Noleggi n){
			Connection cn = null;
			Statement st;
			//ResultSet rs;
			String sql;
			{
				// ________________________________connessione
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				} catch (
				ClassNotFoundException e11)
				{
					System.out.println("ClassNotFoundException: ");
					System.err.println(e11.getMessage());
				} // fine try-catch

				try
				{
					new java.io.File("src").getCanonicalPath();
				} catch (
				IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try
				{
					cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
				} catch (
				SQLException e2)
				{
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
				//String codNoleggio;



				String dataInizio = StringEscapeUtils.escapeSql(n.getDataInizio());
				String dataFine = StringEscapeUtils.escapeSql(n.getDataFine());
				System.out.println("la data di fine è " + dataFine);
				String auto = StringEscapeUtils.escapeSql(n.getAuto());
				String socio = StringEscapeUtils.escapeSql(n.getSocio());
				boolean restituita = false;
				int tempRestituita;
				if(restituita){
					tempRestituita = 1;
				}else{
					tempRestituita = 0;
				}
				sql = "Insert into Noleggi (auto, socio, inizio, fine, auto_restituita) values ('" + auto +"','" + socio + "','" + dataInizio + "','" + dataFine + "','" + tempRestituita + "')";
				
				System.out.println(sql);
				// ________________________________query
				try {
					st = cn.createStatement();
					st.execute(sql);
					System.out.println("Success");
					
				} catch (SQLException e1) {
					System.out.println("errore:" + e1.getMessage());
				} // fine try-catch
				try {
					cn.close();
				} catch (

				SQLException e11)

				{
					// TODO Auto-generated catch block
					e11.printStackTrace();
				} // chiusura connessione
		}
		}
		
			public void getRicercaAuto(String auto) {

				Connection cn = null;
				Statement st;
				ResultSet rs;

				String sql;
				;
				{
					// ________________________________connessione
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					} catch (
					ClassNotFoundException e11)
					{
						System.out.println("ClassNotFoundException: ");
						System.err.println(e11.getMessage());
					} // fine try-catch
					try
					{
						new java.io.File("src").getCanonicalPath();
					} catch (
					IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try
					{
						cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
					} catch (
					SQLException e2)
					{
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret
					sql = "SELECT * FROM noleggi";
					System.out.println(sql);
					// ________________________________query
					try {
						st = cn.createStatement();
						rs = st.executeQuery(sql);
						System.out.println("Success");
						while (rs.next()) {
							auto = rs.getString("auto");	
						}
					} catch (SQLException e1) {
						System.out.println("errore:" + e1.getMessage());
					} // fine try-catch
					try {
						cn.close();
					} catch (
					SQLException e11)
					{
						// TODO Auto-generated catch block
						e11.printStackTrace();
					} // chiusura connessione
				}
			}
}

