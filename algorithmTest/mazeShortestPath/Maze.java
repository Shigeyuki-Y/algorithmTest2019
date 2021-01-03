import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class Maze {

    //二次元構造のArrayListの作成
    private ArrayList<ArrayList<MazeCell>> mazeMap = new ArrayList<ArrayList<MazeCell>>();
    private Position startPosition;

    //コンストラクタ（インスタンス化時に実行）
    public Maze(BufferedReader mazeLine){

        
        String lineString = null;
        try {
            int yIndex = 0;

            //読み込むデータがある間、読み込んだ迷路情報を二次元ArrayListへと格納していく
            while ((lineString = mazeLine.readLine()) != null){

                //空白かnullでない場合に読み込ませ続ける
                if (!nullOrEmpty.IsNullOrEmpty(lineString)){
                    ArrayList<MazeCell> cellLine =  new ArrayList<MazeCell>();
                    
                    //読み込んだ1行をchar型に変換し、char[]へと格納
                    char[] lineChars = lineString.toCharArray();

                    //MazeCellのコンストラクタ、ArrayListに迷路の情報を格納
                    for (int xIndex = 0; xIndex < lineChars.length; xIndex++){
                        MazeCell cell = new MazeCell(lineChars[xIndex]);
                        cellLine.add(cell);

                        //Startの位置の記録
                        if (cell.IsStart()){
                            startPosition = new Position(xIndex, yIndex);
                        }
                    }

                    //格納したArraListを二次元ArrayListにするために行ごとに格納
                    mazeMap.add(cellLine);
                }
                yIndex++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }            
    }


    //迷路を解いて出力するメソッド
    public void SolveMaze(){
        //探索queueの準備
        Queue<Position> cellQueue = new ArrayDeque<>();
        //現在位置の情報
        Position current = startPosition;

        //queueに現在位置を追加
        cellQueue.add(startPosition);

        //queueが空になるかGoalが見つかるまで探索を行う
        while (cellQueue.size() > 0) {

            //queueから探索する座標を１つ取り出す
            current = cellQueue.poll();

            //Goal発見判定
            if (mazeMap.get(current.Y()).get(current.X()).IsGoal()){
                break;
            }

            /*poll()したセルの周囲の未訪問セルをqueueに追加、
            及び追加した座標の_prevPositionに現在探索中のセル座標を設定*/

            //右側の探索
            if (current.X() + 1 < mazeMap.get(current.Y()).size() &&
                !mazeMap.get(current.Y()).get(current.X() + 1).IsWall() &&
                !mazeMap.get(current.Y()).get(current.X() + 1).IsVisited()){

                    cellQueue.add(new Position(current.X() + 1, current.Y()));
                    mazeMap.get(current.Y()).get(current.X() + 1).SetPrevious(current);                    
            }
            
            //下の探索
            if (current.Y() + 1 < mazeMap.size() &&
                !mazeMap.get(current.Y() + 1).get(current.X()).IsWall() &&
                !mazeMap.get(current.Y() + 1).get(current.X()).IsVisited()){

                    cellQueue.add(new Position(current.X(), current.Y() + 1));
                    mazeMap.get(current.Y() + 1).get(current.X()).SetPrevious(current);
            }

            //左の探索
            if (current.X() - 1 >= 0 &&
                !mazeMap.get(current.Y()).get(current.X() - 1).IsWall() &&
                !mazeMap.get(current.Y()).get(current.X() - 1).IsVisited()){

                    cellQueue.add(new Position(current.X() - 1, current.Y()));
                    mazeMap.get(current.Y()).get(current.X() - 1).SetPrevious(current);
            }

            //上の探索
            if (current.Y() - 1 >= 0 &&
                !mazeMap.get(current.Y() - 1).get(current.X()).IsWall() &&
                !mazeMap.get(current.Y() - 1).get(current.X()).IsVisited()){

                    cellQueue.add(new Position(current.X(), current.Y() - 1));
                    mazeMap.get(current.Y() - 1).get(current.X()).SetPrevious(current);
            }
            
                //現在探索中のセルを訪問済みにする
                mazeMap.get(current.Y()).get(current.X()).SetVisited();
        }
        //探索した後Goalが見つからなかった場合の例外処理
        if (!mazeMap.get(current.Y()).get(current.X()).IsGoal()){
            throw new IllegalArgumentException("pathがありません。");
        }

        //Startまでの経路をGoalから１つ前の座標をたどっていき、同時にマークしていく
        while (!mazeMap.get(current.Y()).get(current.X()).IsStart()){
            mazeMap.get(current.Y()).get(current.X()).SetPath();
            current = mazeMap.get(current.Y()).get(current.X()).GetPrevious();
        }

        //マップをコンソール出力
        OutputMazeMap(mazeMap);
    }

    //迷路を出力するメソッド
    private void OutputMazeMap(ArrayList<ArrayList<MazeCell>> map){

        //迷路の行ごとに出力し、改行して次の行を出力していく
        for (int y = 0; y < map.size(); y++){

                for (int x = 0; x < map.get(y).size(); x++){

                    MazeCell cell = map.get(y).get(x);
                    System.out.print(cell.GetCellCharacter());
                }
                System.out.print("\n");
            }
        }
            
    }

