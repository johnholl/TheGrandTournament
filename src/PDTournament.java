import java.util.ArrayList;

public class PDTournament {
	
	private int rounds;
	private ArrayList<PDBot> botList;
	private boolean selfMatchup;
	
	public PDTournament(int rd, ArrayList<PDBot> bl, boolean sm) {
		rounds = rd;
		botList = bl;
		selfMatchup = sm;
	}
	
	public PDTournament(int rd, ArrayList<PDBot> bl) {
		rounds = rd;
		botList = bl;
		selfMatchup = true;

	}

	
	public PDTournament(int rd, PDBot b1, PDBot b2) {
		rounds=rd;
		botList = new ArrayList<PDBot>();
		botList.add(b1);
		botList.add(b2);
		selfMatchup = false;

	}
	
	public int[][] runTournament() {
		int[][] statistics = new int[botList.size()][6];
		
		int[][] matchStats = new int[2][6];
		for(int i = 0; i<botList.size(); i++) {
			if(!selfMatchup) {
			for(int j = 0; j < i; j++) {
				matchStats = matchUp(i, j);
				statistics[i][0] += matchStats[0][0];
				statistics[j][0] += matchStats[1][0];
				statistics[i][1] += matchStats[0][1];
				statistics[j][1] += matchStats[1][1];
				statistics[i][2] += matchStats[0][2];
				statistics[j][2] += matchStats[1][2];
				statistics[i][3] += matchStats[0][3];
				statistics[j][3] += matchStats[1][3];
				
				statistics[i][4] += matchStats[0][4];
				statistics[j][4] += matchStats[1][4];
				
				statistics[i][5] += matchStats[0][5];
				statistics[j][5] += matchStats[1][5];
				}
			}
			
			else {

				for(int j = 0; j <= i; j++) {
					matchStats = matchUp(i, j);
					statistics[i][0] += matchStats[0][0];
					statistics[j][0] += matchStats[1][0];
					statistics[i][1] += matchStats[0][1];
					statistics[j][1] += matchStats[1][1];
					statistics[i][2] += matchStats[0][2];
					statistics[j][2] += matchStats[1][2];
					statistics[i][3] += matchStats[0][3];
					statistics[j][3] += matchStats[1][3];
					
					statistics[i][4] += matchStats[0][4];
					statistics[j][4] += matchStats[1][4];
					
					statistics[i][5] += matchStats[0][5];
					statistics[j][5] += matchStats[1][5];
					}
			}
		}
		System.out.println("TOTALS");
		System.out.println("----------------------");
		System.out.println("                              | Total Sc |    CC    |    CD    |    DC    |    DD    |    WN    |");
		for(int i=0; i < botList.size(); i++) {
			System.out.printf("%30s: %5d %10d %10d %10d %10d %10d \n" , botList.get(i), statistics[i][4], statistics[i][0], statistics[i][1], statistics[i][2], statistics[i][3], statistics[i][5]);
		}	
		
		return statistics;
	}
	
	
	public int[][] matchUp(int i, int j) {
		int[][] matchStatistics = new int[2][6];
		boolean a1, a2, a3, b1, b2, b3;
		a1 = a2 = a3 = b1 = b2 = b3 = true;
		double aCooperate = 0.;
		double bCooperate = 0.;
		boolean aAction;
		boolean bAction;
		for (int counter=0; counter<rounds; counter++) {
			
			// get the next actions
			aAction = botList.get(i).play(a1, b1, a2, b2, a3, b3, bCooperate, counter, rounds);
			bAction = botList.get(j).play(b1, a1, b2, a2, b3, a3, aCooperate, counter, rounds);
			
			// alter the cooperation fractions
			if (aAction) {
			aCooperate = aCooperate*( (double) counter / (counter + 1)) + 1.0 / (counter + 1);
			}
			else {
				aCooperate = aCooperate*( (double) counter / (counter + 1));
			}
			
			if (bAction) {
			bCooperate = bCooperate*( (double) counter / (counter + 1)) + 1.0 / (counter + 1);
			}
			else {
				bCooperate = bCooperate*( (double) counter / (counter + 1));
			}
			
			int[] newScores = this.takeAction(aAction, bAction);
			if(aAction && bAction) {
				matchStatistics[0][0] += 1;
				matchStatistics[1][0] += 1;
			}
			else if(aAction && !bAction) {
				matchStatistics[0][1] += 1;
				matchStatistics[1][2] += 1;
			}
			else if(!aAction && bAction) {
				matchStatistics[0][2] += 1;
				matchStatistics[1][1] += 1;
			}
			else {
				matchStatistics[0][3] += 1;
				matchStatistics[1][3] += 1;
			}
			
			matchStatistics[0][4] += newScores[0];
			matchStatistics[1][4] += newScores[1];
			
			a3 = a2;
			b3 = b2;
			a2 = a1;
			b2 = b1;
			a1 = aAction;
			b1 = bAction;
			
		}
		if(matchStatistics[0][4] > matchStatistics[1][4]) {
			matchStatistics[1][5] += 1;
		}
		else if(matchStatistics[0][4] < matchStatistics[1][4]) {
			matchStatistics[0][5] += 1;
		}
		
		
		return matchStatistics;
	}
	
	public int[] takeAction(boolean a, boolean b) {
		int[] scoreArr = new int[2];
		if(a && b) {
			scoreArr[0] = 1;
			scoreArr[1] = 1;
		}
		else if (a && !b) {
			scoreArr[0] = 3;
			scoreArr[1] = 0;
		}
		else if (!a && b) {
			scoreArr[0] = 0;
			scoreArr[1] = 3;
		}
		else {
			scoreArr[0] = 2;
			scoreArr[1] = 2;
		}
		
		return scoreArr;
	}

}
