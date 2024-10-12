
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        double valorOriginal;
        ConversorDeMoneda conversorDeMoneda = new ConversorDeMoneda();
        //Se puede ampliar la lista de monedas a convertir
        List<String> codigosPorPais = new ArrayList<>(Arrays.asList("USD", "ARS", "BRL", "COP", "EUR"));

        String menu = """
                \n**********************************************
                   Sea Bienvenido/a al Conversor de Monedas =]
                ************************************************
                Seleccione una opción:
                 1) Dolar =>> Peso Argentino
                 2) Peso Argentino =>> Dolar
                 3) Dolar =>> Real Brasileno
                 4) Real Brasileno =>> Dolar
                 5) Dolar =>> Peso Colombiano
                 6) Peso Colombiano =>> Dolar
                 7) Dolar =>> Euro
                 8) Euro =>> Dolar
                 9) Ver Historial de Conversiones
                 10) Salir
                Elija una opcion valida:
                **********************************************
                
                """;
        while (opcion != 10) {
            System.out.println(menu);
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Ingrese el valor que desea convertir:");
                valorOriginal = sc.nextDouble();
                //evaluar si el monto es mayor a 0
                if (valorOriginal > 0) {
                    switch (opcion) {
                        case 1:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(0), codigosPorPais.get(1), valorOriginal);
                            break;
                        case 2:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(1), codigosPorPais.get(0), valorOriginal);
                            break;
                        case 3:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(0), codigosPorPais.get(2), valorOriginal);
                            break;
                        case 4:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(2), codigosPorPais.get(0), valorOriginal);
                            break;
                        case 5:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(0), codigosPorPais.get(3), valorOriginal);
                            break;
                        case 6:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(3), codigosPorPais.get(0), valorOriginal);
                            break;
                        case 7:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(0), codigosPorPais.get(4), valorOriginal);
                            break;
                        case 8:
                            conversorDeMoneda.realizandoConversionDeMoneda(codigosPorPais.get(4), codigosPorPais.get(0), valorOriginal);
                            break;
                        default:
                            System.out.println("Opcion invalida...intentelo nuevamente");


                    }
                } else System.out.println("El monto debe ser un valor mayor a 0.");


            } else if (opcion == 9) {
                List<HistorialConversor> historial = conversorDeMoneda.getHistorial();
                if (historial.isEmpty()) {
                    System.out.println("No hay conversiones en el historial.");
                } else {
                    System.out.println("Historial de conversiones:");
                    for (HistorialConversor c : historial) {
                        System.out.println(c.getFecha() + ": " + c.getMontoOriginal() + " " + c.getMonedaOrigen() + " => " + c.getMontoConvertido() + " " + c.getMonedaDestino());
                    }
                }
            }


        }
        System.out.println("Finalizando el programa...");
    }
}
