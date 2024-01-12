package SudukoSolver;

import java.util.Scanner;

public class SudukoSolver {
	public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
	        int subgridRow = 3 * (row / 3);
        int subgridCol = 3 * (col / 3);

        for (int i = subgridRow; i < subgridRow + 3; i++) {
            for (int j = subgridCol; j < subgridCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
	        return true;
    }
	    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Sudoku Solver!");
        System.out.println("Please enter the Sudoku puzzle, row by row, using 0 for empty cells.");

        int[][] sudokuBoard = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard[i][j] = scanner.nextInt();
            }
        }

        if (solveSudoku(sudokuBoard)) {
            System.out.println("\nSudoku Solved:");
            printSudoku(sudokuBoard);
        } else {
            System.out.println("\nNo solution exists for the given Sudoku puzzle.");
        }
    }
}




