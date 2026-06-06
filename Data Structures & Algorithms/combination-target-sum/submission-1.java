class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, target, new ArrayList(), result);
        return result;
    }

    private void backtrack(int[] num, int start, int target, List<Integer> list, List<List<Integer>> result){

        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList (list));
        }
        for(int i = start; i < num.length; i++){
            list.add(num[i]);
            backtrack(num, i, target - num[i], list, result);
            list.remove(list.size() - 1);
        }

    }
}
