import java.io.FileWriter;
import java.io.IOException;

// SRP: una clase genera el reporte, otra lo guarda.
public class SRP_Ejemplo {

    static class Reporte {
        public String generar() {
            return "Reporte de ventas\nTotal: 1000\nFecha: 25/02/2026\n";
        }
    }

    static class ReporteRepository {
        public void guardar(String contenido, String ruta) {
            try (FileWriter writer = new FileWriter(ruta)) {
                writer.write(contenido);
                System.out.println("Guardado en: " + ruta);
            } catch (IOException e) {
                System.out.println("Error guardando el archivo");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Reporte reporte = new Reporte();
        String contenido = reporte.generar();

        ReporteRepository repo = new ReporteRepository();
        repo.guardar(contenido, "reporte_srp.txt");
    }
}