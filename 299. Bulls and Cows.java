class Solution { //fake one pass
    public String getHint(String secret, String guess) {
        if (secret.equals(guess)) return secret.length() + "A" + 0 + "B";
        int[] record1 = new int[10], record2 = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            record1[secret.charAt(i) - '0']++;
            record2[guess.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) cow += Math.min(record1[i], record2[i]);
        return bull + "A" + (cow - bull) + "B";
    }
}


class Solution {
    public String getHint(String secret, String guess) { //one pass
        if (secret.equals(guess)) return secret.length() + "A" + 0 + "B";
        int[] record = new int[10];
        int bull = 0, cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            int indexS = secret.charAt(i) - '0', indexG = guess.charAt(i) - '0';
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            else { //注意要用else防止bull也算在cow里面
                if (record[indexS] < 0) cow++;
                if (record[indexG] > 0) cow++;//此处不能||也不能else if因为这两种都说明有重复的，只不过先后顺序不同
                record[indexS]++;
                record[indexG]--;
            }

        }
        return bull + "A" + cow + "B";
    }
}
