import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Método para limpiar la consola (funciona solo en terminales compatibles con ANSI)
    public static void limpiarConsola() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    // Método para esperar a que el usuario presione Enter
    public static void salto(Scanner scanner) {
        scanner.nextLine();
        System.out.flush();
    }

    // Método para obtener texto del usuario. Si no es válido, vuelve a pedirlo.
    public static String obtenerTexto(Scanner scanner) {
        try {
            String texto = scanner.next();
            return texto.trim();
        } catch (Exception e) {
            System.out.println("Debes ingresar un texto válido");
            return obtenerTexto(scanner);
        }
    }

    // Método para mostrar el menú de opciones para operaciones con arreglos (arrays)
    public static void menuArrays() {
        System.out.println("¡Bienvenido!");
        System.out.println("¿Qué operación deseas realizar?");
        System.out.println("1. Mostrar los números ingresados.");
        System.out.println("2. Sumar todos los números.");
        System.out.println("3. Mostrar el número mayor y menor.");
        System.out.println("4. Mostrar el orden invertido de los números");
        System.out.println("5. Salir");
    }

    // Método para obtener un número entero del usuario. Si no es válido, vuelve a pedirlo.
    public static int obtenerNumero(Scanner scanner) {
        try {
            int numero = scanner.nextInt();
            String formateo = String.valueOf(numero).trim();
            return Integer.parseInt(formateo);
        } catch (Exception e) {
            System.out.println("Debes ingresar un número entero");
            scanner.next();  // Limpiar el buffer
            return obtenerNumero(scanner);
        }
    }

    // Método para solicitar 10 números al usuario y guardarlos en un arreglo de enteros
    public static int[] solicitudNumeros(Scanner scanner) {
        System.out.println("¡Bienvenido!");
        System.out.println("Antes de iniciar debes ingresar un total de 10 números");
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingresa el número " + (i + 1));
            numeros[i] = obtenerNumero(scanner);  // Llamada al método obtenerNumero para obtener cada número
        }
        return numeros;  // Retorna el arreglo con los números ingresados
    }

    // Método para imprimir los números de un arreglo
    public static void imprimirNumeros(int[] numeros) {
        System.out.println("Los números ingresados son:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }

    // Método para calcular y retornar la suma de los números en el arreglo
    public static int sumatoria(int[] numeros) {
        try {
            int sumatoria = 0;
            for (int i = 0; i < numeros.length; i++) {
                sumatoria += numeros[i];  // Suma los números del arreglo
            }
            return sumatoria;  // Retorna la suma total
        } catch (Exception e) {
            System.out.println("Ocurrió un error al sumar los números");
            return 0;  // Retorna 0 en caso de error
        }
    }

    // Método para mostrar el número mayor y menor del arreglo
    public static void mayorMenor(int[] numeros) {
        try {
            int mayor = numeros[0];
            int menor = numeros[0];
            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] > mayor) {
                    mayor = numeros[i];  // Actualiza el número mayor
                }
                if (numeros[i] < menor) {
                    menor = numeros[i];  // Actualiza el número menor
                }
            }
            System.out.println("El número mayor es: " + mayor);
            System.out.println("El número menor es: " + menor);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al encontrar el número mayor y menor del arreglo.");
        }
    }

    // Método para invertir el orden de los números en el arreglo e imprimirlo
    public static void invertirOrden(int[] numeros) {
        try {
            System.out.println("Los números en orden invertido son: ");
            int value = numeros.length - 1;

            for (int i = value; i >= 0; i--) {
                System.out.print(numeros[i] + " ");  // Imprime el número en orden inverso
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Ocurrió un error al invertir el orden de los números");
        }
    }

    // Método principal que gestiona la aplicación de Arrays
    public static void appArray(Scanner scanner) {
        try {
            limpiarConsola();
            int[] numeros = solicitudNumeros(scanner);  // Llamada para obtener los 10 números
            limpiarConsola();
            menuArrays();  // Muestra el menú de opciones de Arrays
            int opcion = 0;
            do {
                System.out.println("Selecciona una opción");
                opcion = obtenerNumero(scanner);  // Obtiene la opción del usuario
                switch (opcion) {
                    case 1:
                        imprimirNumeros(numeros);  // Muestra los números
                        salto(scanner);  // Espera que el usuario presione Enter
                        break;
                    case 2:
                        int sumatoria = sumatoria(numeros);  // Calcula la suma de los números
                        System.out.println("La suma de los números es de " + sumatoria);
                        salto(scanner);
                        break;
                    case 3:
                        mayorMenor(numeros);  // Muestra el número mayor y menor
                        salto(scanner);
                        break;
                    case 4:
                        invertirOrden(numeros);  // Muestra los números en orden invertido
                        salto(scanner);
                        break;
                    default:
                        break;
                }
            } while (opcion != 5);  // Sale del bucle si se selecciona la opción 5
        } catch (Exception e) {
            System.out.println("Ocurrió un error al ejecutar la aplicación");
        }
    }

    // Método para mostrar el menú de opciones para operaciones con ArrayList
    public static void menuArrayList() {
        System.out.println("¡Bienvenido!");
        System.out.println("¿Qué operación deseas realizar?");
        System.out.println("1. Agregar producto a la lista.");
        System.out.println("2. Mostrar lista de compras.");
        System.out.println("3. Eliminar producto de la lista.");
        System.out.println("4. Buscar producto en la lista.");
        System.out.println("5. Ordenar lista alfabéticamente");
        System.out.println("6. Salir.");
    }

    // Método para agregar un producto a la lista de compras
    public static ArrayList<String> agregarProducto(Scanner scanner, ArrayList<String> listaCompras) {
        try {
            System.out.println("Ingrese el nombre del producto que desea agregar.");
            String producto = obtenerTexto(scanner);  // Obtiene el nombre del producto
            scanner.nextLine();
            listaCompras.add(producto);  // Añade el producto a la lista
            return listaCompras;  // Retorna la lista actualizada
        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar un producto a la lista de compra.");
            return agregarProducto(scanner, listaCompras);  // Vuelve a intentar si hay error
        }
    }

    // Método para imprimir la lista de compras
    public static void imprimirlistaCompras(ArrayList<String> listaCompras) {
        try {
            System.out.println("Lista de compras: ");
            if (listaCompras.isEmpty() || listaCompras.size() == 0) {
                System.out.println("No hay productos en la lista de compras.");
                return;  // Si la lista está vacía, muestra un mensaje y termina el método
            }
            for (int i = 0; i < listaCompras.size(); i++) {
                System.out.println((i + 1) + ". " + listaCompras.get(i));  // Imprime la lista con los productos
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar la lista de compras.");
        }
    }

    // Método para eliminar un producto de la lista de compras
    public static void eliminarProducto(Scanner scanner, ArrayList<String> listaCompras) {
        try {
            System.out.println("Ingrese el nombre del producto que desea eliminar.");
            String producto = obtenerTexto(scanner);  // Obtiene el nombre del producto
            boolean encontrado = false;
            for (int i = 0; i < listaCompras.size(); i++) {
                String productoActual = listaCompras.get(i);
                if (productoActual.equalsIgnoreCase(producto)) {
                    encontrado = true;
                    listaCompras.remove(i);  // Elimina el producto de la lista
                    break;
                }
            }
            if (encontrado) {
                System.out.println("El producto " + producto + " ha sido eliminado de la lista de compras.");
            } else {
                System.out.println("El producto " + producto + " no se encuentra en la lista de compras.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al eliminar el producto de la lista de compras.");
            eliminarProducto(scanner, listaCompras);  // Vuelve a intentar si hay error
        }
    }

    // Método para buscar un producto en la lista de compras
    public static void busquedaProducto(Scanner scanner, ArrayList<String> listaCompras) {
        try {
            String producto = obtenerTexto(scanner);  // Obtiene el nombre del producto
            boolean encontrado = false;
            for (int i = 0; i < listaCompras.size(); i++) {
                String productoActual = listaCompras.get(i);
                if (productoActual.equalsIgnoreCase(producto)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("El producto " + producto + " se encuentra en la lista de compras.");
            } else {
                System.out.println("El producto " + producto + " no se encuentra en la lista de compras.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar el producto en la lista.");
        }
    }

    // Método para ordenar la lista de productos alfabéticamente
    public static void ordenarLista(ArrayList<String> listaCompras) {
        try {
            listaCompras.sort(String::compareToIgnoreCase);  // Ordena alfabéticamente
            imprimirlistaCompras(listaCompras);  // Imprime la lista ordenada
        } catch (Exception e) {
            System.out.println("Ocurrió un error al ordenar la lista de compras.");
        }
    }

    // Método principal que gestiona la aplicación de ArrayList
    public static void appArrayList(Scanner scanner) {
        try {
            ArrayList<String> listaProductos = new ArrayList<String>();
            limpiarConsola();
            menuArrayList();  // Muestra el menú de opciones de ArrayList
            int opcion = 0;
            do {
                System.out.println("Selecciona una opción");
                opcion = obtenerNumero(scanner);  // Obtiene la opción del usuario
                switch (opcion) {
                    case 1:
                        listaProductos = agregarProducto(scanner, listaProductos);  // Agrega un producto
                        break;
                    case 2:
                        imprimirlistaCompras(listaProductos);  // Muestra la lista de productos
                        salto(scanner);
                        break;
                    case 3:
                        eliminarProducto(scanner, listaProductos);  // Elimina un producto
                        salto(scanner);
                        break;
                    case 4:
                        System.out.println("Ingrese el nombre del producto que desea buscar en la lista.");
                        busquedaProducto(scanner, listaProductos);  // Busca un producto
                        salto(scanner);
                        break;
                    case 5:
                        ordenarLista(listaProductos);  // Ordena la lista de productos
                        salto(scanner);
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }
            } while (opcion != 6);  // Sale del bucle si se selecciona la opción 6
        } catch (Exception e) {
            System.out.println("Ocurrió un error al ejecutar la aplicación");
        }
    }

    // Método principal que gestiona la aplicación y permite elegir entre diferentes funcionalidades
    public static void app(Scanner scanner) {
        int opcion = 0;
        do {
            limpiarConsola();
            System.out.println("¿Qué aplicación deseas ejecutar?");
            System.out.println("1. Aplicación de Arrays");
            System.out.println("2. Aplicación de ArrayList");
            System.out.println("3. Salir");
            opcion = obtenerNumero(scanner);  // Obtiene la opción del usuario
            switch (opcion) {
                case 1:
                    appArray(scanner);  // Llama a la aplicación de arrays
                    break;
                case 2:
                    appArrayList(scanner);  // Llama a la aplicación de array list
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (opcion != 3);  // Sale del bucle si se selecciona la opción 3
        scanner.close();
    }

    // Método principal que inicia la ejecución de la aplicación
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        app(scanner);  // Llama al método app para iniciar la aplicación
    }
}
