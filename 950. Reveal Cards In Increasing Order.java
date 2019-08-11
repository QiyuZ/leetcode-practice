class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] res = new int[deck.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) queue.offer(i);
        for (int i = 0; i < deck.length; i++) {
            //因为取的时候按照这个顺序取，所以此处deck按照顺序来，只考虑index
            res[queue.poll()] = deck[i]; //deck排序好，index按照相同规则走一遍，deck还是从小到大，index按照规则
            queue.offer(queue.poll());
        }
        return res;
    }
}
