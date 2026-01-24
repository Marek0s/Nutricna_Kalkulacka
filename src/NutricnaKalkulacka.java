public class NutricnaKalkulacka {

    public static double idealneKalorie(Osoba osoba) {
        double zaklad;

        if (osoba.getPohlavie().equals("muz")) {
            zaklad = 2500;
        } else {
            zaklad = 2000;
        }

        switch (osoba.getUrovenAktivity()) {
            case "nizka": return zaklad * 0.9;
            case "stredna": return zaklad;
            case "vysoka": return zaklad * 1.2;
            default: return zaklad;
        }
    }

    public static String ohodnotJedalnicek(Jedalnicek jedalnicek, Osoba osoba) {
        double prijem = jedalnicek.getSpoluKalorie();
        double ideal = idealneKalorie(osoba);

        if (prijem < ideal * 0.9) {
            return "Nedostatočný kalorický príjem";
        } else if (prijem <= ideal * 1.1) {
            return "Vyhovujúci jedálniček";
        } else {
            return "Nadmerný kalorický príjem";
        }
    }
}
