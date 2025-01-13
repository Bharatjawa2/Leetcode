class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ans=0;
        for(int i:map.values()){
            if(i==0) continue;
            if(i%2==0) ans+=2;
            else ans+=1;
        }
        return ans;  
    }
}