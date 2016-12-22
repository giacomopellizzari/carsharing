package carSharing;

public class Auto {
	
	String marca;
	String modello;
	String targa;
	float costo_giornaliero;

	public Auto(String marca,String modello,String targa,float costo_giornaliero) {
		this.costo_giornaliero = costo_giornaliero;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public float getCosto_giornaliero() {
		return costo_giornaliero;
	}

	public void setCosto_giornaliero(float costo_giornaliero) {
		this.costo_giornaliero = costo_giornaliero;
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modello=" + modello + ", targa=" + targa + ", costo_giornaliero="
				+ costo_giornaliero + "]";
	}
	
	
}
