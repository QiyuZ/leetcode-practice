class MyCalendarThree {
    TreeMap<Integer, Integer> books;
    public MyCalendarThree() {
        books = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        books.put(start, books.getOrDefault(start, 0) + 1);
        books.put(end, books.getOrDefault(end, 0) - 1);
        int max = 0, sum = 0;
        for (int val : books.values()) {
            sum += val;
            max = Math.max(sum, max);
        }
        return max;
    }
}
//在每个区间加标记start为1end为-1
