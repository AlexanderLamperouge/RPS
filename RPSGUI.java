import javax.swing.*;
import java.util.Random;

public class RPSGUI {
    private int playerThrow;
    private final Random random = new Random();

    public RPSGUI() {
        String name = JOptionPane.showInputDialog("What's your name?");
        JOptionPane.showMessageDialog(null, "Hello, " + name + "!\nLet's play Rock-Paper-Scissors!");

        int times = Integer.parseInt(JOptionPane.showInputDialog("How many times do you want to play the game?"));

        for (int i = 0; i < times; i++) {
            playGame(name);
        }

        JOptionPane.showMessageDialog(null, "Goodbye!!!");
    }

    private void playGame(String playerName) {
        Object[] options = { "Rock", "Paper", "Scissors" };
        int n = JOptionPane.showOptionDialog(null, "Choose your throw:",
                "Rock-Paper-Scissors",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        playerThrow = n; // 0 for Rock, 1 for Paper, 2 for Scissors
        int computerThrow = random.nextInt(3);
        String result = decideWinner(playerThrow, computerThrow);

        JOptionPane.showMessageDialog(null, playerName + " throws " + options[playerThrow] + ".\nComputer throws "
                + options[computerThrow] + ".\n" + result);
    }

    private String decideWinner(int playerThrow, int computerThrow) {
        if (playerThrow == computerThrow) {
            return "It's a tie!";
        } else if ((playerThrow == 0 && computerThrow == 2) ||
                (playerThrow == 1 && computerThrow == 0) ||
                (playerThrow == 2 && computerThrow == 1)) {
            return "Player wins!!!";
        } else {
            return "Computer wins!!!";
        }
    }

    public static void main(String[] args) {
        // Ensure GUI creation is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(RPSGUI::new);
    }
}
