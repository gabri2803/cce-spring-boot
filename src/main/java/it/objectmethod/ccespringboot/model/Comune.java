package it.objectmethod.ccespringboot.model;

public class Comune {

	private int istat;
	private String nome;
	private String provincia;
	private String regione;
	private int prefisso;
	private String cap;
	private String codFisco;
	private int abitanti;
	private String link;

	public int getIstat() {
		return istat;
	}

	public void setIstat(int istat) {
		this.istat = istat;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public int getPrefisso() {
		return prefisso;
	}

	public void setPrefisso(int prefisso) {
		this.prefisso = prefisso;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCodFisco() {
		return codFisco;
	}

	public void setCodFisco(String codFisco) {
		this.codFisco = codFisco;
	}

	public int getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(int abitanti) {
		this.abitanti = abitanti;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Comune [istat=" + istat + ", nome=" + nome + ", provincia=" + provincia + ", regione=" + regione
				+ ", prefisso=" + prefisso + ", cap=" + cap + ", codFisco=" + codFisco + ", abitanti=" + abitanti
				+ ", link=" + link + "]";
	}

}
