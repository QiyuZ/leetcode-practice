class Logger {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer preTime = map.get(message);
        if (preTime == null || timestamp - preTime >= 10) {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}

class Logger {
    private Map<String, Integer> cache;
    public Logger() {
        cache = new LinkedHashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // iterator over beginning of hashmap to cleanup old entries,
        // until we find a time < 10 seconds
        Iterator<Map.Entry<String, Integer>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()) {
            if (timestamp - iterator.next().getValue() >= 10) iterator.remove();
            else break;
        }
        if (cache.containsKey(message)) return false;
        cache.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
