import java.util.ArrayList;

public class PDGrandTournament {

	
	public static void main(String args[]) {
		PDBot bot1 = new PDBotAdams();
		PDBot bot2 = new PDBotBechar();
		PDBot bot3 = new PDBotBranch();
		PDBot bot4 = new PDBotCole();
		PDBot bot5 = new PDBotFujii();
		PDBot bot6 = new PDBotGarcia();
		PDBot bot7 = new PDBotHsu();
		PDBot bot8 = new PDBotKretzler();
		PDBot bot9 = new PDBotMiech();
		PDBot bot10 = new PDBotNishi();
		PDBot bot11 = new PDBotSeir();
		PDBot bot12 = new PDBotSong();
		PDBot bot13 = new PDBotSrinivasan();
		PDBot bot14 = new PDBotWelch();
		PDBot bot15 = new PDBotWen();
		PDBot bot16 = new PDBotMian();
		PDBot bot17 = new PDBotGeng();
		PDBot bot18 = new PDBotNorton();
		
		
		ArrayList<PDBot> botList = new ArrayList<PDBot>();
		botList.add(bot1);
		botList.add(bot2);
		botList.add(bot3);
		botList.add(bot4);
		botList.add(bot5);
		botList.add(bot6);
		botList.add(bot7);
		botList.add(bot8);
		botList.add(bot9);
		botList.add(bot10);
		botList.add(bot11);
		botList.add(bot12);
		botList.add(bot13);
		botList.add(bot14);
		botList.add(bot15);
		botList.add(bot16);
		botList.add(bot17);
		botList.add(bot18);
		
		PDTournament myTournament = new PDTournament(300, botList, false);
		
		
		myTournament.runTournament();
		
	}
}
