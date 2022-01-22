package it.unicam.cs.pa.cardgamemanager109172.Controller;

import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;
import it.unicam.cs.pa.cardgamemanager109172.View.RubamazzettoView;
import java.util.Random;
import java.util.Scanner;

public class RubamazzettoController {

    public void play(){
        Scanner user = new Scanner(System.in);
        Rubamazzetto rm = new Rubamazzetto(GameController.playerName);
        Rubamazzetto.Actions action = rm.new Actions();
        RubamazzettoView rmView = new RubamazzettoView();
        rm.newGame();
        rmView.getInitView();
        Player bot = rm.getBot();
        Player p1 = rm.getPlayerOne();
        do{
            rmView.getActualView(rm);
            if(rm.getTurn() % 2 == 0){
                rmView.getOnTopBounch(rm);
                rmView.getTurner(p1);
                rmView.askNextMove();
                int choice = user.nextInt();
                user.nextLine();
                switch (choice) {
                    case 1:
                        if (action.stealBounch(rm.getPlayerOne())) {
                            rmView.succesfullySteal(p1);
                            break;
                        }
                        rmView.notStealed(rm);
                    case 2:
                        rmView.selectCard(rm);
                        int selectedCardIndex = user.nextInt();
                        user.nextLine();
                        action.makeMove(p1, selectedCardIndex - 1);
                        break;
                    case 3:
                        user.close();
                        rmView.sayGoodbye();
                        System.exit(0);
                }
            } else {
                rmView.getTurner(bot);
                if(!action.stealBounch(bot)){
                    Random rand = new Random();
                    int upperbound = bot.getPlayerHand().getCards().size();
                    action.makeMove(bot,rand.nextInt(upperbound));
                } else rmView.succesfullySteal(bot);
            }
        } while (rm.finishGame() == null);
        user.close();
        rmView.getWinner(rm.finishGame());
        rmView.sayGoodbye();
    }
}
