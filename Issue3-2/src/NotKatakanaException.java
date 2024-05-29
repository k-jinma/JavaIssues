// カタカナ以外が入力された場合の例外クラス
public class NotKatakanaException extends Exception {
    public NotKatakanaException(String message) {
        super(message);
    }
}
