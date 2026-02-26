// OCP: puedes agregar nuevos descuentos sin modificar la calculadora.
public class OCP_Ejemplo {

    interface Descuento {
        double aplicar(double precio);
    }

    static class DescuentoEstudiante implements Descuento {
        public double aplicar(double precio) { return precio * 0.90; }
    }

    static class DescuentoNavidad implements Descuento {
        public double aplicar(double precio) { return precio * 0.80; }
    }

    static class CalculadoraDescuento {
        public double calcular(double precio, Descuento descuento) {
            return descuento.aplicar(precio);
        }
    }

    public static void main(String[] args) {
        double precio = 200_000;

        CalculadoraDescuento calc = new CalculadoraDescuento();
        System.out.println("Estudiante: " + calc.calcular(precio, new DescuentoEstudiante()));
        System.out.println("Navidad: " + calc.calcular(precio, new DescuentoNavidad()));

        // Si mañana quieres DescuentoVIP, solo creas otra clase que implemente Descuento.
    }
}