import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
	int c=0;
    if(a>b){
	while(a!=0 && b!=0){
	c=a%b;
	a=b;
	b=c;
	}
}
else{
    while(a!=0 && b!=0){
	c=b%a;
	b=a;
	a=c;
}
}
    return a+b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
