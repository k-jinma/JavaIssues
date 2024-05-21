
public abstract class Decorater {
    /**
     * テキストを装飾します。
     * 
     * @param text 装飾するテキスト
     * @return 装飾されたテキスト
     */
    public abstract String decorate(String text);

    /**
     * テキストを指定の文字で装飾した文字列を構築します。
     * 
     * @param text 装飾するテキスト
     * @param decorChar 装飾に使用する文字
     * @return 装飾された文字列
     */
    protected String buildDecoratedString(String text, char decorChar) {
        int len = calculateDisplayLength(text);
        StringBuilder border = new StringBuilder();
        for (int i = 0; i < len + 2; i++) {
            border.append(decorChar);
        }
        return border.toString() + "\n" + decorChar + text + decorChar + "\n" + border.toString();
    }

    /**
     * テキストの表示幅を計算します。
     * 
     * @param text 計算するテキスト
     * @return テキストの表示幅
     */
    private int calculateDisplayLength(String text) {
        int length = 0;
        for (char c : text.toCharArray()) {
            if (isFullWidthCharacter(c)) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length;
    }

    /**
     * 文字が全角文字かどうかを判定します。
     * 
     * @param c 判定する文字
     * @return 全角文字の場合はtrue、それ以外の場合はfalse
     */
    private boolean isFullWidthCharacter(char c) {
        return (c >= '\u1100' && c <= '\uFFDC') || (c >= '\uFFE8' && c <= '\uFFEE');
    }
}
