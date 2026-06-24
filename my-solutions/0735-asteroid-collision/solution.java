class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        boolean alive = true;
        for(int i=0;i<asteroids.length;i++){
        while(!st.isEmpty() && (st.peek()>0 && asteroids[i]<0)){
            if(Math.abs(st.peek())>Math.abs(asteroids[i])){
                alive=false;
                break;
            }else if(Math.abs(st.peek())==Math.abs(asteroids[i])){
                st.pop();
                alive=false;
                break;
            }else{
                st.pop();
            }
        }
        if(alive){
            st.push(asteroids[i]);
        }
        alive=true;
        }
        int[] arr = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            arr[i] = st.get(i);
        }
        return arr;
    }
}
