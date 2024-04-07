/** Programa elaborado por Sebastian Garcia
 * @version 1.0
 * @since 2024-07-04
 * El programa esta orientado a unos documentos que brindo el profesor para la ayuda de la elaboracion de dicho programa
 */

package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Este programa traduce un archivo de texto ingresado por el usuario utilizando un diccionario.
 * El diccionario debe estar en el mismo directorio que el programa y debe tener el formato
 * "llave valor" en cada línea
 */
public class App {

    /**
     * Método principal que se ejecuta cuando se inicia la aplicación
     * @param args argumentos de entrada (no se utiliza en este programa)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

        System.out.println("Bienvenido al diccionario"); // Saludo al usuario

        System.out.println("Por favor ingrese el nombre del archivo que quiere traducir (nombreDelArchivo.txt): ");
        String nombreArchivo = sc.nextLine().trim(); // Lee la entrada del usuario y la elimina de whitespaces

        System.out.println("Por favor ingrese el nombre del diccionario que quiere utilizar (nombreDelArchivo.txt): ");
        String nombreDiccionario = sc.nextLine().trim(); // Lee la entrada del usuario y la elimina de whitespaces

        String rutaAlternaDiccionario = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\" + nombreDiccionario;

        BinaryTree<String> arbol = new BinaryTree<>(); // Crea un objeto para el árbol binario

        try (BufferedReader br = new BufferedReader(new FileReader(rutaAlternaDiccionario))) { // Lee el diccionario y lo guarda en el árbol
            String datos;
            while ((datos = br.readLine()) != null) {
                String[] opciones = datos.replaceAll("[()]", "").split("\\s+");
                if (opciones.length == 2) {
                    arbol.add(opciones[0], opciones[1]);
                }
            }
            System.out.println("Lectura del diccionario exitosa"); // Saludo cuando termina de leer el diccionario

        } catch (IOException e) { // Muestra un mensaje de error si hay problemas al leer el diccionario
            System.err.println("Error al tratar de leer el diccionario.");
            return;
        }

        String rutaAlternaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\" + nombreArchivo;

        System.out.println("El archivo " + nombreArchivo + " se está traduciendo");
        try (BufferedReader br2 = new BufferedReader(new FileReader(rutaAlternaArchivo))) { // Lee el archivo y lo traduce
            String datos;
            while ((datos = br2.readLine()) != null) {
                String[] palabras = datos.split("\\s+");
                for (String palabra : palabras) {
                    // Normaliza la palabra eliminando caracteres no alfabéticos y convirtiéndola a minúsculas
                    String ajustes = palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    // Busca la traducción de la palabra en el árbol binario
                    String traduccion = arbol.get(ajustes);
                    if (traduccion != null) {
                        // Si se encuentra la traducción, imprímela
                        System.out.print(traduccion + " ");
                    } else {
                        // Si no se encuentra la traducción, imprime la palabra original
                        System.out.print(palabra + " ");
                    }
                }
                System.out.println(); // Nueva línea después de traducir una línea completa
            }
        } catch (IOException e) { // Muestra un mensaje de error si hay problemas al leer el archivo
            System.err.println("Error al tratar de leer el documento.");
        }

    }
}


