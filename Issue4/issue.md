
# 課題

パスワード生成ツールの作成

## 作成内容

パスワードを作成する`PasswordGenerator`クラスを作成してください。

PasswordGeneratorクラスは下記を持つこととします。
* パスワードに使える文字の定数
* パスワードを作成するメソッド
  引数として文字数を受け取り半角英字、記号、数字を含んだランダムな文字列を返却する
* 作成したパスワードが作成条件を満たしているかチェックするメソッド


実行は`Main`クラスを作成し
ユーザーから生成する数と生成する文字列の長さを受け取れるようにしてパスワードを出力できるようにしてください。

### 条件
* パスワードに使われる文字列は半角英数と記号(_,!,@,$,+,#,%)のみとする
* 生成されたパスワードは英大文字、数字、記号が少なくとも1字ずつ含まれることとする。

### 入出力例

* その１
  * 入力 -> 5
  * 入力 -> 5
  * 出力 -> [@SV7z, c8Oi_, N$7ko, %g2fR, qR9%f]
* その2
  * 入力 -> 10
  * 入力 -> 4
  * 出力 -> [QBpxZ2_pyy, jE2zNh+#fg, GI7fl+BYzz, N5aj3R+%vj]

