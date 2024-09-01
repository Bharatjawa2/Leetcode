class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                seen.add(0,nums[i]);   // add(0, nums[i]): This method adds the element nums[i] at index 0 of the list, which means it inserts the element at the beginning of the list.
            }
            else{
                if(i!=0 && nums[i-1]!=-1){
                    k=1;
                }
                else{
                    k++;
                }
                
                if(k<=seen.size()){
                    ans.add(seen.get(k-1));
                }
                else{
                    ans.add(-1);
                }
            }
        }
        return ans;
    }
}
