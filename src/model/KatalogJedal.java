package model;

import java.util.ArrayList;
import java.util.List;

public class KatalogJedal {
    private final List<Jedlo> jedla = new ArrayList<>();

    public KatalogJedal() {
        // --- Mäso & ryby ---
        jedla.add(new Jedlo("Kuracie prsia", 165, 31.0, 3.6, 0.0));
        jedla.add(new Jedlo("Hovädzie mäso chudé", 250, 26.0, 17.0, 0.0));
        jedla.add(new Jedlo("Losos pečený", 206, 22.0, 13.0, 0.0));
        jedla.add(new Jedlo("Tuniak v konzerve", 116, 26.0, 1.0, 0.0));
        jedla.add(new Jedlo("Morčacie prsia", 157, 30.0, 3.2, 0.0));
        jedla.add(new Jedlo("Bravčová panenka", 143, 22.0, 6.0, 0.0));
        jedla.add(new Jedlo("Treska pečená", 105, 23.0, 1.2, 0.0));
        jedla.add(new Jedlo("Krevety varené", 99, 24.0, 0.3, 0.0));
        jedla.add(new Jedlo("Sardinky v oleji", 208, 25.0, 11.0, 0.0));

        // --- Vajcia & mliečne výrobky ---
        jedla.add(new Jedlo("Vajcia varené (2 ks)", 140, 12.6, 9.5, 0.7));
        jedla.add(new Jedlo("Grécky jogurt (plnotučný)", 97, 9.0, 5.0, 3.6));
        jedla.add(new Jedlo("Tvaroh odtučnený", 71, 16.5, 0.2, 1.3));
        jedla.add(new Jedlo("Cottage cheese", 98, 11.0, 4.3, 3.4));
        jedla.add(new Jedlo("Mozzarella", 280, 18.0, 22.0, 2.2));
        jedla.add(new Jedlo("Eidam 30%", 261, 28.0, 16.0, 0.5));

        // --- Obilniny & prílohy ---
        jedla.add(new Jedlo("Ryža biela varená", 130, 2.7, 0.3, 28.0));
        jedla.add(new Jedlo("Ryža hnedá varená", 112, 2.6, 0.9, 23.0));
        jedla.add(new Jedlo("Ovsené vločky (suché)", 379, 13.0, 7.0, 66.0));
        jedla.add(new Jedlo("Celozrnný chlieb", 247, 9.0, 3.4, 49.0));
        jedla.add(new Jedlo("Cestoviny varené", 158, 5.8, 0.9, 31.0));
        jedla.add(new Jedlo("Zemiaky varené", 77, 2.0, 0.1, 17.0));
        jedla.add(new Jedlo("Quinoa varená", 120, 4.4, 1.9, 21.0));
        jedla.add(new Jedlo("Kuskus varený", 112, 3.8, 0.2, 23.0));
        jedla.add(new Jedlo("Šošovica varená", 116, 9.0, 0.4, 20.0));
        jedla.add(new Jedlo("Cícer varený", 164, 8.9, 2.6, 27.0));

        // --- Ovocie ---
        jedla.add(new Jedlo("Jablko", 52, 0.3, 0.2, 14.0));
        jedla.add(new Jedlo("Banán", 89, 1.1, 0.3, 23.0));
        jedla.add(new Jedlo("Pomaranč", 47, 0.9, 0.1, 12.0));
        jedla.add(new Jedlo("Jahody", 32, 0.7, 0.3, 7.7));
        jedla.add(new Jedlo("Čučoriedky", 57, 0.7, 0.3, 14.0));
        jedla.add(new Jedlo("Hrozno", 69, 0.7, 0.2, 18.0));
        jedla.add(new Jedlo("Mango", 60, 0.8, 0.4, 15.0));

        // --- Zelenina ---
        jedla.add(new Jedlo("Brokolica varená", 35, 2.4, 0.4, 7.0));
        jedla.add(new Jedlo("Mrkva surová", 41, 0.9, 0.2, 10.0));
        jedla.add(new Jedlo("Špenát varený", 23, 2.9, 0.4, 3.8));
        jedla.add(new Jedlo("Paradajky", 18, 0.9, 0.2, 3.9));
        jedla.add(new Jedlo("Uhorka", 15, 0.7, 0.1, 3.6));
        jedla.add(new Jedlo("Paprika červená", 31, 1.0, 0.3, 6.0));
        jedla.add(new Jedlo("Cuketa varená", 17, 1.2, 0.3, 3.1));

        // --- Orechy & tuky ---
        jedla.add(new Jedlo("Mandle", 579, 21.0, 50.0, 22.0));
        jedla.add(new Jedlo("Vlašské orechy", 654, 15.0, 65.0, 14.0));
        jedla.add(new Jedlo("Arašidové maslo", 588, 25.0, 50.0, 20.0));
        jedla.add(new Jedlo("Avokádo", 160, 2.0, 15.0, 9.0));
        jedla.add(new Jedlo("Olivový olej (1 PL)", 119, 0.0, 13.5, 0.0));
    }

    public List<Jedlo> getJedla() {
        return jedla;
    }

    public Jedlo getJedloPodlaIndexu(int index) {
        if (index < 0 || index >= jedla.size()) {
            throw new IllegalArgumentException("Neplatný index jedla.");
        }
        return jedla.get(index);
    }
}