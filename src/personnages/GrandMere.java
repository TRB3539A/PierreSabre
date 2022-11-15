package personnages;

import java.util.Random;

public class GrandMere extends Humain{

	private Random r = new Random();

	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	public void memoriser(Humain humain) {
		if (this.nbConnaissance < 5) {
			this.connaissance[this.nbConnaissance] = humain;
			this.nbConnaissance++;
		}
		else {
			parler("Oh ma tete! Je ne peux plus retenir le nom d'une personne supplementaire!");
		}
	}
	
	private String humainHazard() {
		int value = this.r.nextInt(6);

        switch( value ) {
            case 0:
            	return "un commercant";
            case 1:
            	return "une grand-mere";
            case 2:
            	return "un habitant";
            case 3:
            	return "un ronin";
            case 4:
            	return "un samourai";
            case 5:
            	return "un yakuza";
            default:
            	return "erreur";
        }
	}
	
	public void ragoter() {
		for(int i=0; i<5; i++) {
			if(this.connaissance[i] instanceof Traitre) {
				parler("Je sais que " + this.connaissance[i].getNom() + " est un traitre. Petit chenapan!");
			}
			else {
				parler("Je crois que " + this.connaissance[i].getNom() + " est " + this.humainHazard());
			}
		}
	}

}
