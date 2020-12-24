import java.util.*;

public class Teach {
    public int mean(int[] array) {
        int len = array.length - 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += array[i];
        }
        return sum / len;
    }

    public static void main(String[] args) {
        
    }
}

