class Solution {
    public int[] findOrder(int m, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        int n=arr.length;
        for(int i=0;i<n;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
        }

        int[] indegree=new int[m];
        for(int i=0;i<m;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        
        if(topo.size()==m){
            int[] ans=new int[topo.size()];
            int c=0;
            for(int i=topo.size()-1;i>=0;i--){
                ans[c++]=topo.get(i);
            }
            return ans;
        }
        int[] a=new int[0];
        return a;
    }
}
