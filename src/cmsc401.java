import java.util.Scanner;
public class cmsc401 {
static int[] productArr;
static int[] highestIntUsedArr;
static int n;
private static final Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    n = Integer.parseInt(readString());
    productArr = new int[n+1];// array to store the products of the last calculations (likely simplifiable to just the last one)
    highestIntUsedArr = new int[n+1];// array to store the highest of the previous calulations
    System.out.println(bottomUpProduct());
}
public static int bottomUpProduct(){
    productArr[0] = 1;
    highestIntUsedArr[0] = 1;
    productArr[1] = 1;
    highestIntUsedArr[1] = 1;
    // fill in 0, 1 and 2 so we can use bottom up approach
    if (n > 1) {
        productArr[2] = 1;
        highestIntUsedArr[2] = 1;
    }
    for(int i=1;i<=n;i++){// go from one to n
        int q = Integer.MIN_VALUE;
        for(int j=1;j<=i;j++) {// go from 1 to i to check remainder calculations
            if (i == 1) {// simple check for case 1
                q = Math.max(q, j * productArr[i - j]);
                highestIntUsedArr[i]=j;
            } else {
                if(j+highestIntUsedArr[i-1]==i) { // if j + the previous highest int is = i
                    if (j * highestIntUsedArr[i - 1] > q) {// and j* the previous highest int is higher than what we have
                        q = Math.max(q, j * highestIntUsedArr[i - 1]); // update q
                        highestIntUsedArr[i] = j; // update the highest int used array to j
                    }
                }
            }
            productArr[i] = q;
        }
    }
    return productArr[n];
}

    private static String readString() {
        return scanner.nextLine();
    }
}