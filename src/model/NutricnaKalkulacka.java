package model;

public class NutricnaKalkulacka {

    public static double idealneKalorie(Osoba osoba) {
        if (osoba == null) {
            throw new IllegalArgumentException("Osoba nesmie byť null.");
        }

        double zaklad;

        if (osoba.getPohlavie().equals("muz")) {
            if (osoba.getVek() < 18) {
                zaklad = 2700;
            } else if (osoba.getVek() <= 30) {
                zaklad = 2500;
            } else if (osoba.getVek() <= 50) {
                zaklad = 2400;
            } else {
                zaklad = 2200;
            }
        } else if (osoba.getPohlavie().equals("zena")) {
            if (osoba.getVek() < 18) {
                zaklad = 2200;
            } else if (osoba.getVek() <= 30) {
                zaklad = 2000;
            } else if (osoba.getVek() <= 50) {
                zaklad = 1900;
            } else {
                zaklad = 1800;
            }
        } else {
            throw new IllegalArgumentException("Neznáme pohlavie.");
        }

        switch (osoba.getUrovenAktivity()) {
            case "nizka":
                return zaklad * 0.9;
            case "stredna":
                return zaklad;
            case "vysoka":
                return zaklad * 1.2;
            default:
                throw new IllegalStateException("Neznáma úroveň aktivity.");
        }
    }

    public static double idealneBielkoviny(Osoba osoba) {
        return (idealneKalorie(osoba) * 0.20) / 4;
    }

    public static double idealneTuky(Osoba osoba) {
        return (idealneKalorie(osoba) * 0.30) / 9;
    }

    public static double idealneSacharidy(Osoba osoba) {
        return (idealneKalorie(osoba) * 0.50) / 4;
    }

    private static String porovnaj(String nazov, double skutocne, double ideal) {
        if (skutocne < ideal * 0.9) {
            return nazov + ": málo\n";
        } else if (skutocne > ideal * 1.1) {
            return nazov + ": veľa\n";
        } else {
            return nazov + ": OK\n";
        }
    }

    public static String ohodnotJedalnicek(Jedalnicek jedalnicek, Osoba osoba) {
        if (jedalnicek == null || osoba == null) {
            throw new IllegalArgumentException("Jedálniček ani osoba nesmú byť null.");
        }

        if (jedalnicek.getJedla().isEmpty()) {
            return "Jedálniček je prázdny.";
        }

        double kcal = jedalnicek.getSpoluKalorie();
        double bielkoviny = jedalnicek.getSpoluBielkoviny();
        double tuky = jedalnicek.getSpoluTuky();
        double sacharidy = jedalnicek.getSpoluSacharidy();

        String hodnotenie = "\n--- HODNOTENIE JEDÁLNIČKA ---\n";
        hodnotenie += porovnaj("Kalórie", kcal, idealneKalorie(osoba));
        hodnotenie += porovnaj("Bielkoviny", bielkoviny, idealneBielkoviny(osoba));
        hodnotenie += porovnaj("Tuky", tuky, idealneTuky(osoba));
        hodnotenie += porovnaj("Sacharidy", sacharidy, idealneSacharidy(osoba));

        return hodnotenie;
    }
}
