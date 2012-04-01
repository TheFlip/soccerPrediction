package helpStuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

import model.Saison;
import model.Team;

public class InputReader {
	BufferedReader r;
	String filePath;

	public InputReader(String path) {

		this.filePath = path;

		try {
			r = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[Warning] Cannot open File '" + path + "'");
		}
	}

	public void parseFile(Saison lc) {
		String inputLine;
		String[] tokens;
		int lineNumber = 0, tokenNumber = 0;
		int[] bwin = new int[3];

		try {
			while ((inputLine = r.readLine()) != null) {
				tokens = inputLine.split(",");
				if (lineNumber > 0 && tokens.length != 0) {

					// Erzeuge Mannschaften
					if (lineNumber <= lc.getTeamCount() / 2) {
						lc.addTeam(new Team(tokens[2]));
						lc.addTeam(new Team(tokens[3]));
					}
					
					if((lineNumber-1)%9==0){
						lc.updateTabel();
						lc.incSpielTag();
					}

					if(bwin[0] != 0 && bwin[1] != 0 && bwin[2] != 0)
						lc.addGame(lc.getTeam(tokens[2]), lc.getTeam(tokens[3]), new Integer(tokens[4]), new Integer(tokens[5]),
							new Float(tokens[bwin[0]]), new Float(tokens[bwin[1]]), new Float(tokens[bwin[2]]));
					else
						lc.addGame(lc.getTeam(tokens[2]), lc.getTeam(tokens[3]), new Integer(tokens[4]), new Integer(tokens[5]));
					

				}/* END if for linenumbers*/
				else{
					int count = 0;
					for(String s : tokens){
						if(s.equals("BWH")){
							bwin[0] = count;
						}else if(s.equals("BWD")){
							bwin[1] = count;
						}else if(s.equals("BWA"))
							bwin[2] = count;
						
						count++;
					}
				}
				tokenNumber = 0;
				lineNumber++;
			}/* END LINE LOOP */
			lc.updateTabel();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Warning] Problem with parsing file '"
					+ filePath + "'");
		}
		//lc.printTabelle(27);
		//System.out.println(lc.getTeam("Dortmund").getGoalsShooten());
		
	}

}
