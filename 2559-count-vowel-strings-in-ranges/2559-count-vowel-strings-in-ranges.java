class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            int m=words[i].length();
            if(m>0 && isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(m-1))) arr[i]=1;
            else arr[i]=0;
        }

        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        
        int m=queries.length;
        int[] result=new int[m];
        for(int i=0;i<m;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            if(start==0) result[i]=arr[end];
            else result[i]=arr[end]-arr[start-1];
        }
        return result;
    }

    boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}