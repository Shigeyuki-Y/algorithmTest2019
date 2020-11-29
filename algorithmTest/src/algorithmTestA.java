import java.util.Scanner;

public class algorithmTestA{
    public static void main(String[] args) throws Exception{
        System.out.println("3桁の数字を入力してください。");
        
        //キーボードからの入力の受け取りのインスタンス化
        Scanner scan = new Scanner(System.in); 
        
        //キーボードからの入力の受け取り
        String str = scan.next();
        scan.close();

        int num1 = 0; 
        int num2 = 0;

        //入力が数値のみだった場合と英文字が紛れ込んだ場合の処理分け
        try {

            //数値のみだった場合の処理
            num1 = Integer.parseInt(str);
            num2 = num1 * 2;
    
            System.out.println(num2);
            
        } catch (Exception e) {

            //英文字が紛れ込んだ場合の処理分け
            System.out.println("error");

        }
    }
}