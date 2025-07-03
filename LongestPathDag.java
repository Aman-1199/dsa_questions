
import java.util.*;

public class LongestPathDag {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int N =sc.nextInt();
        int M=sc.nextInt();

        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        int [] indegree = new int[N+1];
        
        for(int i=0;i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            indegree[v]++;
        }

        //Kahn's algorithm to find topological order
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int [] dp = new int[N+1];

        while(!queue.isEmpty()){
            int u= queue.poll();
            for(int v : graph.get(u)){
                dp[v] = Math.max(dp[v], dp[u] + 1);
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        int max =0;
        for(int i=1;i<=N;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max+1); 
    }
}
