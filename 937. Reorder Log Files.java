class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int seperator1 = s1.indexOf(' ');
                int seperator2 = s2.indexOf(' '); 
                char content1 = s1.charAt(seperator1 + 1);
                char content2 = s2.charAt(seperator2 + 1);
                if (content1 <= '9') { //如果一个是数字
                    if (content2 <= '9') return 0; //另一个也是，则不动
                    return 1;//另一个不是则s1大，排在后面
                }
                if (content2 <= '9') return -1; //s1不是数字，s2是，则s1在前面，算小
                int compute = s1.substring(seperator1 + 1).compareTo(s2.substring(seperator2 + 1)); //都是字符则比较string
                return compute != 0 ? compute :  s1.substring(0, seperator1).compareTo(s2.substring(0, seperator2)); //如果相同按照log标号排
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
