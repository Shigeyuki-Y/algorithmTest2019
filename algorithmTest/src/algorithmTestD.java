import java.util.Scanner;
import java.util.Arrays;

public class algorithmTestD {
    
    public static void main(String[] args) throws Exception{

        System.out.println("整数列の長さを入力");

        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int N1[];
        N1 = new int[num1];

        for (int i = 0; i < num1; i++){
            N1[i] = scan.nextInt();
        }
        scan.close();

        int N2[];
        N2 = N1.clone();

        Arrays.sort(N2);

        int a = 0;
        int b = 0;

        for (int j = 0; j < num1 - 1; j++){
            if (N2[j] == N2[j+1]){
                a = N2[j];
            }else if ((N2[j+1] - N2[j]) > 1){
                b = (N2[j+1] + N2[j])/2;
            }
        }

        if (b == 0){
            System.out.println("Correct");
        }else{
            
            System.out.println(a + "  " + b);
        }

    }

}
