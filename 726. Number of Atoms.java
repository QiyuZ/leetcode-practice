class Solution { //O(nlogn)
    public String countOfAtoms(String formula) {
        Map<String, Integer> res = new TreeMap<>();
        Stack<Integer> stack = new Stack<>();
        int multiplier = 1;
        int i = formula.length() - 1;
        while (i >= 0) {
            if (formula.charAt(i) == '(') { //mutiply ends
                multiplier /= stack.pop();
                i--;
                continue;
            }
            int end = i, val = 1;
            if (Character.isDigit(formula.charAt(i))) {
                while (Character.isDigit(formula.charAt(i))) i--;
                val = Integer.parseInt(formula.substring(i+1, end+1));
            } 
            end = i;
            if (Character.isLetter(formula.charAt(i))) {
                while(Character.isLowerCase(formula.charAt(i))) i--;
                String key = formula.substring(i, end + 1);
                res.put(key, multiplier * val + res.getOrDefault(key, 0)); //dont change multiplier here as the value could follow the number K(SO3)2
            } else if (formula.charAt(i) == ')') { 
                multiplier *= val;
                stack.push(val);
            }
            i--;
        }
        StringBuilder rs = new StringBuilder();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            rs.append(entry.getKey());
            if (entry.getValue() > 1) rs.append(entry.getValue());
        }
        return rs.toString();
    }
}


class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = countHelper(formula);
        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);
        StringBuilder sb = new StringBuilder();
        for (String atom : atoms) {
            sb.append(atom + (map.get(atom) > 1 ? map.get(atom) : ""));
        }

        return sb.toString();
    }
    //总体思路，if里面处理多个括号的情况，用递归，else里面处理最基本的情况，只有字母和数字
    private Map<String, Integer> countHelper(String formula) {
        Map<String, Integer> map = new HashMap<>();
        if (formula.isEmpty()) return map;
        int i = 0;
        while (i < formula.length()) {
            if (formula.charAt(i) == '(') {
                int count = 0, j = i;
                for (; j < formula.length(); j++) {
                    if (formula.charAt(j) == '(') count++;
                    else if (formula.charAt(j) == ')') count--;
                    if (count == 0) break;
                }
                //recursive, deal with what in this parenthesis
                Map<String, Integer> subMap = countHelper(formula.substring(i + 1, j));
                j++;
                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) {
                    n = Integer.parseInt(formula.substring(j, k));
                } //count the number behind the parenthesis
                for (String atom : subMap.keySet()) {
                    map.put(atom, subMap.get(atom) * n + map.getOrDefault(atom, 0));
                } //因为n在外面，所以相当于个倍数
                i = k; //update i
            } else {
                int j = i + 1;
                //跳过字母找数字
                while (j < formula.length() && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') j++;
                int n = 1, k = j;
                while (k < formula.length() && Character.isDigit(formula.charAt(k))) k++;
                if (k > j) { //count num behind the letter
                    n = Integer.parseInt(formula.substring(j, k));
                }
                String atom = formula.substring(i, j);
                map.put(atom, n + map.getOrDefault(atom, 0));
                i = k;
            }
        }
        return map;
    }
}
