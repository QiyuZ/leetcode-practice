class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Set<String> sub = new HashSet<>(), nonSub = new HashSet<>();
        int res = 0;
        for (String w : words) {
            if (sub.contains(w)) {
                res++;
                continue;
            }
            if (nonSub.contains(w)) continue;
            if (isSub(w, S)) {
                sub.add(w);
                res++;
            }
            else nonSub.add(w);
        }
        return res;
    }
    
    private boolean isSub(String word, String S) {
        int index = -1;
        for (char c : word.toCharArray()) {
            index = S.indexOf(c, index + 1); //index一直往后移动
            if (index == -1) return false;
        }
        return true;
    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        if (s == null || s.length() == 0) return 0;
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pos[c - 'a'] == null) pos[c - 'a'] = new ArrayList<>();
            pos[c - 'a'].add(i);
        }
        int res = 0;
        for (String word : words) {
            int cur = -1;
            for (char w : word.toCharArray()) {
                cur = search(pos[w - 'a'], cur);
                if (cur == -1) break;
            }
            if (cur != -1) res++;
        }
        return res;
    }
    
    private int search(List<Integer> bucket, int cur) {
        if (bucket == null || bucket.size() == 0) return -1;
        int l = 0, r = bucket.size() - 1;
        if (bucket.get(l) > cur) return bucket.get(l);
        if (bucket.get(r) <= cur) return -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (bucket.get(mid) <= cur) l = mid + 1;
            else r = mid;
        }
        return bucket.get(l);
    }
}


class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Queue<Node>[] qus = new LinkedList[26];
        for(int i = 0; i < 26; i++) qus[i] = new LinkedList<>();
        for(String word: words) {
            Node n = new Node(word);
            qus[n.getCurChar() - 'a'].offer(n);
        }
        for(char ch : s.toCharArray()) {
            Queue<Node> qu = qus[ch - 'a'];
            int size = qu.size();
            for(int i = 0; i < size;i ++) {
                Node cur = qu.poll();
                cur.index++;
                if(cur.index == cur.len) ans++;
                else qus[cur.getCurChar() - 'a'].offer(cur);
            }
        }
        return ans;
    }
}

class Node{
    String word;
    int index;
    int len;
    Node(String word) {
        this.word = word;
        index = 0;
        len = word.length();
    }
    
    public char getCurChar() {
        return word.charAt(index);
    }
}
