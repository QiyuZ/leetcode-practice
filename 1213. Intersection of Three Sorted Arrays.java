class Solution { //O(n)
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        if (arr1 == null || arr2 == null || arr3  == null) return res;
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                res.add(arr1[i++]);
                j++;
                k++;
            } else {
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (arr1[i] == min) i++;
                if (arr2[j] == min) j++;
                if (arr3[k] == min) k++;
            }
        }
        return res;
    }
}

//trad-off, if there's 1 array has small size but other 2 have large size, then binary search the smallest one will be better
