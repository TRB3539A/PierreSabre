package personnages;

public class Traitre extends Samourai{
	
	private int niveauTraitrise = 0;

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
			
		}
	}

}
