public class StringIterator {
    private int i;
    private long rep;
    private char ch;
    private String s;
    
    public StringIterator(String str) {
        s = str;
        i = 0;
        rep = 0;
        ch = ' ';
    }
    
    public char next() {
        if (rep > 0) {
            rep--;
            return ch;
        }
        else if (i < s.length()) {
            ch = s.charAt(i);
            int j = i + 1;
            while (j < s.length() && s.charAt(j) - 'A' < 0) j++;
            rep = Integer.parseInt(s.substring(i + 1, j));
            i = j;
            rep--;
            return ch;
        }
        else {
            return ' ';
        }        
    }
    
    public boolean hasNext() {
        return rep > 0 || i < s.length();
    }
}
