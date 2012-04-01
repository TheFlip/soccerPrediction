package helpStuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Saison;
import model.Spieltag;

public class OutputWriter {

	private BufferedWriter bw;
	private Saison[] lc;
	private String filePath;

	public OutputWriter(String path, Saison... lcs) {
		try {
			if (lcs == null || lcs.length == 0)
				throw new IOException();

			bw = new BufferedWriter(new FileWriter(new File(path)));
			bw
					.write("#Home Points, Away Points, Home Goals Shooten, Home Goals Got, Away Goals Shooten, Away Goals Got, Result(0 ^= draw, 1 ^= homeWin, 2 ^= awayWin), QuoteHome Bwin, QuoteDraw Bwin, QuoteAway Bwin \n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out
					.println("[Warning] Could not create file '" + path + "'");
		}

		this.filePath = path;

		this.lc = lcs;

		this.write();
	}

	public void write() {
		for (Saison saison : lc) {
			ArrayList<Spieltag> spieltage = saison.getSpieltage();
			int counter = 0;
			for (Spieltag st : spieltage) {
				if (counter >= 5)
					for (String ss : st.getSpielString()) {
						try {
							bw.write(ss);
							System.out.print(ss);
						} catch (IOException e) {
							e.printStackTrace();
							System.out
									.println("[Warning] Could not write in file '"
											+ this.filePath + "'");
						}
					}
				counter++;
			}
		}

		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[Warning] Could not close file '"
					+ this.filePath + "'");
		}

	}

}
