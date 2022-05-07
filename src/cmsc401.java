import java.util.Scanner;
public class cmsc401 {
static int[] productArr;
static int n;
private static final Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    n = Integer.parseInt(readString());
    productArr = new int[n+1];// array to store the products of the last calculations
    System.out.println(bottomUpProduct());
}
public static int bottomUpProduct(){
    productArr[0] = 1;
    productArr[1] = 1;
    // fill in 0, 1 and 2 3 4 so we can use bottom up approach
    if(n>=4){
        productArr[2] = 1;
        productArr[3] = 2;
        productArr[4] = 4;
    }
    else if(n>=3){
        productArr[2] = 1;
        productArr[3] = 2;
    }
    else if (n ==2  ) {
        productArr[2] = 1;
    }
    if(n<5){
        return productArr[n];
    }
    for(int i=5;i<=n;i++){// go from one to n
        int q = Integer.MIN_VALUE;
        for(int j=1;j<=i;j++) {// go from 1 to i to check remainder calculations
                if(j +(i-j) == i && i-j!=0 ) { // if j + the previous highest int is = i
                          q = Math.max(q,Math.max(j,productArr[j])*Math.max(i-j,productArr[i-j]));
                }
            }
            productArr[i] = q;
        }
    return productArr[n];
}
    private static String readString() {
        return scanner.nextLine();
    }
}