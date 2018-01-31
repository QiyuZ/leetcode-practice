class Solution {
    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        String t = "" + digits[i] + "" + digits[j] + ":" + digits[k] + "" + digits[l];
                        if (isValid(t) && !list.contains(t)) list.add(t);
                    }
                }
            }
        }
        Collections.sort(list);
        int index = list.indexOf(time);
        return index == list.size() - 1 ? list.get(0) : list.get(index + 1);
    }
    public boolean isValid(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        int min = Integer.parseInt(s.substring(3, 5));
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}

class Solution {
    public String nextClosestTime(String time) {
        char[] ta = time.toCharArray(); //原数组变更
        int[] nums = new int[4]; //储存这4个数
        nums[0] = ta[0] - '0';
        nums[1] = ta[1] - '0';
        nums[2] = ta[3] - '0';
        nums[3] = ta[4] - '0';
        Arrays.sort(nums); //一定要排序不然不知道大小顺序
        //先后顺序有讲究，从后向前，注意第一个不可能变，因为只有1和2，如果是1只要个位变就行，如果是2也不可能上升了
        if (next(4, 9, nums, ta) || next(3, 5, nums, ta) || next(1, ta[0] == '2' ? 3 : 9, nums, ta)) return new String(ta);
        next(0, 2, nums, ta);
        return new String(ta);
    }
    
    public boolean next(int idx, int last, int[] nums, char[] ta) {
        int curr = ta[idx] - '0';
        for (int i = 0; i < 4; i++) {
            if (nums[i] > last) break;
            else if (nums[i] > curr) {
                ta[idx] = (char)(nums[i] + '0');
                return true;
            }
        }
        ta[idx] = (char)(nums[0] + '0'); //取最小
        return false;
    }
}
