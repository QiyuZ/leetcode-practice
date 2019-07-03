class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, count = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                count++;
                i++;
                j--;
            } else {
                count++;
                j--;
            }
        }
        if (i == j) count++;
        return count;
    }
}


public int numRescueBoats(int[] people, int limit, int k) {
        Arrays.sort(people);
        int ans = 0;
        int l = 0;
        int r = people.length - 1;

        while (l <= r) {
            int sum = 0;
            int count = 0;
            while (r > l && count < k && sum + people[r] <= limit) {
                sum += people[r--];
                count++;
            }
            while (l <= r && count < k && sum + people[l] <= limit) {
                sum += people[l++];
                count++;
            }
            ans++;
        }
        return ans;
    }
