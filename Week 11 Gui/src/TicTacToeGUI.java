import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton[][] buttons;
    private JButton resetButton;
    private JLabel statusLabel;

    private char currentPlayer;
    private boolean gameOver;

    public TicTacToeGUI() {
        frame = new JFrame("Tic-Tac-Toe");
        panel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        resetButton = new JButton("Reset Game");
        statusLabel = new JLabel("Player X's turn");

        currentPlayer = 'X';
        gameOver = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onButtonClick(finalI, finalJ);
                    }
                });
                panel.add(buttons[i][j]);
            }
        }

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        panel.add(resetButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private void onButtonClick(int row, int col) {
        if (!gameOver && buttons[row][col].getText().equals("")) {
            buttons[row][col].setText(String.valueOf(currentPlayer));
            if (checkForWin(row, col)) {
                statusLabel.setText("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isBoardFull()) {
                statusLabel.setText("It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                statusLabel.setText("Player " + currentPlayer + "'s turn");
            }
        }
    }

    private boolean checkForWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals() || checkAntiDiagonals();
    }

    private boolean checkRow(int row) {
        return buttons[row][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[row][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[row][2].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean checkColumn(int col) {
        return buttons[0][col].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][col].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][col].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean checkDiagonals() {
        return buttons[0][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][2].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean checkAntiDiagonals() {
        return buttons[0][2].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][0].getText().equals(String.valueOf(currentPlayer));
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        statusLabel.setText("Player X's turn");
        gameOver = false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}
