class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  

            if (freq.containsKey(ch)) {
                int count = freq.get(ch);
                freq.replace(ch, count + 1);
            } else {
                freq.put(ch, 1);
            }
        }

        List<Character> list = new ArrayList<>(freq.keySet());

        Collections.sort(list, (a, b) -> Integer.compare(freq.get(b), freq.get(a)));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            char ch = list.get(i);
            int count = freq.get(ch);

            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
