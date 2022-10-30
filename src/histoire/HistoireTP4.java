package histoire;

import personnages.*;

public class HistoireTP4 {
	public static void main(String[] args) {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
		System.out.println();
		
		Commercant marco = new Commercant("Marco", 20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
		System.out.println();
		
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Les wati BG");
		yaku.direBonjour();
		yaku.extorquer(marco);
	}
}
