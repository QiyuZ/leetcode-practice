class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations.isEmpty() || values == null || values.length == 0 || queries.isEmpty()) return new double[0];
        Map<String, Map<String, Double>> map = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) res[i] = getResult(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        return res;
    }
    
    private double getResult(Map<String, Map<String, Double>> map, String start, String end, Set<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        visited.add(start); //visited来避免重复走路径，这里不用remove，因为比如走到b没有，那么无论什么路径走到b都没有结果，remove只用于探索全部可行路径，此处只要求知道答案
        for (String key : map.get(start).keySet()) {
            if (!visited.contains(key)) {
                double calculation = getResult(map, key, end, visited);
                if (calculation != -1.0) return map.get(start).get(key) * calculation;//要用当前value乘以计算出来的结果
            }
        }
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0), second = equations.get(i).get(1);
            double value1 = values[i], value2 = 1.0 / values[i];
            if (!map.containsKey(first)) map.put(first, new HashMap<>()); //注意要放入a,b; b,a
            if (!map.containsKey(second)) map.put(second, new HashMap<>());
            map.get(first).put(second, value1);
            map.get(second).put(first, value2);
        }
        return map;
    }
}
