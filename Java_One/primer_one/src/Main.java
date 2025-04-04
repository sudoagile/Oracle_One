public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula= 8.2;

        double media = (8.2 + 6.0 + 9.0) /3;
        System.out.println(media);

        String sinopsis = """
                Matrix es una paradoja
                La mejor película del fin del milenio
                Fué lanzada en:
                """ + fechaDeLanzamiento;

        System.out.println(sinopsis);

        int clasificacion = (int) (media/2);
        System.out.println(clasificacion);

        String saludo = "Hola, mi nombre es ";
        String nombre = "Alicia ";
        String continuacion = "y mi edad es ";
        int edad = 17;

        System.out.println(saludo + nombre + continuacion + edad);
                
        
        
            }
        }