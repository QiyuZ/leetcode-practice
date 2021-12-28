//Modified from 498. Diagonal Traverse, what if just one direction
    private static int[] diagonalTraverse(int[][] arr) {
        if (arr == null || arr.length == 0) return new int[] {};
        int m = arr.length, n = arr[0].length;
        int[] res = new int[m * n];
        int index = 0, start = 0;
        for (int sum = 0; sum <= (m + n - 2); sum++) {
            for (int j = start; j >= 0 && sum - j < n; j--) res[index++] = arr[j][sum - j];
            if (start < m - 1) start++;
        }
        return res;
    }
