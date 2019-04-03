/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a = 7, b = 7;
        while (a == 7) a = rand7(); //范围1到6
        while (b > 5) b = rand7();//范围1到5
        return b + (a < 4 ? 5 : 0); //每个数字的概率都是 （1/5） * （1/2）
    }
}


class Solution extends SolBase {
    public int rand10() {
        int num = 0;
        while (true){
            num = 7*(rand7() - 1) + rand7() - 1; //num范围 0 到48
            if (num < 40){
                return (num%10) + 1; //1到9概率均等
            }
        }
    }
}

/*
For rand10(), every number should has the probability of 1/10. And 1/10 could be seen as (1/2) * (1/5) . That means get a number which could be 5 or 0 with pro (1/2). And a number b range from 1 to 5 with pro (1/5).
And that's why we use while (a === 7) and while (b > 5 )
*/
