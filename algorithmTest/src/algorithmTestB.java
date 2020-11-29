import java.util.Scanner;

public class algorithmTestB{
    
    public static void main(String[] args) throws Exception{

        System.out.println("売り上げを入力");

        //売上を入力する数を入力
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int N[];
        N = new int[num1];
       
        //作成した配列へ売上を入力する
        for (int i = 0; i < num1; i++){
            N[i] = scan.nextInt();
        }
        scan.close();

        //前日との売上の比較
        for (int i = 0; i <num1 - 1; i++){
            
            if (N[i] == N[i+1]){
                System.out.println("stay");
            }else if (N[i] < N[i+1]){
                System.out.println("up " + (N[i+1]-N[i]));
            }else if (N[i] > N[i+1]){
                System.out.println("down " + (N[i]-N[i+1]));
            }

        }  
      
    }
}
