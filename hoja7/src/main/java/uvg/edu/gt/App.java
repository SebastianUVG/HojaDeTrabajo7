package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        //boolean badera = true; 

        
        System.out.println("Bienvenido al diccionario");
        System.out.println("Por favor ingrese el nombre del archivo que quiere traducir (nombreDelArchivo.txt): ");
        String nombre = sc.nextLine().trim();
        System.out.println("Por favor ingrese el nombre del diccionario que quiere utilizar(nombreDelArchivo.txt): ");
        String diccionario = sc.nextLine().trim();
        String rutaAlternaDiccionario = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\"+diccionario;
        
        
        BinaryTree<String> arbol = new BinaryTree<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaAlternaDiccionario))){
            String datos;
            while ((datos = br.readLine()) != null){
                String[] opciones = datos.replaceAll("[()]", "").split("\\s+");
                if(opciones.length == 2){
                    arbol.add(opciones[0], opciones[1]);
                }
            } 
            System.out.println("Lectura del diccionario exitosa");

        }catch (IOException e){
            System.err.println("Error al tratar de leer los archivos.");
            return;
        }








        String rutaAlternaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\"+nombre;



        System.out.println("El archivo " + nombre + " se está traduciendo");
try (BufferedReader br2 = new BufferedReader(new FileReader(rutaAlternaArchivo))){
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
                System.out.print(traduccion+ " ");
            } else {
                // Si no se encuentra la traducción, imprime la palabra original
                System.out.print(palabra + " ");
            }
        }
        System.out.println(); // Nueva línea después de traducir una línea completa
    }
} catch (IOException e) {
    System.err.println("Error al tratar de leer el documento.");
}

    }
}
