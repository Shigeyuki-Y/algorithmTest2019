public class nullOrEmpty {
    public static boolean IsNullOrEmpty(String lineString){
        String nullBox = null;
        //lineStringがnullもしくは空文字であればtrueを返す
        return (lineString.equals(nullBox) || "".equals(lineString));
    }
}
