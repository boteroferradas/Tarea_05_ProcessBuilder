import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("¿Qué nivel quieres usar? (1, 2, 3, 4): ");
            String nivel = scanner.nextLine().trim();
            if (nivel.equalsIgnoreCase("salir")){
                System.out.println("Saliendo del programa");
                break;
            }
            switch (nivel) {
                case "1":
                    while(true) {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        String entrada = scanner.nextLine().trim();

                        if(entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Saliendo del nivel 1...");
                            break;
                        }

                        Lanzador.nivel1(entrada);
                        System.out.println();
                    }
                    break;

                case "2":
                    while(true) {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        String entrada = scanner.nextLine().trim();

                        if(entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Saliendo del nivel 2...");
                            break;
                        }

                        Lanzador.nivel2(entrada);
                        System.out.println();
                    }
                    break;

                case "3":
                    while(true) {
                        System.out.println("Introduce un número (o 'salir' para terminar):");
                        String entrada = scanner.nextLine().trim();

                        if(entrada.equalsIgnoreCase("salir")) {
                            System.out.println("Saliendo del nivel 2...");
                            break;
                        }

                        Lanzador.nivel3(entrada);
                        System.out.println();
                    }
                    break;

                case "4":

                default:
                    System.out.println("factor: " + scanner + "Opc");
            }
        }
    }

}
