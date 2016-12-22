package carSharing;

public class Noleggi {
	String codNoleggio;
	String auto;
	String cf;
	String dataFine;
	String dataInizio;
	boolean restituita;

	public Noleggi(String cf,String nome,String codNoleggio,String auto,String dataInizio,String dataFine,boolean restituita) {
		this.restituita = restituita;
		this.cf = cf;
		this.dataFine = dataFine;
		this.codNoleggio = codNoleggio;
		this.auto = auto;
		this.dataInizio = dataInizio;
	}

	@Override
	public String toString() {
		return "Noleggi [codNoleggio=" + codNoleggio + ", auto=" + auto + ", cf=" + cf + ", dataFine=" + dataFine
				+ ", dataInizio=" + dataInizio + ", restituita=" + restituita + "]";
	}

	public String getCodNoleggio() {
		return codNoleggio;
	}

	public void setCodNoleggio(String codNoleggio) {
		this.codNoleggio = codNoleggio;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public boolean isRestituita() {
		return restituita;
	}

	public void setRestituita(boolean restituita) {
		this.restituita = restituita;
	}
}
