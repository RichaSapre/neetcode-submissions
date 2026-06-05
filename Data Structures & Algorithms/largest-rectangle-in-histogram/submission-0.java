class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsi = new int[heights.length];
        int[] psi = new int[heights.length];
        
        for(int i = 0; i<heights.length; i++){
            nsi[i] = heights.length;
            psi[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

//prev smallest index
        for(int i=heights.length-1 ; i >=0; i-- ){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                }

                int index = stack.peek();
                if (heights[i] < heights[index]){
                    psi[index]= i;
                    stack.pop(); 
                } else{
                    stack.push(i);
                    break;
                }
            }
        }
        stack.clear();


//next smallest index
        for(int i=0; i < heights.length; i++ ){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                }

                int index = stack.peek();
                if (heights[i] < heights[index]){
                    nsi[index]= i;
                    stack.pop(); 
                } else{
                    stack.push(i);
                    break;
                }
            }
        }

        int max = 0;
        for(int i=0; i <heights.length; i++){
            max = Math.max(max, heights[i] * (nsi[i] - psi[i] - 1));
        }
        return max;
    }
}
