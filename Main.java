import java.util.Scanner;
//Cream clasa Main 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean iesireProgram = false;
        System.out.println("Ce doriti să faceti?");
        while (!iesireProgram) {
            System.out.println("1. Deschideti garajul");
            System.out.println("2. Iesiti din program");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    deschideGaraj(scanner);
                    break;
                case "2":
                    iesireProgram=true;
                    break;
            }
        }

        scanner.close();
    }
//Metoda deschideGaraj
    public static void deschideGaraj(Scanner scanner) {
        //Cream instanta Garaj pentru gestionarea masinilor 
        Garaj garaj = new Garaj(); 

        boolean iesire = false;

        while (!iesire) {
            afiseazaModeleMasini(garaj);

            System.out.println("Alege masina dorita sau tastati 'exit' pentru a parasi garajul:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                iesire = true;
            } else {
                    int indexMasina = Integer.parseInt(input);

                    Masina masinaSelectata = garaj.selecteazaMasina(indexMasina);
                        afiseazaDetaliiMasina(masinaSelectata);
            }
        }
    }
//Metoda afiseazaModeleMasini ne arata toate modelele disponibile in garaj care le putem alege
    public static void afiseazaModeleMasini(Garaj garaj) {
        System.out.println("Masinile din garaj:");
        for (int i = 0; i < garaj.getNumarMasini(); i++) {
            Masina masina = garaj.selecteazaMasina(i);
            System.out.println(i + ". " + masina.getMarca() + " " + masina.getModel());
        }
    }
//Metoda afiseazaDetaliiMasina ne arata toate detaliile despre masina dupa ce am ales-o
    public static void afiseazaDetaliiMasina(Masina masina) {
        System.out.println("Ai selectat masina: "+masina.getMarca()+" " + masina.getModel() + ", An de fabricatie: " + masina.getAnFabricatie()+" Numar de kilometrii "+ masina.numarKilometrii() +" Culoarea: "+ masina.culoareMasina()+".");
        System.out.println("Multumim pentru alegera facuta");
        System.exit(0);
    }
}