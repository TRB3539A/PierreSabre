package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	private int tailleMemoire = 30;
	protected Humain[] connaissance = new Humain[tailleMemoire];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}
	
	public void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour! Je m'appelle " + this.nom + " et j'aime boire du " + this.boisson + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + this.boisson + "! GLOUPS!");
	}
	
	public void acheter(String bien, int prix) {
		if(prix <= this.argent) {
			parler("J'ai " + this.argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			this.argent -= prix;
		}
		else {
			parler("Je n'ai plus que " + this.argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}
	
	public void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	public void perdreArgent(int perte) {
		this.argent -= perte; 
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void memoriser(Humain humain) {
		if (this.nbConnaissance < this.tailleMemoire) {
			this.connaissance[this.nbConnaissance] = humain;
			this.nbConnaissance++;
		}
	}
	
	public void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		if (this.nbConnaissance > 0) {
			String texte = "";
			for (int i = 0; i < this.nbConnaissance; i++) {
				texte += this.connaissance[i].getNom();
				if (i+1 < this.nbConnaissance) {
					texte += ", ";
				}
			}
			parler("Je connais beaucoup de monde dont: " + texte + ".");
		}
		else {
			parler("Je ne connais personne.");
		}
	}
}
