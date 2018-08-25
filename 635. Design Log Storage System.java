class LogSystem {
    Map<Integer, String> map;
    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int index = 0;
        if (gra.equals("Year")) index = 4;
        else if (gra.equals("Month")) index = 7; //找到对应时间单位的index最好用equals
        else if (gra.equals("Day")) index = 10;
        else if (gra.equals("Hour")) index = 13;
        else if (gra.equals("Minute")) index = 16;
        else if (gra.equals("Second")) index = 19;
        String rangeS = s.substring(0, index), rangeE = e.substring(0, index);
        List<Integer> res = new ArrayList<>();
        for (Integer i : map.keySet()) {
            String cur = map.get(i).substring(0, index);
            if (cur.compareTo(rangeS) >= 0 && cur.compareTo(rangeE) <= 0) res.add(i);
        }
        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
