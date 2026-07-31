class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map <Character,Character> mp=new HashMap<>();
        Map <Character,Character> revmp=new HashMap<>();
        for(int i=0;i<s.length();i++){
             char c1=s.charAt(i);
             char c2=t.charAt(i);
             
             if(mp.containsKey(c1) && mp.get(c1)!=c2){
                 return false;
             }
             if(revmp.containsKey(c2) && revmp.get(c2)!=c1){
                 return false;
             }
             mp.put(c1,c2);
             revmp.put(c2,c1);
        }
        return true;
    }
}
