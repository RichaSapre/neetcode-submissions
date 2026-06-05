class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;

        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];
        for(int r=0; r<n; r++){
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            box[r] = new HashSet<Character>();
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                char val = board[r][c];
//check if value there or not
                if(val== '.'){
                    continue;
                }
//checl row
                if(rows[r].contains(val)){
                    return false;
                }
                rows[r].add(val);
//check col
                if(cols[c].contains(val)){
                    return false;
                }
                cols[c].add(val);
//check box
                int idx = (r/3)*3 + (c/3);
                if(box[idx].contains(val)){
                    return false;
                }
                box[idx].add(val);
            }
        }
        return true;
    }
}
