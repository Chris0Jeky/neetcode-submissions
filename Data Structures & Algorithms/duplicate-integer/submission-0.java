class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> memory = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(memory.containsKey(nums[i])){
                return true;
            }
            memory.put(nums[i], i);
        }
        return false;
    }
}