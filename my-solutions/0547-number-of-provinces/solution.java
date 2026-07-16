class Solution {
    void dfs(int[][] isConnected,int[] visited,int u){
        visited[u]=1;
        for(int next=0;next<visited.length;next++){
            if(isConnected[u][next]==1 && visited[next]!=1){
                dfs(isConnected,visited,next);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int len=isConnected.length;
        int count=0;
        int[] visited= new int[len];
        for(int i=0;i<len;i++){
            if(visited[i]!=1){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }
}
