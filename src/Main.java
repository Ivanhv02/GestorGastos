import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Gasto> gastos = new ArrayList<>();

    int opcion;

    do {
      System.out.println("\n===== GESTOR DE GASTOS =====");
      System.out.println("1. Añadir gasto");
      System.out.println("2. Mostrar todos los gastos");
      System.out.println("3. Mostrar total gastado");
      System.out.println("4. Salir");
      System.out.print("Elige una opción: ");

      while (!teclado.hasNextInt()) {
        System.out.println("Error: introduce un número.");
        teclado.next();
        System.out.print("Elige una opción: ");
      }

      opcion = teclado.nextInt();
      teclado.nextLine();

      switch (opcion) {

        case 1:
          System.out.print("Introduce el concepto: ");
          String concepto = teclado.nextLine();

          System.out.print("Introduce el importe: ");

          while (!teclado.hasNextDouble()) {
            System.out.println("Error: introduce un importe válido.");
            teclado.next();
            System.out.print("Introduce el importe: ");
          }

          double importe = teclado.nextDouble();
          teclado.nextLine();

          if (importe <= 0) {
            System.out.println("Error: el importe debe ser mayor que cero.");
            break;
          }

          System.out.print("Introduce la categoría: ");
          String categoria = teclado.nextLine();

          Gasto gasto = new Gasto(concepto, importe, categoria);
          gastos.add(gasto);

          System.out.println("Gasto añadido correctamente.");
          break;

        case 2:
          if (gastos.isEmpty()) {
            System.out.println("No hay gastos registrados.");
          } else {
            System.out.println("\n===== LISTA DE GASTOS =====");

            for (int i = 0; i < gastos.size(); i++) {
              Gasto gastoActual = gastos.get(i);

              System.out.println(
                      (i + 1) + ". " +
                              gastoActual.getConcepto() + " - " +
                              gastoActual.getImporte() + " € - " +
                              gastoActual.getCategoria()
              );
            }
          }
          break;

        case 3:
          double total = 0;

          for (Gasto gastoActual : gastos) {
            total += gastoActual.getImporte();
          }

          System.out.printf("Total gastado: %.2f €%n", total);
          break;

        case 4:
          System.out.println("Cerrando gestor de gastos...");
          break;

        default:
          System.out.println("Opción no válida.");
      }

    } while (opcion != 4);

    teclado.close();
  }
}
