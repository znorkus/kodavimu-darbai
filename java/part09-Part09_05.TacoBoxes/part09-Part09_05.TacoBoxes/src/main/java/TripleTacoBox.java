import java.io.IOException;
import java.nio.CharBuffer;

public class TripleTacoBox implements TacoBox {

    int tacos;
    public TripleTacoBox() {
        this.tacos = 3;
    }

    @Override
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if (this.tacos > 0) {
            this.tacos = this.tacos -1;
        }
    }
}
