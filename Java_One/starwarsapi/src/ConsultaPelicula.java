import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException; // Para capturar errores de Gson

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Ya no se necesita: import static jdk.internal.classfile.Classfile.build;

public class ConsultaPelicula {

    Pelicula buscaPelicula(int numeroDePelicula) {
        // Considera usar https y la API más actualizada si encuentras problemas
        // URI direccion = URI.create("https://swapi.dev/api/films/" + numeroDePelicula + "/");
        URI direccion = URI.create("http://swapi.py4e.com/api/films/" + numeroDePelicula + "/"); // Añadida / al final

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() == 200) {
                try {
                    // Deserializar solo si el código es 200
                    return new Gson().fromJson(response.body(), Pelicula.class);
                } catch (JsonSyntaxException e) {
                    System.err.println("Error al parsear el JSON de la respuesta: " + e.getMessage());
                    System.err.println("Cuerpo recibido: " + response.body());
                    // Puedes optar por lanzar una excepción personalizada o devolver null
                    return null;
                }
            } else {
                System.err.println("Error en la API. Código de estado: " + response.statusCode());
                System.err.println("Cuerpo de la respuesta: " + response.body());
                // La película no se encontró o hubo otro error de la API
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error de conexión o interrupción: " + e.getMessage());
            // En lugar de RuntimeException, podrías devolver null para que el llamador lo maneje
            // throw new RuntimeException(e);
            return null;
        }
    }
}