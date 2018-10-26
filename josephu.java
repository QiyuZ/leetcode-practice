import java.util.ArrayList;
import java.util.List;

public class count {

    public static int josephu1(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        List<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) list.add(i);
        int out = -1, begin = 0;
        while (list.size() > 1) {
            out = (begin + m - 1) % list.size();
            list.remove(out);
            begin = out;
        }
        return list.get(0);
    }
    public static int josephu2(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) p = (p + m) % i;
        return (p + 1) % n;
        //f[1]=0; 　　f[i]=(f[i-1]+m)%i; (i>1)
    }

    public static void main(String[] args) {
        System.out.println(josephu2(6, 3));
    }

}
