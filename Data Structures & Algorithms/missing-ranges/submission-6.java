class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums,int lower,int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();

        List<Integer> missingRange = new ArrayList<>();

        if(nums.length == 0){
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }

        if(lower < nums[0]){
            missingRange.add(lower);
            missingRange.add(nums[0] - 1);
            missingRanges.add(missingRange);
            missingRange = new ArrayList<>();
        }

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] - nums[i] <= 1){
                continue;
            }
            else{
                missingRange.add(nums[i] + 1);
                missingRange.add(nums[i + 1] - 1);
                missingRanges.add(missingRange);
                missingRange = new ArrayList<>();
            }
        }

        if(upper > nums[nums.length - 1]){
            missingRange.add(nums[nums.length - 1] + 1);
            missingRange.add(upper);
            missingRanges.add(missingRange);
            missingRange = new ArrayList<>();
        }

        return missingRanges;
    }
}