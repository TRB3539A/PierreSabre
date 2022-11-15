package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l�?");
		parler(victime.getNom() + ", si tu tiens � la vie donne moi ta bourse !");
		int argentVole = victime.seFaireExtorquer();
		gagnerArgent(argentVole);
		this.reputation++;
		parler("J'ai piqu� les " + argentVole + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi! Hi!");
	}

	public int perdre() {
		int argent = getArgent();
		perdreArgent(argent);
		this.reputation--;
		parler("J'ai perdu mon duel et mes " + argent + " sous, snif... J'ai d�shonnor� le clan de " + this.clan + ".");
		return argent;
	}

	public int getReputation() {
		return reputation;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		this.reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + this.clan
				+ "? Je l'ai d�pouill� de ses " + gain + " sous.");
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + this.clan + ".");
	}
}
