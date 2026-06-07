class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0){
            return new ArrayList<>();
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] preachable = new boolean[row][col];
        boolean[][] areachable = new boolean[row][col];

        for(int i =0; i<row; i++){
            dfs(i, 0, preachable, heights);
            dfs(i, col-1, areachable, heights);
        }   
        for(int i =0; i<col; i++){
            dfs(0, i, preachable, heights);
            dfs(row-1, i, areachable, heights);
        }   

        List<List<Integer>> res = new ArrayList<>();
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                if(preachable[i][j] && areachable[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, boolean[][] reachable, int[][] heights){
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        reachable[row][col] = true;

        for(int[] dir : directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if(newRow<0 || newCol<0 || newRow>=heights.length || newCol>=heights[0].length){
                continue;
            }
            if(reachable[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, reachable, heights);
            }
        }
    }
}
