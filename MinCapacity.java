import java.util.Scanner;
import java.util.*;
public class MinCapacity {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        int C = sc.nextInt(); 

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int minInitialOil = findMinInitialOil(N, C, A);
        System.out.println(minInitialOil);
    }

    public static int findMinInitialOil(int N, int C, int[] A) {
        int min=0;
        int oil=0;
        for(int i=0;i<N;i++){
            oil +=A[i];

            oil=Math.min(oil, C);

            min=Math.min(min, oil);
        }
        return -min;
    }
}
