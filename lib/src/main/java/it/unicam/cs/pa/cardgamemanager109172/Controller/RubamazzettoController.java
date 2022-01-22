package it.unicam.cs.pa.cardgamemanager109172.Controller;

import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;
import it.unicam.cs.pa.cardgamemanager109172.View.GameView;
import java.util.Random;
import java.util.Scanner;

public class RubamazzettoController {

    private final Scanner user = new Scanner(System.in);
    private final Rubamazzetto rm = new Rubamazzetto(GameController.playerName);
    private final Rubamazzetto.Actions action = rm.new Actions();
    private final GameView gView = new GameView();

    public void play(){
        rm.newGame();
        gView.getInitView();
        Player bot = rm.getBot();
        Player p1 = rm.getPlayerOne();
        do{
            gView.getActualVew(rm);
            if(rm.getTurn() % 2 == 0){
                gView.getTurner(p1);
                gView.askNextMove();
                int choice = user.nextInt();
                switch (choice){
                    case 1:
                        action.stealBounch(rm.getPlayerOne());
                    case 2:
                        //action.makeMove(starter,);
                    case 3:
                        gView.sayGoodbye();
                        System.exit(0);
                }
            } else {
                gView.getTurner(bot);
                if(!action.stealBounch(bot)){
                    Random rand = new Random();
                    int upperbound = bot.getPlayerHand().getCards().size();
                    action.makeMove(bot,rand.nextInt(upperbound));
                }
            }
        } while (rm.finishGame() == null);
    }
}
