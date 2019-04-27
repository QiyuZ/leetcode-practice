class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs == null || needs.size() == 0) return 0;
        return getRemain(price, special, needs, 0);
    }
    
    private int getRemain(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) { //加pos提高效率
        int min = directPurchase(price, needs); //直接买的价格
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) {  //不能加量，所以跳过
                    newNeeds = null;
                    break;
                }
                newNeeds.add(needs.get(j) - offer.get(j));
            }
            if (newNeeds != null) {
                min = Math.min(min, offer.get(offer.size() - 1) + getRemain(price, special, newNeeds, i)); 
                //因为还从i开始，所以是可以多次使用这个的，不用考虑前面的，因为已经被多次使用过了
            }
        }
        return min;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < price.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        return res;
    }
}
