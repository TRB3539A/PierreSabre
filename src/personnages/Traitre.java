package personnages;

import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise = 0;
	private Random r = new Random();

	public Traitre(String seigneur, String nom, String boisson, int argent) {
		super(seigneur, nom, boisson, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est: " + this.niveauTraitrise + ". Chut!");
	}
	
	public void ranconner(Commercant commercant) {
		if (this.niveauTraitrise < 3) {
			int argentRanconner = commercant.getArgent() * 2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			this.niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer! Donne-moi " + argentRanconner + " sous ou gare à toi!");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		}
		else {
			parler("Mince je ne peux plus ranconner personne sinon un samourai risque de me demasquer!");
		}
	}
	
	public void faireLeGentil() {
		if (this.nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne! Snif.");
		}
		else {
			int nRand = this.r.nextInt(this.nbConnaissance);
			Humain humain = connaissance[nRand];
			int don = getArgent()*1/20;
			String nomAmi = humain.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami! Je voudrais vous aider en vous donnant " + don + " sous.");
			humain.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			humain.parler("Merci " + nom + ". Vous etes quelqu'un de bien.");
			if (this.niveauTraitrise > 1) {
				this.niveauTraitrise--;
			}
		}
	}

}
