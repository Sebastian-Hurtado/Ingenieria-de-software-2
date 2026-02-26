// DIP: el módulo de alto nivel depende de una abstracción (interface), no de una clase concreta.
public class DIP_Ejemplo {

    interface Database {
        void conectar();
    }

    static class MySQLDatabase implements Database {
        public void conectar() { System.out.println("Conectado a MySQL"); }
    }

    static class PostgresDatabase implements Database {
        public void conectar() { System.out.println("Conectado a Postgres"); }
    }

    static class App {
        private final Database db;

        public App(Database db) {
            this.db = db;
        }

        public void iniciar() {
            db.conectar();
            System.out.println("App iniciada");
        }
    }

    public static void main(String[] args) {
        App app1 = new App(new MySQLDatabase());
        app1.iniciar();

        App app2 = new App(new PostgresDatabase());
        app2.iniciar();
    }
}