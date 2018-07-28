class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        dict.add(beginWord);  //一定要把起始点也放进去
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> dis = new HashMap<>();
        Map<String, ArrayList<String>> neighbors = new HashMap<>();
        List<String> solution = new ArrayList<>();
        bfs(beginWord, endWord, dict, dis, neighbors);
        dfs(beginWord, endWord, dict, neighbors, dis, solution, res);
        return res;
    }
    //bfs确立neighbor和每个节点和start的距离
    public void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> dis, Map<String, ArrayList<String>> neighbors) {
        for(String str : dict) neighbors.put(str, new ArrayList<String>());
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dis.put(beginWord, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDis = dis.get(cur);
                ArrayList<String> list = getNeighbors(cur, dict);
                for (String s : list) { 
                    neighbors.get(cur).add(s);
                    if (!dis.containsKey(s)) { //如果之前有那么现在的距离肯定比原来大，所以保持最小的那个
                        dis.put(s, curDis + 1);
                        if (endWord.equals(s)) found = true;
                        else queue.offer(s);
                    }
                }
            }
            if(found) break;
        }
    }
    
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
      ArrayList<String> res = new ArrayList<String>();
      char chs[] = node.toCharArray();

      for (char ch ='a'; ch <= 'z'; ch++) {
          for (int i = 0; i < chs.length; i++) {
              if (chs[i] == ch) continue;
              char old_ch = chs[i];
              chs[i] = ch;
              if (dict.contains(String.valueOf(chs))) {
                  res.add(String.valueOf(chs));
              }
              chs[i] = old_ch; //记得替换回原来的
          }

      }
      return res;
    }
    
    private void dfs(String cur, String end, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
           res.add(new ArrayList<String>(solution));
        } else {
           for (String next : nodeNeighbors.get(cur)) { //注意next不一定距离都是1，找最近的            
                if (distance.get(next) == distance.get(cur) + 1) {
                     dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }           
       solution.remove(solution.size() - 1);
    }
}
