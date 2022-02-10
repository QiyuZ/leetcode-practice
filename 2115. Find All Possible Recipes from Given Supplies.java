class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) { //topology sort
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> provides = new HashSet<>();
        for(String supply : supplies) provides.add(supply); //use set for better check
        Map<String, Integer> indegree = new HashMap<>(); //recipe - unava ingre, so when value becomes 0, it means it's available
        Map<String, Set<String>> ingreToRecipes = new HashMap<>(); //use ingre as key, as recipe could be the ingre for other recipes
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            int unava = 0;
            for (String ingre : ingredients.get(i)) {
                if (!provides.contains(ingre)) {
                    if (!ingreToRecipes.containsKey(ingre)) ingreToRecipes.put(ingre, new HashSet<>());
                    ingreToRecipes.get(ingre).add(recipe);
                    unava++;
                }
            }
            if (unava == 0) queue.offer(recipe);//all available means 0 indegree and it should be added into init queue
            else indegree.put(recipe, unava); //record others' indegree
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                res.add(cur);
                if (!ingreToRecipes.containsKey(cur)) continue; //note this corner check
                for (String next : ingreToRecipes.remove(cur)) { //this time the recipe will be used as ingre. Note we can just remove it as it won't be used anymore
                    indegree.put(next, indegree.getOrDefault(next, 0) - 1);//since it's available, -1
                    if (indegree.get(next) == 0) queue.offer(next); //if it's available, add to queue
                }
            }
        }
        return res;
    }
}
