import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {


    /**
     * NIVEL 1: Ejecucion basica e impresion directa.
     * Ejecuta el comando 'factor' de Linux pasándole la entrada del usuario.
     * Lee la salida estándar/error en tiempo real y la imprime directamente por consola.
     *
     * @param numero Entrada de texto enviada al comando (ej. "12" o "hola").
     * "@return" No devuelve nada (void). Imprime el resultaado e infroma del exitCode final.
     */
    public static String nivel1(String numero) {
        StringBuilder sb = new StringBuilder();
        try {
            ProcessBuilder pb = new ProcessBuilder("factor", numero);
            pb.redirectErrorStream(true);

            Process process = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    sb.append(linea).append("\n");
                }
            }

            int exitCode = process.waitFor();
            sb.append("Operacion completada. Código de salida: ").append(exitCode);

        }catch (Exception e) {
            return "Error el ejecutar el comando" + e.getMessage();
        }
        return sb.toString();
    }

    /**
     * NIVEL 2: Control de errores y etiquetado con prefijo.
     * Acumula la salida en un StringBuilder y usa el código de terminación (exitCode)
     * para clasificar el resultado. Añade "[OK]" si se factorizó con éxito (exitCode 0)
     * o "[ERROR]" si el argumento ingresado no es válido (exitCode1).
     *
     * @param numero Entrada de texto enviada al comando (ej. "12" o "hola").
     * @return No devuelve nada (void). Imprime el resultaado e infroma del exitCode final.
     */
    public static String nivel2(String numero) {
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
                return "[OK] " + salidaProceso;
            } else {
                return "[ERROR] " + salidaProceso;
            }
        }catch (Exception e) {
            return "Error el ejecutar el comando" + e.getMessage();
        }
    }

    public static String nivel3(String numero) {
        try {

            File factor_output = new File("factor_output.log");
            File factor_error = new File("factor_error.log");

            ProcessBuilder pb = new ProcessBuilder("factor", numero);

            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(factor_output));
            pb.redirectError(ProcessBuilder.Redirect.appendTo(factor_error));

            Process process = pb.start();

            int exitCode = process.waitFor();
            return "Operacion completada. Código de salida: " + exitCode;

        }catch (Exception e) {
            return "Error el ejecutar el comando" + e.getMessage();
        }
    }

    public static String nivel4(String numero) {
        List<Integer> factores = new ArrayList<>();
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
                String resultado = salidaProceso.toString().trim();
                String [] partes = resultado.split(":");
                if (partes.length > 1) {
                    String[] numerosTexto = partes[1].trim().split("\\s+");
                    for (String n: numerosTexto) {
                        if (!n.isEmpty()) {
                            factores.add(Integer.parseInt(n));
                        }
                    }
                }
                if (factores.size() == 1) {
                    return "[OK] " + salidaProceso + partes[0] + " es primo!";
                } else {
                    return "[OK] " + salidaProceso + partes[0] + " no es primo";
                }
            } else {
                return "[ERRO] " + salidaProceso;
            }
        }catch (Exception e) {
            return "Error el ejecutar el comando" + e.getMessage();
        }
    }
}
