class Solution {
    public int characterReplacement(String s, int k) {

        int maxf = 0;
        int window = 0;
        int left = 0;
        int maxwindow = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxf = Math.max(maxf, map.get(ch));
            window = right - left + 1;

            while (window - maxf > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
                window = right - left + 1;
            }

            maxwindow = Math.max(maxwindow, window);
        }

        return maxwindow;
    }
}
