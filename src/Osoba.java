public class Osoba {
    private String pohlavie;
    private int vek;
    private String urovenAktivity;

    public Osoba(String pohlavie, int vek, String urovenAktivity) {
        if (!pohlavie.equalsIgnoreCase("muz") &&
                !pohlavie.equalsIgnoreCase("zena")) {
            throw new IllegalArgumentException("Pohlavie musí byť 'muz' alebo 'zena'.");
        }

        if (vek <= 0 || vek > 120) {
            throw new IllegalArgumentException("Neplatný vek osoby.");
        }

        if (!urovenAktivity.equalsIgnoreCase("nizka") &&
                !urovenAktivity.equalsIgnoreCase("stredna") &&
                !urovenAktivity.equalsIgnoreCase("vysoka")) {
            throw new IllegalArgumentException("Neplatná úroveň aktivity.");
        }

        this.pohlavie = pohlavie.toLowerCase();
        this.vek = vek;
        this.urovenAktivity = urovenAktivity.toLowerCase();
    }

    public String getPohlavie() { return pohlavie; }
    public int getVek() { return vek; }
    public String getUrovenAktivity() { return urovenAktivity; }
}
