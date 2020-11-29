import java.util.Scanner;
import java.util.Arrays;

public class algorithmTestC {
    public static void main(String[] args) throws Exception{

        System.out.println("数字を6個入力してください");
        Scanner scan = new Scanner(System.in);
     
        //配列の作成
        int N1[];
        N1 = new int[6];

        //配列の入力
        for (int i = 0; i < 6; i++){
            N1[i] = scan.nextInt();
            }
        scan.close();
        
        //配列のコピーを取っている
        int N2[];
        N2 = N1.clone();

        //配列の中身を昇順に並べ変える
        Arrays.sort(N2);

        System.out.println("3番目に大きい数値は"+N2[3]);
        
        }

    }


