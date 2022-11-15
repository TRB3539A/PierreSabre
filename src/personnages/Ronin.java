package personnages;

public class Ronin extends Humain{
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDonne = getArgent()*1/10;
		parler(beneficiaire.getNom() + " prend ces " + argentDonne + " sous.");
		beneficiaire.recevoir(argentDonne);
		perdreArgent(argentDonne);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force = this.honneur*2;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t'ai eu petit yakuza!");
			gagnerArgent(adversaire.perdre());
			this.honneur ++;
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			this.honneur --;
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
		}
	}
}
