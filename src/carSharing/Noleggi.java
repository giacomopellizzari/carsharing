package carSharing;

public class Noleggi {
	String codNoleggio;
	String auto;
	String socio;
	String dataFine;
	String dataInizio;
	boolean restituita;

	public Noleggi(String codNoleggio,String auto,String socio,String dataInizio,String dataFine,boolean restituita) {
		this.restituita = restituita;
		this.socio = socio;
		this.dataFine = dataFine;
		this.codNoleggio = codNoleggio;
		this.auto = auto;
		this.dataInizio = dataInizio;
	}

	@Override
	public String toString() {
		return "Noleggi [codNoleggio=" + codNoleggio + ", auto=" + auto + ", socio=" + socio + ", dataFine=" + dataFine
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

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
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
