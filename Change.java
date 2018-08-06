import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
		//int a =  m%10;
		
		int b = m/10;
		
		int c = (m-(b*10))/5;
		int d = (m-(b*10 + 5*c))/1;
        return b+c+d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

