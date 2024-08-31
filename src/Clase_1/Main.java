package Clase_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        try (Scanner scanner = new Scanner(System.in)) {
            Clase1 taller = new Clase1();
            int opcion;
            
            do {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Imprimir nombres");
                System.out.println("2. Buscar nombre");
                System.out.println("3. Agregar nombre");
                System.out.println("4. Eliminar nombre");
                System.out.println("5. Imprimir tareas");
                System.out.println("6. Agregar tarea");
                System.out.println("7. Eliminar tarea");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                
                switch (opcion) {
                    case 1 -> {
                        System.out.println("\nNombres en la lista:");
                        taller.imprimirNombres();
                    }
                        
                    case 2 -> {
                        System.out.print("Ingrese el nombre a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        taller.buscarNombre(nombreBuscar);
                    }
                        
                    case 3 -> {
                        System.out.print("Ingrese el nombre a agregar: ");
                        String nombreAgregar = scanner.nextLine();
                        taller.agregarNombre(nombreAgregar);
                    }
                        
                    case 4 -> {
                        System.out.print("Ingrese el nombre a eliminar: ");
                        String nombreEliminar = scanner.nextLine();
                        taller.eliminarNombre(nombreEliminar);
                    }
                        
                    case 5 -> {
                        System.out.println("\nTareas en la lista:");
                        taller.imprimirTareas();
                    }
                        
                    case 6 -> {
                        System.out.print("Ingrese la tarea a agregar: ");
                        String tareaAgregar = scanner.nextLine();
                        taller.agregarTarea(tareaAgregar);
                    }
                        
                    case 7 -> {
                        System.out.print("Ingrese la tarea a eliminar: ");
                        String tareaEliminar = scanner.nextLine();
                        taller.eliminarTarea(tareaEliminar);
                    }
                        
                    case 8 -> System.out.println("Saliendo...");
                        
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 8);
        }
    }

}
