class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=roads.length;
        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        long[] ways = new long[n];
        Arrays.fill(ways, 0);
        long[] dist = new long[n];
        Arrays.fill(dist, (long)(1e18));

        long MOD = (long)(1e9) + 7;
        dist[0]=0;
        ways[0]=1;

        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));

        while(pq.size()!=0){
            int distance=pq.peek().first;
            int node=pq.peek().second;
            pq.remove();

            for(Pair i:adj.get(node)){
                int nextnode=i.first;
                int weight=i.second;
                if(weight==1e9) return 1;
                if(distance+weight<dist[nextnode]){
                    dist[nextnode]=distance+weight;
                    pq.add(new Pair(distance+weight,nextnode));
                    ways[nextnode]=ways[node];
                }
                else if(distance+weight==dist[nextnode]){
                    ways[nextnode]=(ways[nextnode]+ways[node]) %MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}
