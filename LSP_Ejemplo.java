// LSP: una clase hija debe poder reemplazar a la clase padre sin romper el programa.
public class LSP_Ejemplo {

    static class Ave {
        public void comer() {
            System.out.println("El ave está comiendo");
        }
    }

    interface Voladora {
        void volar();
    }

    static class Aguila extends Ave implements Voladora {
        public void volar() {
            System.out.println("El águila está volando");
        }
    }

    static class Pinguino extends Ave {
        // No implementa Voladora, porque no vuela.
        public void nadar() {
            System.out.println("El pingüino está nadando");
        }
    }

    // Función que trabaja con cualquier Voladora
    static void hacerVolar(Voladora v) {
        v.volar();
    }

    public static void main(String[] args) {
        Aguila aguila = new Aguila();
        Pinguino pinguino = new Pinguino();

        aguila.comer();
        pinguino.comer();

        // Solo pasamos objetos que realmente pueden volar:
        hacerVolar(aguila);

       
    }
}
