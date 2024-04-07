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
        String rutaAlterna = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\"+diccionario;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaAlterna))){
            String linea; 

        }catch (IOException e){
            System.err.println("Error al leer los archivos.");
        }

        String rutaAlterna = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\"+nombre;

        System.out.println("El archivo " + nombre + " se esta traduciendo");
        try (BufferedReader br2 = new BufferedReader(new FileReader(rutaAlterna))){
            String linea; 
            while ((linea = br2.readLine()) != null) 
            {
                String[] palabras = linea.split("\\s+");
                System.out.println(palabras);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error al leer el archivo...");;
        }
    }
}
