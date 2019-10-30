class Solution {
    public int dayOfYear(String date) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] record = date.split("-");
        int year = Integer.parseInt(record[0]), month = Integer.parseInt(record[1]), day = Integer.parseInt(record[2]);
        if (year % 100 == 0) {
            if (year % 400 == 0) days[1] = 29;
        }
        if (year % 100 != 0 && year % 4 == 0) days[1] = 29;
        int res = 0;
        for (int i = 0; i <= month - 2; i++) res += days[i];
        return res + day;
    }
}
