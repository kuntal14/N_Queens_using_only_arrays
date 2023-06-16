package N_Queens_using_only_arrays;

import java.util.*;

public class nxn {
    public static int count = 0;
    //this function prints a solution
    public static void printchar(char[][] ans, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    System.out.print('0' + " ");
                } else {
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
        count++;
    }
    //this function checks if there is a solution and if there is one, it calls the printchar function.
    public static void recursion(int col, char[][] ans, int n, int count) {
        // base
        if (col == n) {
            printchar(ans, n);
            System.out.println();
            return;
        }

        char[][] ansp = new char[n][n];

        // code
        for (int i = 0; i < n; i++) {
            // copy array
            for (int ii = 0; ii < n; ii++) {
                for (int j = 0; j < n; j++) {
                    ansp[ii][j] = ans[ii][j];
                }
            }

            boolean check = true;
            int sum = col + i;
            int diff = col - i;

            // hor check
            for (int x = 0; x < n; x++) {
                if (ansp[i][x] == 'q')
                    check = false;
            }

            // ver check
            for (int x = 0; x < n; x++) {
                if (ansp[x][col] == 'q')
                    check = false;
            }

            // diagonal check

            for (int ii = 0; ii < n; ii++) {
                for (int j = 0; j < n; j++) {
                    if (j - ii == diff && ans[ii][j] == 'q')
                        check = false;
                    if (ii + j == sum && ans[ii][j] == 'q')
                        check = false;
                }
            }

            if (check == true) {
                ansp[i][col] = 'q';
                recursion(col + 1, ansp, n, count);
            }
        }
        // return
        return;

    }

    // main - this takes in the number of queens, and calls the recursive function.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("what is the value of n : ");
        int n = sc.nextInt();
        char[][] ans = new char[n][n];

        recursion(0, ans, n, 0);
        System.out.println(count);

        sc.close();
    }

}
