package nQueen;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入4~14");
        int num = scanner.nextInt();
        scanner.close();
        int[][] map = new int[num][num];
        int count = 0;
        int[] a = new int[num];
        boolean flag = false;
        for(int i = 0 ; i < num ; i++) {
            flag = false;
            for(int j = 0; j < num; j++) {
                if(t.tryThisLocation(i, j, map, num) == true && map[i][j] != 2) {
                    map[i][j] = 1;
                    a[i] = j;
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                i--;
                if(i == -1) {
                    break;
                }
                map[i][a[i]] = 2;
                for(int k = 0; k < num; k++) {
                    map[i+1][k] = 0;
                }
                a[i] = 0;
                i--;
            }else if(i == num-1) {
                t.printArray(a, num);
                count++;
                map[i][a[i]] = 2;
                i--;
            }
        }
        System.out.println("count="+count);
    }

    public boolean tryThisLocation(int row,int col,int[][] map,int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                if(i == row || j == col || (i + j) == (row + col) || (i - j) == (row - col)) {
                    if(map[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void printArray(int[] a,int num) {
        for (int i : a) {
            System.out.print(i+1+",");

        }
        System.out.println();
    }
}
