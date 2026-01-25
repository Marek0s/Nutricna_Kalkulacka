import java.util.ArrayList;
import java.util.List;

public class KatalogJedal {
    private List<Jedlo> jedla = new ArrayList<>();

    public KatalogJedal() {
        jedla.add(new Jedlo("Kuracie prsia", 165, 31, 3.6, 0));
        jedla.add(new Jedlo("Hovädzie mäso chudé", 250, 26, 17, 0));
        jedla.add(new Jedlo("Losos pečený", 206, 22, 13, 0));
        jedla.add(new Jedlo("Vajcia varené (2 ks)", 140, 12.6, 9.5, 0.7));
        jedla.add(new Jedlo("Ryža biela varená", 130, 2.7, 0.3, 28));
        jedla.add(new Jedlo("Zemiaky varené", 77, 2, 0.1, 17));
        jedla.add(new Jedlo("Ovsené vločky (suché)", 379, 13, 7, 66));
        jedla.add(new Jedlo("Celozrnný chlieb", 247, 9, 3.4, 49));
        jedla.add(new Jedlo("Jablko", 52, 0.3, 0.2, 14));
        jedla.add(new Jedlo("Banán", 89, 1.1, 0.3, 23));
        jedla.add(new Jedlo("Brokolica varená", 35, 2.4, 0.4, 7));
        jedla.add(new Jedlo("Mrkva surová", 41, 0.9, 0.2, 10));
        jedla.add(new Jedlo("Tvaroh odtučnený", 71, 16.5, 0.2, 1.3));
    }

    public List<Jedlo> getJedla() {
        return jedla;
    }

    public Jedlo getJedloPodlaIndexu(int index) {
        if (index < 0 || index >= jedla.size())
            throw new IllegalArgumentException("Neplatný index jedla.");
        return jedla.get(index);
    }
}
