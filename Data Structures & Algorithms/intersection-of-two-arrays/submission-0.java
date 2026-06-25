class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> solutionAsList = new ArrayList<>();
        Set<Integer> nums1Hash = new HashSet<>();
        Set<Integer> nums2Hash = new HashSet<>();

        for (int i = 0; i < nums2.length; i++){
            nums2Hash.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++){
            nums1Hash.add(nums1[i]);
        }
        for (int element : nums1Hash){
            if(nums2Hash.contains(element)){
                solutionAsList.add(element);
            }
        }

        int[] solution = new int[solutionAsList.size()];

        for(int i = 0; i < solution.length; i++){
            solution[i] = solutionAsList.get(i);
        }

        return solution;


        
    }
}