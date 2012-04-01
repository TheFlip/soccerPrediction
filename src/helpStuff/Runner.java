package helpStuff;

import model.Saison;

public class Runner {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		Saison ersteBundesliga = new Saison(18, "2011/2012");
		Saison[] ersteBundesliga1 = new Saison[8];
		
		// Prototype - We need to change this with getting 
		// the files with syscalls and autoparsing
		for(int i = 0; i < ersteBundesliga1.length; i++){
			ersteBundesliga1[i] = new Saison(18, i+1993 + "/" + new Integer(i+1994));
			InputReader ir = new InputReader("resources/Germany_1/input/D1 (" + new Integer(i+12) +").csv");
			ir.parseFile(ersteBundesliga1[i]);
		}
		
		//InputReader ir = new InputReader("resources/Germany_1/input/D1 (19).csv");
		//ir.parseFile(ersteBundesliga1);
		OutputWriter wr = new OutputWriter("resources/Germany_1/output/D1_try2_fromFifth_withLast5_withBWIN.csv", ersteBundesliga1);
		//ersteBundesliga1[7].getTeam("Schalke 04").printSpiele();

	}

}
