import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class mazeShortestPath {

    public static void main(String args[]) throws Exception {

        try{

            //テキストデータの迷路を読み込み、バッファーへと格納する
            FileReader maze_Text = new FileReader("C:\\maze_file.txt");
            BufferedReader maze_Data = new BufferedReader(maze_Text);

            
            //迷路クラスインスタンス生成、初期化時に読み込んだデータをバッファーから読み込み
            Maze maze = new Maze(maze_Data);

            //結果を出力
            maze.SolveMaze();
        
        //読み込みデータがなかった際のstacktraceの出力
        } catch(IOException e){
              e.printStackTrace();
        }
    }
}
