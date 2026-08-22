class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',-1);
        map.put('b',-1);
        map.put('c',-1);
        int count=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int right=0;right < s.length();right++){
            char c=s.charAt(right);
            map.put(c,right);
            if(map.get('a')>=0 && map.get('b')>=0 && map.get('c')>=0){
                min = Math.min(map.get('a'), Math.min(map.get('b'), map.get('c')));
                count+=min+1;
            }
        }
        return count;
    }
}
