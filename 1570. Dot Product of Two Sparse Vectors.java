class SparseVector {  //write heavy 
    private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int[] other = vec.nums;
        int res = 0;
        for (int i = 0; i < nums.length; i++) res += nums[i] * other[i];
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
class SparseVector { //read heavy
    Map<Integer, Integer> map;      // For all non-zero values in the vector, we map the index to the non-zero value.
    
    // O(nums.length) time.
    // O(numNonZeroValues) space.
    SparseVector(int[] nums) {
        map = new HashMap<>();
        // Store the position and value of non-zero values.
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) map.put(i, nums[i]);        
        }
    }


    // O(min(vec1numNonZeroValues, vec2numNonZeroValues)) time because we iterate through non-zero values of the vector that has fewer non-zero values and for each value we check in O(1) time whether the other vector has a non-zero value at that index.
    // O(1) space.
    public int dotProduct(SparseVector vec) {        
        if (vec.map.size() < this.map.size()) return vec.dotProduct(this);      // We want to iterate through the smaller map.
        int result = 0;
        for (int currIdx : this.map.keySet()) {
            // If both vectors have a non-zero value at currIdx then multiply the values and add them to the result.
            if (vec.map.containsKey(currIdx)) result += this.map.get(currIdx) * vec.map.get(currIdx);
        }
        return result;
    }
}


class SparseVector { //without map

    List<int[]> pairs;

    SparseVector(int[] nums) {
        pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (pairs.size() > vec.pairs.size()) return vec.dotProduct(this);
        int result = 0, p = 0, q = 0;
        while (p < pairs.size() && q < vec.pairs.size()) {
            if (pairs.get(p)[0] == vec.pairs.get(q)[0]) {
                result += pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            else if (pairs.get(p)[0] > vec.pairs.get(q)[0]) q++;
            else p++;
        }
        return result;
    }
}

class SparseVector { //use binary search for non-sparse
    
    private final List<int[]> pairs;
    
    // Time O(N), space O(L)
    SparseVector(int[] nums) {
        pairs = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pairs.add(new int[]{i, nums[i]});
            }
        }    
    }
    
	// Return the dotProduct of two sparse vectors

    public int dotProduct(SparseVector vec) {
        if (pairs.size() <= vec.pairs.size()) {
            return dotProduct(this, vec);
        } else {
            return dotProduct(vec, this);
        }
    }
    
    // Time O(min(L1, L2) * log(max(L1, L2))), space O(1)
    private int dotProduct(SparseVector small, SparseVector large) {
        int res = 0;
        for (int[] pair: small.pairs) {
            // binary search in large.pairs for pair with index pair[0]
            int i = binarySearch(large.pairs, pair[0]);
            if (i >= 0) {
                res += pair[1] * large.pairs.get(i)[1];
            }
        }
        return res;
    }
    
    // binary search in pairs for pair with pair[0] == index
    // return its index, if not found, return -1
    private int binarySearch(List<int[]> pairs, int index) {
        int l = 0;
        int r = pairs.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midIdx = pairs.get(mid)[0];
            if (midIdx == index) {
                return mid;
            } else if (midIdx > index) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
