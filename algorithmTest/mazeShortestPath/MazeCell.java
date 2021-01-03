public class MazeCell{
    
    //迷路に使用されている文字の定義
    private final char WallChar = '*';
    private final char StartChar = 'S';
    private final char GoalChar = 'G';
    private final char RouteChar = ' ';
    private final char PathChar = '$';
    
    //現在のセルの状態についての情報
    private boolean _isWall = false;
    private boolean _isStart = false;
    private boolean _isGoal = false;
    private boolean _isVisited = false;
    private boolean _isPath = false;
    private Position _prevPosition = null;

    //迷路の壁、Start、Goalの情報の更新
    public MazeCell(char cellCharacter){
        if (cellCharacter == WallChar){
            _isWall = true;

        } else if (cellCharacter == StartChar){
            _isStart = true;

        } else if (cellCharacter == GoalChar){
            _isGoal = true;

        } else if (cellCharacter != RouteChar){
            throw new IllegalArgumentException("通路の値が不正です。");
        
        }
    }
        
    public boolean IsWall(){
        return _isWall;
    }

    public boolean IsStart(){
        return _isStart;
    }

    public boolean IsGoal(){
        return _isGoal;
    }

    public boolean IsVisited(){
        return _isVisited;
    }

    public void SetPath(){
        _isPath = true;
    }

    public void SetVisited(){
        _isVisited = true;
    }

    public void SetPrevious(Position prevPosition){
        _prevPosition = prevPosition;
    }

    public Position GetPrevious(){
        return _prevPosition;
    }

    public char GetCellCharacter(){
        
        if (_isWall){
            return WallChar;
            
        } else if (_isStart){
            return StartChar;

        } else if (_isGoal){
            return GoalChar;

        } else if (_isPath){
            return PathChar;

        } else {
            return RouteChar;
        }
    }

}
