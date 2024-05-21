
public class HyphenDecorater extends Decorater{

    @Override
    public String decorate(String text) {
        return buildDecoratedString(text, '-');
    }

}
