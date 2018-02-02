class MyCalendar {
    TreeMap<Integer, Integer> time;
    public MyCalendar() {
        time = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer floorStart = time.floorKey(start);
        if (floorStart != null && time.get(floorStart) > start) return false;
        Integer ceilingStart = time.ceilingKey(start);
        if (ceilingStart != null && ceilingStart < end) return false;
        time.put(start, end);
        return true;
    }
}
