class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> ans=new HashSet<>();
        for(int i:nums){
            ans.add(i);
        }
        if(ans.size()==nums.length) return false;
        return true;
    }
}

// More Optimize method 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> ans=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(ans.containsKey(nums[i])){
                return true;
            }
            else{
                ans.put(nums[i],i);
            }
        }
        return false;
    }
}
