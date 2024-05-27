import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private static final int BOARD_SIZE = 10;  // Tamaño del tablero 10x10
    private static final int[] SHIP_SIZES = {1, 2, 2, 3};  // Tamaños de los barcos: 1x1, 2x2, 2x2, 3x3

    private JButton[][] playerBoardButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private int[][] playerBoard = new int[BOARD_SIZE][BOARD_SIZE];
    private int currentShipIndex = 0;  // Índice del barco actual a colocar
    private boolean isVertical = true;  // Orientación del barco (vertical por defecto)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }

    public App() {
        JFrame frame = new JFrame("Battleship Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 2));

        JPanel playerPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        JPanel enemyPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                playerBoardButtons[i][j] = new JButton();
                playerBoardButtons[i][j].setBackground(Color.BLUE);
                int finalI = i;
                int finalJ = j;
                playerBoardButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        placeShip(finalI, finalJ);
                    }
                });
                playerPanel.add(playerBoardButtons[i][j]);
            }
        }

        // Ejemplo de cómo podrías usar enemyPanel si lo necesitas
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                JButton button = new JButton();
                button.setBackground(Color.BLUE);
                enemyPanel.add(button);
            }
        }

        frame.add(playerPanel);
        frame.add(enemyPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private void placeShip(int row, int col) {
        if (currentShipIndex >= SHIP_SIZES.length) {
            JOptionPane.showMessageDialog(null, "Todos los barcos están colocados");
            return;
        }

        int length = SHIP_SIZES[currentShipIndex];
        if (canPlaceShip(row, col, length, isVertical)) {
            for (int i = 0; i < length; i++) {
                if (isVertical) {
                    playerBoard[row + i][col] = 1;
                    playerBoardButtons[row + i][col].setBackground(Color.GRAY);
                } else {
                    playerBoard[row][col + i] = 1;
                    playerBoardButtons[row][col + i].setBackground(Color.GRAY);
                }
            }
            currentShipIndex++;
        } else {
            JOptionPane.showMessageDialog(null, "No se puede colocar el barco aquí");
        }
    }

    private boolean canPlaceShip(int row, int col, int length, boolean vertical) {
        if (vertical) {
            if (row + length > BOARD_SIZE) return false;
            for (int i = row; i < row + length; i++) {
                if (playerBoard[i][col] != 0) return false;
            }
        } else {
            if (col + length > BOARD_SIZE) return false;
            for (int j = col; j < col + length; j++) {
                if (playerBoard[row][j] != 0) return false;
            }
        }
        return true;
    }
}
