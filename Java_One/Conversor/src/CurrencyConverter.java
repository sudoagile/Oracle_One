import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    // URL de la API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/fad62f08abf180f4b4bc97ff/latest/USD";

    public static void main(String[] args) {
        try {
            // Leer datos de la API
            String response = getApiResponse(API_URL);

            // Parsear respuesta JSON manualmente
            Map<String, Double> rates = parseRates(response);

            if (rates == null || rates.isEmpty()) {
                System.out.println("Error: No se pudo obtener tasas de cambio.");
                return;
            }

            // Mostrar todas las monedas disponibles al usuario
            System.out.println("Monedas disponibles:");
            for (String currency : rates.keySet()) {
                System.out.println("- " + currency);
            }

            // Leer moneda inicial, moneda destino y cantidad
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nIngrese la moneda de origen (por ejemplo, USD): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la moneda a convertir (por ejemplo, EUR): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Ingrese la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            // Calcular conversión
            if (rates.containsKey(fromCurrency) && rates.containsKey(toCurrency)) {
                double fromRate = rates.get(fromCurrency);
                double toRate = rates.get(toCurrency);
                double convertedAmount = amount / fromRate * toRate;
                System.out.printf("\n%.2f %s es igual a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
            } else {
                System.out.println("Error: Moneda no válida.");
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para leer datos de la API
    private static String getApiResponse(String apiUrl) throws Exception {
        StringBuilder response = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }

    // Método para parsear el JSON de tasas de cambio manualmente
    private static Map<String, Double> parseRates(String jsonResponse) {
        Map<String, Double> rates = new HashMap<>();

        try {
            // Buscar el inicio del objeto 'conversion_rates'
            int ratesIndex = jsonResponse.indexOf("\"conversion_rates\":");
            if (ratesIndex == -1) {
                return null; // No se encontró la clave 'conversion_rates'
            }

            // Extraer la parte del JSON que contiene las tasas de cambio
            int startIndex = jsonResponse.indexOf("{", ratesIndex);
            int endIndex = jsonResponse.indexOf("}", startIndex);
            String ratesContent = jsonResponse.substring(startIndex + 1, endIndex);

            // Dividir las tasas en clave-valor
            String[] pairs = ratesContent.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                if (keyValue.length == 2) {
                    String currency = keyValue[0].replaceAll("\"", "").trim();
                    Double rate = Double.parseDouble(keyValue[1].trim());
                    rates.put(currency, rate);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al parsear las tasas de cambio: " + e.getMessage());
        }

        return rates;
    }
}