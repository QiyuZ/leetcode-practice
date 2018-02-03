/*给一个int，返回它的二进制的最高位1的Index。
比如，对于int 4,二进制是100，最高位1的index就是2；
对于int 1，二进制是1，最高位的index是0；
对于0，返回-1；对于负数，因为最高位都是符号位，所以返回31。*/

class Solution {
	public int indexOfOne (int num) {
		if (num < 0) return 31;
		for (int i = 31; i >= 0; i--) {
			if (num & (1 << i)) return i;
		}
		return -1;
	}
}
