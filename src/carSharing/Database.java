package carSharing;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String cf;
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
					cf = rs.getString("socio");
					auto = rs.getString("auto");
					codNoleggio = rs.getString("codice_noleggio");
					dataFine = rs.getString("fine");
					dataInizio = rs.getString("inizio");
					restituita = rs.getBoolean("auto_restituita");
					a1.add(new Noleggi(codNoleggio, cf, auto, dataInizio, dataFine, dataInizio, restituita));
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
	public void Elimina(ArrayList<Auto> a1){
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
}

