/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        nestedList.forEach(x -> queue.offer(x));
        int pre = 0, total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger node = queue.poll();
                if (node.isInteger()) pre += node.getInteger();
                else {
                    if (node.getList() != null) node.getList().forEach(x -> queue.offer(x));
                }
            }
            total += pre; //every time add one more layer we add again, kind like 2*2*2 = 2 + 2 -> 4 + 4
        }
        return total;
    }
}

class Solution {
    private int flatSum = 0, maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) { //they are complements with 339. eg. [1, [2]] = 3 * 1 + 3 * 2 - 1 * 1 - 2 * 2;
        int depthSum = dfs(nestedList, 1);
        return (maxDepth + 1) * flatSum - depthSum;
    }
    private int dfs(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        int depthSum = 0;
        for (NestedInteger node : nestedList) {
            if (node.isInteger()) {
                flatSum += node.getInteger(); //count flatSum and depth in this block as every node finally should be an integer
                depthSum += depth * node.getInteger();
                maxDepth = Math.max(maxDepth, depth);
            } else depthSum += dfs(node.getList(), depth + 1);
        }
        return depthSum;
    }
}
