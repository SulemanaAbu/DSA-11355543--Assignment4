import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;
//11355543--SULEMANA ABUBAKAR SADDIQUE
public class AlgorithmApplication extends JFrame implements ActionListener {
    private JTextArea inputArea;
    private JButton executeButton;
    private JComboBox<String> algorithmComboBox;
    private JTextArea outputArea;

    public AlgorithmApplication() {
        setTitle("Algorithm Application");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputArea = new JTextArea(10, 40);
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        executeButton = new JButton("Execute");

        String[] algorithms = {"Simple Search", "Naive String Matching", "Brute Force Cryptographic Attack", "TSP Optimization Problem",
                "Backtracking (N-Queens)", "Branch and Bound (Knapsack)", "Dynamic Programming (Fibonacci)",
                "Depth-First Search", "Breadth-First Search"};
        algorithmComboBox = new JComboBox<>(algorithms);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Input:"));
        panel.add(new JScrollPane(inputArea));
        panel.add(new JLabel("Algorithm:"));
        panel.add(algorithmComboBox);
        panel.add(executeButton);
        panel.add(new JLabel("Output:"));
        panel.add(new JScrollPane(outputArea));

        executeButton.addActionListener(this);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AlgorithmApplication().setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputArea.getText().trim();
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        long startTime = 0, endTime = 0;
        StringBuilder output = new StringBuilder();

        switch (selectedAlgorithm) {
            case "Simple Search":
                int[] arr = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int key = Integer.parseInt(JOptionPane.showInputDialog("Enter the number to search for:"));
                startTime = System.nanoTime();
                int index = simpleSearch(arr, key);
                endTime = System.nanoTime();
                output.append("Index of ").append(key).append(": ").append(index).append("\n");
                break;
            case "Naive String Matching":
                String[] parts = input.split(",");
                String text = parts[0].trim();
                String pattern = parts[1].trim();
                startTime = System.nanoTime();
                List<Integer> positions = naiveStringMatching(text, pattern);
                endTime = System.nanoTime();
                output.append("Pattern found at positions: ").append(positions).append("\n");
                break;
            case "Brute Force Cryptographic Attack":
                String hash = input.trim();
                startTime = System.nanoTime();
                String original = bruteForceCrypto(hash);
                endTime = System.nanoTime();
                output.append("Original string: ").append(original).append("\n");
                break;
            case "TSP Optimization Problem":
                int[][] graph = {{0, 10, 15, 20},
                        {10, 0, 35, 25},
                        {15, 35, 0, 30},
                        {20, 25, 30, 0}};
                startTime = System.nanoTime();
                int cost = tsp(graph);
                endTime = System.nanoTime();
                output.append("Minimum cost: ").append(cost).append("\n");
                break;
            case "Backtracking (N-Queens)":
                int n = Integer.parseInt(input.trim());
                startTime = System.nanoTime();
                List<int[]> solutions = solveNQueens(n);
                endTime = System.nanoTime();
                output.append("Number of solutions: ").append(solutions.size()).append("\n");
                break;
            case "Branch and Bound (Knapsack)":
                String[] items = input.split(",");
                int[] weights = Arrays.stream(items[0].split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int[] values = Arrays.stream(items[1].split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int capacity = Integer.parseInt(JOptionPane.showInputDialog("Enter the knapsack capacity:"));
                startTime = System.nanoTime();
                int maxValue = knapsack(weights, values, capacity);
                endTime = System.nanoTime();
                output.append("Maximum value: ").append(maxValue).append("\n");
                break;
            case "Dynamic Programming (Fibonacci)":
                int fibIndex = Integer.parseInt(input.trim());
                startTime = System.nanoTime();
                int fibValue = fibonacci(fibIndex);
                endTime = System.nanoTime();
                output.append("Fibonacci number: ").append(fibValue).append("\n");
                break;
            case "Depth-First Search":
                // Placeholder for DFS logic
                output.append("DFS logic not implemented in this example.");
                endTime = startTime = System.nanoTime();
                break;
            case "Breadth-First Search":
                // Placeholder for BFS logic
                output.append("BFS logic not implemented in this example.");
                endTime = startTime = System.nanoTime();
                break;
        }

        output.append("Time taken: ").append((endTime - startTime) / 1_000_000).append(" ms\n");
        outputArea.setText(output.toString());

        // Ask user if they want to continue or quit
        int response = JOptionPane.showConfirmDialog(null, "Do you want to execute another algorithm?", "Continue or Quit", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Reset the input and output areas for a new operation
            inputArea.setText("");
            outputArea.setText("");
        } else {
            System.exit(0); // Exit the application
        }
    }

    private List<int[]> solveNQueens(int n) {
        // Placeholder for N-Queens logic
        return List.of();
    }

    private int simpleSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private List<Integer> naiveStringMatching(String txt, String pat) {
        List<Integer> positions = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                positions.add(i);
            }
        }
        return positions;
    }

    private String bruteForceCrypto(String hash) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (char c1 : chars.toCharArray()) {
            for (char c2 : chars.toCharArray()) {
                for (char c3 : chars.toCharArray()) {
                    String attempt = "" + c1 + c2 + c3;
                    if (hash.equals(hashString(attempt))) {
                        return attempt;
                    }
                }
            }
        }
        return "Not found";
    }

    private String hashString(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private int tsp(int[][] graph) {
        // Placeholder for TSP logic
        return 0;
    }

    private int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    private int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
