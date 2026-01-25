import java.util.ArrayList;
import java.util.List;

public class Jedalnicek {
    private List<Jedlo> jedla = new ArrayList<>();

    public void pridajJedlo(Jedlo jedlo) {
        if (jedlo == null)
            throw new IllegalArgumentException("Jedlo nesmie byť null.");
        jedla.add(jedlo);
    }

    public List<Jedlo> getJedla() {
        return jedla;
    }

    public double getSpoluKalorie() {
        return jedla.stream().mapToDouble(Jedlo::getKcal).sum();
    }

    public double getSpoluBielkoviny() {
        return jedla.stream().mapToDouble(Jedlo::getBielkoviny).sum();
    }

    public double getSpoluTuky() {
        return jedla.stream().mapToDouble(Jedlo::getTuky).sum();
    }

    public double getSpoluSacharidy() {
        return jedla.stream().mapToDouble(Jedlo::getUhlohydraty).sum();
    }
}
