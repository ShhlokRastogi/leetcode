class Solution {
    public String removeOuterParentheses(String s) {
        int flag=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' && flag==0){
                flag++;
                continue;
            }else if(c==')' && flag==1){
                flag--;
                continue;
            }else if(c==')'){
                sb.append(s.charAt(i));
                flag--;
            }else if(c=='('){
                sb.append(s.charAt(i));
                flag++;
            }
        }
        String str = sb.toString();
        return str;
    }
}
