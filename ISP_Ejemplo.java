// ISP: mejor varias interfaces pequeñas que una grande.
public class ISP_Ejemplo {

    interface Workable {
        void trabajar();
    }

    interface Eatable {
        void comer();
    }

    static class Empleado implements Workable, Eatable {
        public void trabajar() { System.out.println("Empleado trabajando"); }
        public void comer() { System.out.println("Empleado comiendo"); }
    }

    static class Robot implements Workable {
        public void trabajar() { System.out.println("Robot trabajando"); }
        // No tiene sentido obligarlo a implementar comer().
    }

    public static void main(String[] args) {
        Workable w1 = new Empleado();
        Workable w2 = new Robot();

        w1.trabajar();
        w2.trabajar();

        Eatable e1 = new Empleado();
        e1.comer();
    }
}