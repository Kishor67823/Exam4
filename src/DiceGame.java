import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of sides for the die being used: ");
        int inputForNumberOfSides = in.nextInt();
        Scanner secondIn = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int inputForNumberOfPlayers = secondIn.nextInt();
        Player[] players = new Player[inputForNumberOfPlayers];
        for (int i = 0; i < inputForNumberOfPlayers; i++) {
            Scanner inForName = new Scanner(System.in);
            System.out.print("Enter the name for player " + (i + 1) + " : ");
            String inputForName = inForName.nextLine();
            Die dieForThisPlayer = new Die(inputForNumberOfSides);
            Player player = new Player(inputForName, dieForThisPlayer);
            players[i] = player;
        }
        System.out.println(" ");
        for (Player i : players) {
            Die playersDie = i.getDie();
            playersDie.roll();
            System.out.println("Player " + i.getName() + " rolled a " + i.die.getValue() + " on a " + inputForNumberOfSides + " sided die");

        }
        List<Integer> tieList = decideWinner(players);
        if (tieList.size() == 1) {
            int winner = tieList.get(0);
            System.out.println(players[winner].getName() + " won the game ");
        }
        if (tieList.size() > 1) {
            System.out.print("These are the people who tied: ");
            for (int i = 0; i < tieList.size(); i++) {
                int index = tieList.get(i);
                System.out.print(players[index].getName() + " ");
            }
        }

    }

    public static List<Integer> decideWinner(Player[] players) {
        ArrayList<Integer> tieList = new ArrayList<Integer>();
        int winner = 0;
        int max = -1;
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].die.getValue() > max) {
                max = players[i].die.getValue();
                winner = count;
            }
            count++;
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].die.getValue() == max) {
                tieList.add(i);
            }
        }
        return tieList;
    }

}
