package _10_com.interview.graph;

/**
 http://www.geeksforgeeks.org/find-number-of-islands/
 */
public class _32_NumberOfIsland {

    public int numberOfIsland(int[][] graph){
        //TODO visited is 2d array here
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        for(int i=0; i < graph.length ; i ++){
            for(int j =0 ; j < graph[i].length ; j++){
                if(visited[i][j] == false && graph[i][j] == 1) {
                    count++;
                    DFS(graph,visited,i,j);
                }
            }
        }
        return count;
    }
    
    private void DFS(int[][] graph, boolean[][] visited,int i,int j){
        //TODO VERY IMP Remember
        if(i <0 || j < 0 || i == graph.length || j == graph[i].length)
        {
            return;
            
        }
        if (visited[i][j])
            return;
        //TODO remember the return condition
        visited[i][j] = true;
        //TODO VERY IMP: Remember the return here
        if(graph[i][j] == 0){
            return;
        }
        // TODO It needs to check all 8 cells around it, but it has only 4 cells
        DFS(graph,visited,i,j+1);
        DFS(graph,visited,i+1,j);
        DFS(graph,visited,i+1,j+1);
        DFS(graph,visited,i-1, j+1);
    }
    
    public static void main(String args[]){
        
        int matrix[][] = {{1,1,0,1,0},
                          {1,0,0,1,1},
                          {0,0,0,0,0},
                          {1,0,1,0,1},
                          {1,0,0,0,0}
                        };
        _32_NumberOfIsland island = new _32_NumberOfIsland();
        int count = island.numberOfIsland(matrix);
        System.out.println(count);
    }
}
                     