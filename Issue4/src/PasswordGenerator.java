import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * パスワード生成器クラスです。
 */
public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "_!@$+#%";
    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;
    private static final SecureRandom random = new SecureRandom();

    /**
     * 指定された長さのランダムなパスワードを生成します。
     * 
     * @param length パスワードの長さ
     * @return 生成されたパスワード
     */
    public String generatePassword(int length) {

        StringBuilder password = new StringBuilder(length);

        // 各カテゴリから1文字ずつ追加
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // 残りの文字をランダムに追加
        for (int i = 3; i < length; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        // シャッフルしてランダム性を高める
        List<Character> passwordChars = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            passwordChars.add(c);
        }
        StringBuilder shuffledPassword = new StringBuilder(length);
        
        // リストが空になるまで、ランダムに文字を取り出し、新しいパスワードに追加
        while (!passwordChars.isEmpty()) {
            // ランダムにインデックスを決定
            int randIndex = random.nextInt(passwordChars.size());
            // そのインデックスにある文字を取り出し、新しいパスワードに追加
            // 取り出した文字は、もう使わないのでリストから削除
            shuffledPassword.append(passwordChars.remove(randIndex));
        }

        return shuffledPassword.toString();
    }

    /**
     * 指定されたパスワードが有効かどうかを判定します。
     * 有効なパスワードは、大文字、数字、特殊文字を含む必要があります。
     * 
     * @param password 判定するパスワード
     * @return パスワードが有効な場合はtrue、それ以外の場合はfalse
     */
    public boolean isValidPassword(String password) {
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // 文字が大文字
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                // 文字が数字
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) >= 0) {
                // 文字が特殊文字
                hasSpecialCharacter = true;
            }
        }
        // 大文字、数字、特殊文字のどれか1つ以上含まれていればtrueを返す
        return hasUppercase && hasDigit && hasSpecialCharacter;
    }
}
