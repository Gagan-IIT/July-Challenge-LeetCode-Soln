/* PROBLEM
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;
class Solution { 
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> setli = new HashSet<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1, k=n-1; j<k;){
                if(nums[i]+nums[j]+nums[k]<0) j++;
                else if(nums[i]+nums[j]+nums[k]>0) k--;
                else{
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    setli.add(temp);
                    temp = new ArrayList<Integer>();
                    j++;k--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(setli);
        return res;
    }
}
