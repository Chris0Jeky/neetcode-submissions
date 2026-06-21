class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> memory = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(memory.contains(nums[i])){
                return true;
            }
            memory.add(nums[i]);
        }
        return false;
    }
}