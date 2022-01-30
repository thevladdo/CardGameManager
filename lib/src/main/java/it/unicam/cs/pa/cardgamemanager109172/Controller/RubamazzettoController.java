package it.unicam.cs.pa.cardgamemanager109172.Controller;

import it.unicam.cs.pa.cardgamemanager109172.Model.Game.Rubamazzetto;
import it.unicam.cs.pa.cardgamemanager109172.Model.Library.Player;
import it.unicam.cs.pa.cardgamemanager109172.View.RubamazzettoView;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RubamazzettoController {

    private final Scanner user = new Scanner(System.in);
    private final Rubamazzetto rm = new Rubamazzetto(GameController.playerName);
    private final Rubamazzetto.Actions action = rm.new Actions();
    private final RubamazzettoView rmView = new RubamazzettoView();

    /**
     * This method starts the implemented game {@link Rubamazzetto} with the ideated business logic.
     * Ask the player for his strategies and do the adversary bot movements.
     */
    public void play(){
        rm.newGame();
        rmView.getInitView();
        Player bot = rm.getBot();
        Player p1 = rm.getPlayerOne();
        do{
            rmView.getActualView(rm);
            if(rm.getTurn() % 2 == 0){
                doPlayerActions(p1);
            } else doBotActions(bot);
        } while (rm.finishGame() == null);
        user.close();
        rmView.getWinner(rm.finishGame());
        rmView.sayGoodbye();
    }

    private void doPlayerActions(Player p1) {
        rmView.getOnTopBounch(rm);
        rmView.getTurner(p1);
        rmView.askNextMove();
        int choice = checkChoice(3);
        switch (choice) {
            case 1:
                if (action.stealBounch(rm.getPlayerOne())) {
                    rmView.succesfullySteal(p1);
                    break;
                }
                rmView.notStealed(rm);
            case 2:
                rmView.selectCard(rm);
                int selectedCardIndex = checkChoice(rm.getPlayerOne().getPlayerHand().getCardCount());
                action.makeMove(p1, selectedCardIndex - 1);
                break;
            case 3:
                user.close();
                rmView.sayGoodbye();
                System.exit(0);
        }
    }

    private void doBotActions(Player bot){
        rmView.getTurner(bot);
        if(!action.stealBounch(bot)){
            Random rand = new Random();
            int upperbound = bot.getPlayerHand().getCards().size();
            action.makeMove(bot,rand.nextInt(upperbound));
        } else rmView.succesfullySteal(bot);
    }

    private int checkChoice(int max){
        int choice = 0;
        try{
            choice = user.nextInt();
        } catch (InputMismatchException ie) {
            user.nextLine();
            rmView.inputExceptionMessage();
        }
        while (choice < 1 || choice > max ){
            rmView.retryInput();
            try{
                choice = user.nextInt();
            } catch (InputMismatchException ie) {
                user.nextLine();
                rmView.inputExceptionMessage();
            }
        }
        return choice;
    }
}
