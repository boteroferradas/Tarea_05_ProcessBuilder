import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;

public class Lanzador {

    public static void nivel1(String numero) {
        try {
            //Crea un nuevo objeto ProcessBuilder, con el comando "factor" como parametro y el numero que se le pase
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

    public static void nivel2(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process process = pb.start();

            StringBuilder salidaProceso = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    salidaProceso.append(linea);
                }
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("[OK] " + salidaProceso);
            } else {
                System.out.println("[ERROR] " + salidaProceso);
            }
        }catch (Exception e) {
            System.out.println("Error el ejecutar el comando" + e.getMessage());
        }
    }

    public static void nivel3(String numero) {
        try {

            File factor_output = new File("factor_output.log");
            File factor_error = new File("factor_error.log");

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(factor_output));
            pb.redirectError(ProcessBuilder.Redirect.appendTo(factor_error));

            Process process = pb.start();

            int exitCode = process.waitFor();
            System.out.println("Operacion completada. Código de salida: " + exitCode);

        }catch (Exception e) {
            System.out.println("Error el ejecutar el comando" + e.getMessage());
        }
    }

    public static void nivel4(String numero) {
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectErrorStream(true);

            Process process = pb.start();

            StringBuilder salidaProceso = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    salidaProceso.append(linea);
                }
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("[OK] " + salidaProceso);
            } else {
                System.out.println("[ERROR] " + salidaProceso);
            }
        }catch (Exception e) {
            System.out.println("Error el ejecutar el comando" + e.getMessage());
        }
    }

}
