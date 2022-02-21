/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < employees.size(); i++) map.put(employees.get(i).id, employees.get(i));
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            res += cur.importance;
            for (int sub : cur.subordinates) queue.offer(map.get(sub));
        }
        return res;
    }
}

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.isEmpty()) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) map.put(e.id, e);
        return dfs(map, id);
    }
    private int dfs(Map<Integer, Employee> map, int id) {
        Employee cur = map.get(id);
        int res = cur.importance;
        for (int next : cur.subordinates) res += dfs(map, next);
        return res;
    }
}
