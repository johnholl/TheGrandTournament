import java.util.ArrayList;

public class CongGrandTournament {

	
	public static void main(String args[]) {
		CongBot bot1 = new CongBotAdams();
		CongBot bot2 = new CongBotBechar();
		CongBot bot3 = new CongBotBranch();
		CongBot bot4 = new CongBotCole();
		CongBot bot5 = new CongBotFujii();
		CongBot bot6 = new CongBotGarcia();
		CongBot bot7 = new CongBotHsu();
		CongBot bot8 = new CongBotKretzler();
		CongBot bot9 = new CongBotMiech();
		CongBot bot10 = new CongBotNishi();
		CongBot bot11 = new CongBotSeir();
		CongBot bot12 = new CongBotSong();
		CongBot bot13 = new CongBotSrinivasan();
		CongBot bot14 = new CongBotWelch();
		CongBot bot15 = new CongBotWen();
		CongBot bot16 = new CongBotMian();
		CongBot bot17 = new CongBotGeng();
		
		
		ArrayList<CongBot> botList = new ArrayList<CongBot>();
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
		
		CongTournament myTournament = new CongTournament(300, botList, false);
		myTournament.runTournament();
		
		
		
		
	}
}
