/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cele = 0;
        for (int i = 1; i < n; i++) { //cele只有一个,而且所有人都认识他（连接）所以过一遍找到可能的cele
            if (knows(cele, i)) cele = i;
        }
        for (int i = 0; i < n; i++) { //找到的有可能不成立，比如例子2中找到的是2
            if (i != cele && (!knows(i, cele) || knows(cele, i))) return -1; //再判断下找到的这个是不是，有可能没有cele
        }
        return cele;
    }
}
