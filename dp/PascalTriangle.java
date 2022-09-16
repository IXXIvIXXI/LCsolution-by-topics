class Solution {
    // 1st and last elements are 1
    // 0 and row - 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int row = 1; row < numRows; row++) {
            res.add(new ArrayList<>());
            List<Integer> currList = res.get(row);
            currList.add(1);
            List<Integer> prev = res.get(row - 1);
            for (int i = 1; i < row; i++) {
              currList.add(prev.get(i) + prev.get(i-1));
            }
            currList.add(1);
        }
        return res;
    }
}
