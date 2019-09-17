class Solution {
	public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1; 
		for(int i=1,val=1; i<=K; i++){ //到K即可，必有重复
			if(val % K == 0) return i;
			val = (val * 10 + 1) % K; //(a+b)%k =(a%k+b%k)%k，所以相当于算里面的即可
		}    
		return -1;
	}
}
