import java.util.*;
class CircularTable {
   public static int minJumps(int N, int X, int Y, int[] A) {
        boolean[] visited = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{X, 0});
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int steps = current[1];

            if (pos == Y) return steps;

            int jump = A[pos - 1];


            int right = (pos + jump - 1) % N + 1;
            int left = (pos - jump - 1 + N) % N + 1;

            if (!visited[right]) {
                visited[right] = true;
                queue.add(new int[]{right, steps + 1});
            }

            if (!visited[left]) {
                visited[left] = true;
                queue.add(new int[]{left, steps + 1});
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine().trim());
        int X = Integer.parseInt(sc.nextLine().trim());
        int Y = Integer.parseInt(sc.nextLine().trim());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(sc.nextLine().trim());
        }

        System.out.println(minJumps(N, X, Y, A));
    }
}