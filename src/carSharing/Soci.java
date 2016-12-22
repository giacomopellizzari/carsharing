package carSharing;

public class Soci {

	String cf;
	String nome;
	String cognome;
	String indirizzo;

	public Soci(String cf,String nome,String cognome,String indirizzo) {
		this.indirizzo = indirizzo;
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	@Override
	public String toString() {
		return "Soci [cf=" + cf + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo=" + indirizzo + "]";
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
}
