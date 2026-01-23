import java.util.ArrayList;
import java.util.List;

public class KatalogJedal {
    private List<Jedlo> jedla;

    public KatalogJedal() {
        this.jedla = new ArrayList<>();

        // preddefinované jedlá
        jedla.add(new Jedlo("Kuracie prsia", 165, 31, 3.6, 0));
        jedla.add(new Jedlo("Ryža", 130, 2.7, 0.3, 28));
        jedla.add(new Jedlo("Jablko", 52, 0.3, 0.2, 14));
    }

    public List<Jedlo> getJedla() {
        return jedla;
    }

    public Jedlo getJedloPodlaIndexu(int index) {
        return jedla.get(index);
    }
}
