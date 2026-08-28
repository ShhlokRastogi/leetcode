class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);

        if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int i = 0; i < hand.length; i++) {
            fmap.put(hand[i], fmap.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {
            if (fmap.get(hand[i]) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {

                int card = hand[i] + j;

                if (fmap.getOrDefault(card, 0) == 0) {
                    return false;
                }
                fmap.put(card, fmap.get(card) - 1);
            }
        }
        
        return true;
    }
}
