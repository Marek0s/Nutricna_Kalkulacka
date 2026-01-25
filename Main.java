import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        KatalogJedal katalog = new KatalogJedal();
        Jedalnicek jedalnicek = new Jedalnicek();

        System.out.print("Zadaj pohlavie (muz/zena): ");
        String pohlavie = sc.nextLine();

        System.out.print("Zadaj vek: ");
        int vek = sc.nextInt();
        sc.nextLine();

        System.out.print("Úroveň aktivity (nizka/stredna/vysoka): ");
        String aktivita = sc.nextLine();

        Osoba osoba = new Osoba(pohlavie, vek, aktivita);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Zobraziť katalóg jedál");
            System.out.println("2. Pridať jedlo do jedálnička");
            System.out.println("3. Zobraziť denný príjem");
            System.out.println("4. Ohodnotiť jedálniček");
            System.out.println("0. Koniec");

            int volba = sc.nextInt();

            switch (volba) {
                case 1:
                    for (int i = 0; i < katalog.getJedla().size(); i++) {
                        System.out.println(i + ": " + katalog.getJedla().get(i).getNazov());
                    }
                    break;

                case 2:
                    System.out.print("Zadaj index jedla: ");
                    int index = sc.nextInt();
                    jedalnicek.pridajJedlo(katalog.getJedloPodlaIndexu(index));
                    System.out.println("Jedlo pridané.");
                    break;

                case 3:
                    System.out.println("Kalórie: " + jedalnicek.getSpoluKalorie());
                    System.out.println("Bielkoviny: " + jedalnicek.getSpoluBielkoviny());
                    System.out.println("Tuky: " + jedalnicek.getSpoluTuky());
                    System.out.println("Sacharidy: " + jedalnicek.getSpoluSacharidy());
                    break;

                case 4:
                    System.out.println(
                            NutricnaKalkulacka.ohodnotJedalnicek(jedalnicek, osoba)
                    );
                    break;

                case 0:
                    System.out.println("Koniec programu.");
                    return;

                default:
                    System.out.println("Neplatná voľba.");
            }
        }
    }
}
