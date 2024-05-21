# 研修2日目

## クラスとインスタンスについて

### クラス

クラスはオブジェクトの設計図やテンプレートのようなものです。
オブジェクトは属性（データや変数）と振る舞い（メソッドや関数）を持ちます。

以下はクラスの例です。
クラス「Person」は名前や年齢、住所などの属性を持ち
挨拶をするなどのふるまいが定義されています。

![クラス](img/class.png)

「Person」自体は実際のデータを持たず、単なる設計書として存在します。

```java
public class Person {
  // フィールド(属性)
  int age;
  String name;

  // メソッド(ふるまい)
  Stinrg greet greeting(Stinrg greet) {
    System.out.println(greet);
  }

  public int sayAge() {
    return age;
  }
}
```

「Person」を使用するには、ここから実際のインスタンスを作る必要があります。
作られたインスタンスは個別のオブジェクトとして実際のデータやふるまいを行います。
  ```java
  Person john = new Person();
  // 挨拶をする
  john.greeting("hello");
  // 年齢
  john.age=20;
  // 名前
  john.name="john";
  ```

クラスは、オブジェクトの特性や動作を表現するために使用されます。
例えばReaderクラスがあれば、何か読み込みをするクラスだと考えられますし
Writerクラスがあれば、何か書き込みをするクラスだと考えられます。

インスタンスは`new`するたびに作成されるため、クラスは生成のたびに再利用できる設計図となります。

### フィールド
フィールドは、クラスに存在する変数宣言のようなものです。
「Person」でいうと`age`や`name`,`address`です。

下記が宣言の仕方です
```java
public class Sample {
  // [フィールドの型] フィールド名
  int age;
}
```

初期化されていない場合はデフォルト値になります。
宣言時に同時に初期化することも可能です。
```java
public class Person {
  int age = 10;
}
```

インスタンスが作られた時にインスタンスから参照ができる変数となります。

```java
// 年齢を設定する
john.age = 20;
// 年齢を確認する
System.out.println(john.age);
```

フィールドを宣言する理由として、インスタンスが必要な変数を共通して宣言しておくことができることがあります。
Personならば年齢を利用したふるまいの定義(運転や飲酒の可否、成長期の判定など)があることが想定されます。
その場合、インスタンスで保持する属性(フィールド)が存在すればふるまいの定義が簡単になります。

フィールドについてはクラスのメソッドであれば、制限なく使用ができます。

```java
public class Person {
  int age;
  String name;

  public void sayAge() {
    // フィールド名だけを指定することでフィールドを参照できる。
    System.out.println(age);
  }

  public void setName(String name) {
    // 引数の名前とフィールドの名前が一致したときは
    // 判別のためにthisを使用することで、フィールドを指定して参照が出来る。
    // this.nameはフィールドのnameを指し、nameは引数のStringを指す
    this.name = name;
  }
}
```

### メソッド

必要なデータの操作がまとまった処理のことです。
好きな名前で定義することができます。
引数といって外部からデータを受け取り
`return`キーワードを使い、戻り値と言う処理結果を返却します。

下記がメソッドの宣言の仕方です。

```java
[アクセス修飾子] [戻り値の型] メソッド名([引数の型] 引数名) {
  //　メソッドの内容
  return 戻り値
}

// 例
public int method(String text) {
}
```

下記がメソッドの使用の仕方です。

```java
[インスタンス名].メソッド名(引数)
```

```java
// 挨拶する
john.greeting("hello");
// 年齢を言う
System.out.println(john.sayAge());
```

* 戻り値
  メソッドには戻り値という処理結果を返す事が必要とされています。
  戻り値で型が指定されている場合は、必ず`return`キーワードを使用して
  その型のデータをreturnする必要があります。
  voidの場合は戻り値が存在しない事を意味し、`return`キーワードは必要ありません。
  (メソッド内でreturnを使用し、処理を終了させることはできます。)

* シグネチャ
  メソッドの名前と引数、順序を合わせてメソッドのシグネチャと言います。
  同じクラスの中では同じシグネチャのメソッドは１つしか宣言することはできません。
  シグネチャが違う場合は同じメソッド名のメソッドを複数宣言することができ
  それを***メソッドのオーバーロード***といいます。

  ```java
  public void greeting(Stinrg greet) {
    System.out.println(greet);
  }

  public void greeting(String yourName, Stinrg greet) {
    System.out.println("Hi!" + yourName + " " + greet);
  }
  ```

* コンストラクタ
  フィールドはそのままだと初期値がないため、参照するとnullやデフォルト値(基本型の場合)になります。
  実際に使用するには初期化をする必要があります。
  その際に使われるのがコンストラクタです。

  インスタンスが作られる際に必ず実行される特殊なメソッドです。
  コンストラクタは戻り値の指定はなく、名前もクラスと一致させる必要があります。

    ```java
    class Person {
      int age;
      String name;
      String address;

      // コンストラクタ
      public Person() {
        age = 20;
        name = "john do"
      }

      // パラメータ付きのコンストラクタ
      public Person(String personName,int personAge) {
        age = personAge;
        name = personName;
      }
    }
    ```

    今までの断片を一つのクラスにすると下記になります
    ```java
    public class Sample {
      static class Person {
        // フィールド宣言
        int age;
        String name;
        String address;

        // コンストラクタ
        public Person() {
          // フィールドを初期化する
          age = 20;
          name = "john do";
        }

        public Person(String personName,int personAge) {
          // 与えられた引数のデータでフィールドを初期化する
          age = personAge;
          name = personName;
        }

        // メソッド宣言
        public void greeting(String greet) {
          System.out.println(greet);
        }

        public String sayAge() {
          return "(" + age + ")";
        }
      }

      public static void main(String[] args) {
        // デフォルトのコンストラクタでインスタンス作成
        Person john = new Person();

        // パラメータ付きのコンストラクタでインスタンス作成
        Person tom = new Person("tom",24);

        // 初期化されていないためnullが出力される
        System.out.println(tom.address);

        System.out.println("name:" + john.name + john.sayAge());
        System.out.println("name:" + tom.name + tom.sayAge());
      }
    }
    ```

### インスタンス

クラスを設計図として、作成されるデータの塊をインスタンス(オブジェクト)と言います。
インスタンスはクラスに`new`演算子を使用することで作成されます。
インスタンスはそれぞれ別個のもののため、それぞれに独自のデータを持ちます。

![インスタンス](img/instance.png)

```java
// tarouとhanakoは別のインスタンス
Person tarou = new Person();
Person hanako = new Person();

// 別に設定できる
tarou.age = 20;
hanako.age = 21;
```

### クラスフィールド(静的フィールド)

クラスフィールドは、クラスに属している変数のことです。
クラスフィールドはそれぞれのインスタンスで共有されるため、あるインスタンスでの変更が他のインスタンスにも反映されます。
クラスフィールドは静的修飾子`static`キーワードを使用して宣言され、インスタンス化せずに直接クラスからアクセスすることができます。

```java
public class Person {
  // 静的フィールドの宣言
  public static long population = 120000000;
}
```

使用する場合は直接クラスから呼び出します
```java
System.out.println(Person.population);

// インスタンスからも参照できます
Person p = new Person();
System.out.println(p.population);

// 書き変えた場合、クラスで共有しているため
// 他の全てのインスタンスでも書き換わる
p.population = 1;

Person john = new Person();
// どちらも1
System.out.println(john.population);
System.out.println(Person.population);

```

### クラスメソッド(静的メソッド)

クラス自体に関連付けられたメソッドです。
特定のインスタンスに対してではなく、クラス自体に対して操作を実行するために使用されます。
クラスメソッドはインスタンスが作成されていないため、インスタンスの情報にアクセスすることはできません。
ただし他のクラスメソッドやクラスフィールドにはアクセスできます。

クラスメソッドはクラスフィールドと同様に宣言時に`static`を付ける必要があります

```java
public class Person {
  static private long population = 120000000;

  // 静的メソッドの宣言
  static long outputPopulation(){
    return population;
  }

  static void inputPopulation(long num) {
    population = num;
  }
}
```

使用する際はクラスから直接呼び出します。
```java
System.out.println(Person.outputPopulation());
```

以下は組み込みクラスライブラリでのクラスメソッドの例です。
```java
// IntegerクラスのparseIntメソッド
int i = Integer.parseInt("2");
// MathクラスのRandomメソッド
int rad = Math.Random();
```

### アクセス修飾子について

今まで、`public`や`private`等が出てきましたが、これらをアクセス修飾子と呼び
それぞれに意味があります。

アクセス修飾子はクラス、メソッド、フィールドなどのアクセス範囲を制御するためのキーワードです。
アクセス修飾子を使用することで、他のクラスやオブジェクトからのアクセスを制限したり、許可したりすることができます。
Javaには4つのアクセス修飾子があります。

* public

  どのクラスやパッケージからでもアクセス可能です。
  他のクラスから自由に利用できるようにするために使用されます。

* private

  同じクラス内からのみアクセス可能です。
  クラスの内部でのみ使用する変数やメソッドを宣言する際に使用されます。
  データの隠蔽と安全性を確保するために重要です。

  privateのメリットについて

    - クラス内の処理の隠蔽
      クラス内の処理でも同じ処理があった場合、重複部分をメソッドにすることによってコードの重複を減らす事が出来ます。
      上記のようなメソッドについてはクラスの内部からの使用を想定しているため、他のクラスからの使用はしてほしくないことになります。

      下記の場合掛け算の処理を共通化することができます

      ```java
      public int twiceMethod(int number) {
        return number * 2;
      }

      public int tripleMethod(int number) {
        return number * 3;
      }
      ```
      ↓

      ```java
      public int twiceMethod(int number) {
        return multiple(number,2);
      }

      public int tripleMethod(int number) {
        return multiple(number,3);
      }

      private int multiple(num1, num2) {
        return num1 * num2;
      }
      ```
      共通化したことによって、掛け算の処理の後に1を足すように変更したい場合でも
      `multiple`メソッドに変更を加えるだけですみます。

      しかし、`multiple`メソッドがpublicで他のクラスで使われていた場合
      意図しない影響が出る可能性がでてきます。

      上記のような状況を回避するため、クラス内で使用するメソッドについてはprivateにする方がよいとされています。

    - publicメソッドの内容の抽象化
      
      publicメソッドは他のクラスから使われますが、処理内容については詳しく知る必要はありません。

      ```java
      // 商品ごとの売上を返却するメソッド
      // 商品一覧を取得(getItems)して、商品ごとに売り上げを取得している(getEarn)ことがメソッド名からわかる
      // 実際の売り上げが別のクラスにあるのかファイルとして保存されているのか、どのような形であるかは理解しなくても
      // 売り上げを取得しているということがメソッド名からわかるため、処理を抽象化して理解できる
      public int[] getItemsEarn() {
        int[] result = new int[10];
        int index = 0;
        for(Item item : getItems()) {
          result[index] = getEarn(item);
        }
        return result;
      }
      ```

* protected

  同じパッケージ内のクラスと、サブクラスからのみアクセス可能です。
  継承関係にあるクラスにおいて、サブクラスから親クラスのメンバーにアクセスするために使用されます。


* default(アクセス修飾子を省略した場合)

  同じパッケージ内のクラスからのみアクセス可能です。
  アクセス修飾子を明示的に指定しなかった場合、デフォルトのアクセス修飾子となります。

<br>

## データ構造

### 配列

  配列とは、同じデータ型の要素を複数保持するためのデータ構造です。
  配列は固定の長さを持ち、要素は0から始まる添え字(インデックス)を使用してアクセスされます。
  宣言の際に固定の長さを決めて要素の入れる箱を確保します。

  ![配列説明](./img/array.png)

  ```java
  // 3つの整数を格納する配列を作成
  int[] numbers = new int[3]; 

  // 最初の要素に値を代入
  numbers[0] = 10; 
  // 1番目の要素の値を取得
  int x = numbers[1]; 
  ```
  (配列作成時にデフォルト値で初期化されるため[1]へのアクセスは0が表示される)

  配列はデータの集合を扱うために使用することが多いです。
  for等の繰り返し処理により順に操作していくなどが主な用途です。

  ```java
  // 配列の宣言と初期化を同時に行う。
  int[] numbers = new int[](1,2,3,4,5);

  for(int i = 0; i < 5; i++) {
    if (numbers[i] > 2) {
      System.out.println("2より大きい");
    }
  }
  ```

### 可変長配列(ArrayList)

  可変長配列は、配列のサイズが動的に変更できるデータ構造です。
  通常の配列とは異なり、要素を追加するたびにサイズが増加します。

  ![ArrayList説明](img/arraylist.png)

  Javaでは、java.util.ArrayListクラスを使用して改変長配列を作成します。

  ```java
  ArrayList<String> names = new ArrayList<String>();

  // 要素の追加
  names.add("alice");
  names.add("bob");
  names.add("charlie");
  
  // 0番目の要素の取得
  String name = names.get(0);
  // 2番目の要素の削除
  names.remove(2);
  ```

  classの後の`<String>`の部分を型パラメータやジェネリクスと呼びます。
  これはArrayListに格納される要素がStringであると宣言しています。


### スタック(Stack)
  
  スタックは、後入れ先出しのデータ構造です。
  LIFO(Last IN First OUT)とも言われます。
  要素の追加と削除は一方向からのみ行われ、最後に追加された要素が最初に取り出されます。

  ![スタック説明](img/stack.png)

  Javaでは、スタックを表現するためにjava.util.Stackクラスを使用します。

  ```java
  import java.util.Stack;

  public class Sample {
    public static void main(String[] args) {
      Stack<String> stack = new Stack<>();

      // 要素を1個、スタックに挿入する。
      stack.push("Frontpage");
      stack.push("ItemListPage");
      stack.push("ItemDetailPage");

      // 要素を1個取得し、スタックから削除する。
      String subject = stack.pop(); 
    }
  }
  ```

  スタックは後から追加した要素を処理していくので
  メソッドのコールスタック(呼び出し順)や履歴の管理などで使われています。

### キュー(Queue)
  キューは、先入れ先出しのデータ構造です。
  FIFO(First IN First OUT)とも言われます。
  要素の追加は一方向から行われ、要素の削除は別の方向から行われます。

  ![キュー説明](img/queue.png)

  Javaでは、キューを表現するためにjava.util.Queueインタフェースとjava.util.LinkedListを使用します。

  ```java
  import java.util.Queue;
  import java.util.LinkedList;

  public class Sample {
    public static void main(String[] args) {

      Queue<MyTask> queue = new LinkedList<MyTask>();

      // 要素を1ずつ追加する
      queue.offer(new MyTask("ゴミ出し")); 
      queue.offer(new MyTask("洗濯")); 
      queue.offer(new MyTask("洗い物")); 

      // 要素を1個取り出し、削除する
      MyTask task = queue.poll();  
     }
  }
  ```

  キューは追加された順に要素を処理していくので
  非同期処理などの順番を保ちながら管理、処理していく作業の時に使われます。

### ハッシュマップ(HashMap)

  ハッシュマップは、キーと値のペアを保持するデータ構造です。
  キーと値は1対1の関係を持ち、キーを使用して値を効率的に検索することができます。

  ![ハッシュマップ説明](img/hashmap.png)

  ハッシュマップではキーは一意となり、重複出来ません。
  値を全て取り出すなどもメソッドとしてありますが順序は保障されていません。

  Javaでは、java.util.HashMapクラスを使用してハッシュマップを作成します。
  
  ```java
  import java.util.HashMap;

  public class Sample {
    public static void main(String[] args) {

    // ハッシュマップの作成
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    // ハッシュマップにキーを指定して値を追加する
    map.put("Alice", 25); 
    map.put("Bob", 30);
    map.put("Charlie", 35);

    // キーから値を取得する。
    int age = map.get("Bob");
    // キーから値を削除する。
    map.remove("Alice"); 
     }
  }
  ```
  
  ハッシュマップはデータの関連付け等が必要な場合に利用されます。
  例の名前と年齢や、商品と売上などです。

<br>

## クラスの継承について

クラスは既存のクラスの機能を引継ぎ、拡張して新しい機能を付け足したクラスを作ることができます。
拡張して作成した場合、元になったクラスを`スーパークラス`、拡張した先を`サブクラス`と呼びます

クラスを拡張して作成する場合は`extends`キーワードを使います。

```java
// Personクラスを拡張しSuperManクラスを宣言している
public class SuperMan extends Person {
}
```

拡張は1つのクラスからしか拡張できませんが、拡張済みのクラスをさらに拡張することができます。

```java
// Animalクラスを拡張しPersonクラスを宣言
public class Person extends Animal {
}
// Personクラスを拡張しSuperManクラスを宣言
public class SuperMan extends Person {
}
```

上の例ではPersonはAnimalクラスから見るとサブクラスで、SuperManクラスから見るとスーパークラスになります。
SuperMan <- Person <- Animal のような拡張の連鎖を**クラス階層**と呼びます。

![クラス階層](img/classhierarcky.png)

`extends`を使わずクラスを宣言した場合、スーパークラスは`Object`クラスになります。
なのでクラス階層の最上位は常に`Object`クラスになります。

スーパークラスは1つしか作れませんが、サブクラスは複数作れます。

![クラス継承](img/subclass.png)

クラスを拡張して作成することをクラスを継承するといいます。

### 継承で引き継がれる内容

継承することによって、スーパークラスからフィールドとメソッドが引き継がれます。

![継承内容](img/classextend.png)

```java
public class Sample {

  static class Person {
    // Personのフィールド
    int age;
    String name;

    public Person(){
      age = 30;
      name = "Clark Kent";
    }

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    // Personのメソッド
    public void introduce() {
      System.out.println("I am a person.");
    }

    public String sayAge(){
      return "(" + age + ")";
    }
  }

  static class SuperMan extends Person {
    // Personからの継承内容として
    // int age;
    // String name;
    // が隠れている

    // SuperManのフィールド
    int power;

    // Personからの継承内容として
    // public void introduce() {
    //   System.out.println("I am a person.");
    // }

    // public String sayAge(){
    //   return "(" + age + ")";
    // }
    // が隠れている

    // SuperManのメソッド
    public void fly() {
      System.out.println("flying");
    }
  }

  public static void main(String[] args) {
    Person kent = new Person();
    System.out.println(kent.name + kent.sayAge());

    SuperMan man = new SuperMan();
    man.name = "someone";
    man.age = 20;
    System.out.println(man.name + man.sayAge());
   }
}
```

コンストラクタについては継承されません。
継承はされませんが、`super()`というサブクラスからスーパークラスのコンストラクタへのアクセスを行う手段が用意されています。
サブクラスのコンストラクタ内で`super()`を呼び出しすることによって、スーパークラスのコンストラクタを実行することができます。

```java
class SuperMan extends Person {
  int power;

  // SuperManのメソッド
  public void fly() {
    System.out.println("flying");
  }

  // コンストラクタ
  public SuperMan() {
    // スーパークラスのコンストラクタのコードを呼び出す
    // public Person(){
    //   age = 30;
    //   name = "Clark Kent";
    // }
    // 上記のため age,nameが初期化される
    // 明示的に呼び出しするにはsuper()を使用する
    power = 100;
  }
}
```

`super()`に関してはサブクラスのコンストラクタに明示的に書かれていない場合、コンストラクタ内の最初に自動的にパラメータ無しで実行されます。

`super()`に対してパラメータを設定することによって、パラメータ付きコンストラクタも呼び出すことができます。

```java
class SuperMan extends Person {
  int power;

  // SuperManのメソッド
  public void fly() {
    System.out.println("flying");
  }

  // コンストラクタ
  public SuperMan() {
    // super()に引数としてintとStringを与えることで下記のPersonのパラメータ付きコンストラクタを呼び出しできる
    // public Person(int age,String name) {
    //   this.age = age;
    //   this.name = name;
    // }
    super(10,"tom");
    power = 100;
  }
}
```

### メソッドのオーバーライドについて

メソッドのオーバーライドは、サブクラスがスーパークラスのメソッドを再定義することです。
オーバーライドにより、スーパークラスのメソッドの実装を変更することができます。

オーバーライドするためには、以下の条件を満たす必要があります。

* サブクラスとスーパークラスの間に継承関係が存在すること。
* オーバーライドするメソッドのシグネチャ(メソッドの名前と引数)が完全に一致していること。

以下に具体例です。

```java
public class Person {
  public void introduce() {
    System.out.println("I am a person.");
  }
}

public class SuperMan extends Person {
  @Override
  public void introduce() {
    System.out.println("I am SuperMan!");
  }
}
```
上記の例では、Personクラスにintroduceメソッドがあります。
SuperManクラスでは、@Overrideアノテーションを使ってintroduceメソッドをオーバーライドしています。
オーバーライドされたメソッドは同じメソッド名と引数(シグネチャ)を持ち、処理内容を変更することができます。

オーバーライドされたメソッドは、サブクラスのインスタンスで呼び出された場合に、サブクラスの実装が優先されます。

```java
public class Main {
  public static void main(String[] args) {
    // "I am a person."と表示されます。
    Person person = new Person();
    person.introduce();

    // サブクラスの実装が優先されるため
    // "I am SuperMan!" と表示されます。
    SuperMan superman = new SuperMan();
    superman.introduce();
  }
}
```

#### オーバーライドの注意点について

アクセス修飾子はオーバーライドするメソッドと同じか、より広い範囲でなければなりません。

例えば、スーパークラスのメソッドが`protected`であれば、サブクラスのオーバーライドメソッドは`public`または`protected`にする必要があります。
オーバーライドするメソッドに`final`や`private`が付いている場合はオーバーライドできません。

オーバーライドする際には、@Overrideアノテーションを使用することが推奨されます。
これによりコンパイラがオーバーライドのチェックを行ってくれます。


### IS-A関係

継承した場合、例のクラスでいうとsupermanはpersonの一種であると言えます。
上記の関係をIS-A関係と言ったりもします。

同時にフィールドでもつ属性に関してはHAS-A関係(合成)と呼びます。

### 暗黙の型変換
サブクラスのインスタンスであればスーパークラスの変数に暗黙的に型変換し変数に代入することができます。
逆にスーパークラスのインスタンスは明示的な型変換を行う事でサブクラスの変数に代入することができます。

```java
// PersonはAnimalを拡張したもののため明示的な変換が不要
Animal animal = new Person();
// animalはpersonの拡張元のため明示的な変換が必要
Person person = (Person)animal;
```

### 抽象クラスについて

何も実装されていないメソッドを抽象メソッドと言います。
抽象メソッドはメソッドの名前と引数の型だけが決まっています。

抽象メソッドを持つクラスを抽象クラスといいます。
抽象クラスはインスタンスを生成することができません。

両方とも`abstract`キーワードを使い宣言します。

```java
// 抽象クラス
abstract class Printer {
  // 抽象メソッド
  public abstract String print(String text);
}
```

抽象メソッドは自分でメソッドを実装しない代わりに、継承したサブクラスにて実装されることを期待します。

```java
public abstract class Printer {
  public abstract String print(String text);
}

pulbic class PlusPrinter extends Printer {
  public String print(String text) {
    return "+++" + text + "+++";
  }
}

public class AsteriskPrinter extends Printer {
  public String print(String text) {
    return "***" + text + "***";
  }
}

public class Sample {

  public static void main(String[] args) {
    // 抽象クラスはインスタンスを作れないため
    // 下記はコンパイル時にエラーになる
    // Printer printer = new Printer();

    // スーパークラスの型の変数へはサブクラスは代入可能
    Printer printer = new PlusPrinter();
    String str = printer.print("出力します");
    System.out.println(str);
    // +++出力します+++

    // スーパークラスの型の変数へはサブクラスは代入可能
    printer = new AsteriskPrinter();
    str = printer.print("出力します");
    System.out.println(str);
    // ***出力します***

    // 出力結果から確認出来るが
    // サブクラスであれば同じメソッドが使用でき、ふるまいだけを変更できる
   }
}
```

## ガーベッジコレクション

Javaでは、メモリ管理を自動化する仕組みがあります。
その中でも重要な役割を果たすのがガーベッジコレクションです。
ガーベッジコレクションは、プログラムが不要になったオブジェクト（ガーベッジ）を自動的に検出し、解放する処理のことを指します。

Javaではプログラムの実行にインスタンスを生成し使用します。
このインスタンスはプログラムの実行中に利用されますが、いずれは不要になります。
不要になったインスタンスがメモリを占有し続けることで、新しくメモリを使うことが出来ずリソースの浪費となります。


![ガーベッジコレクション](img/gc.png)


ガーベッジコレクションは不要になったインスタンスを自動的に検出し、インスタンスに使われているメモリを解放します。
具体的には、ガーベッジコレクタと呼ばれる特殊なプログラムが定期的に実行され、以下のようなプロセスを経て不要なインスタンスを解放します。

1. プログラムが実行中に、インスタンスが作成されます。
2. ガーベッジコレクタは定期的にメモリ内のインスタンスをスキャンし、到達可能なインスタンス（アクティブなインスタンス）を特定します。
3. 到達可能なインスタンスは、他のインスタンスから参照されているインスタンスです。
4. 到達不可能なインスタンスは、不要なインスタンスと見なされ、ガーベッジとしてマークされます。
5. ガーベッジコレクタは、マークされたガーベッジを解放し、メモリを回収します。解放されたメモリは、再利用可能な状態となります。

ガーベッジコレクションの利点は、メモリ管理を開発者が意識する必要がないという点です。
ガーベッジコレクタが自動的にメモリを解放するため、メモリリークや解放し忘れといった問題を防ぐことができます。

ただしガーベッジコレクションには一定のオーバーヘッドが伴います。
ガーベッジコレクタが実行される間、プログラムの実行が一時停止することがあります。

そのため、リアルタイム性が重視されるアプリケーションや、大規模なメモリを使用するアプリケーションでは、ガーベッジコレクションの動作に注意が必要です。

ガーベッジコレクション`System.gc()`で任意に実行することもできるため、実行タイミングをコントロールすることもあります。
