public class Jedlo {
    private String nazov;
    private double kcal;
    private double bielkoviny;
    private double tuky;
    private double uhlohydraty;

    public Jedlo(String nazov, double kcal, double bielkoviny, double tuky, double uhlohydraty) {
        if (nazov == null || nazov.trim().isEmpty())
            throw new IllegalArgumentException("Názov jedla nesmie byť prázdny.");
        if (kcal < 0 || bielkoviny < 0 || tuky < 0 || uhlohydraty < 0)
            throw new IllegalArgumentException("Nutričné hodnoty nemôžu byť záporné.");

        this.nazov = nazov;
        this.kcal = kcal;
        this.bielkoviny = bielkoviny;
        this.tuky = tuky;
        this.uhlohydraty = uhlohydraty;
    }

    public String getNazov() { return nazov; }
    public double getKcal() { return kcal; }
    public double getBielkoviny() { return bielkoviny; }
    public double getTuky() { return tuky; }
    public double getUhlohydraty() { return uhlohydraty; }
}
