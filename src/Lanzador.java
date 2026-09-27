import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lanzador {

    public static void proceso(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process process = pb.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Operacion completada. Código de salida: " + exitCode);

        }catch (Exception e) {
            System.out.println("Error el ejecutar el comando" + e.getMessage());
        }
    }
}
