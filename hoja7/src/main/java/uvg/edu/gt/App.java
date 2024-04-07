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
        
        
        BinaryTree<Association<String, String>> arbol = new BinaryTree<Association<String, String>>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaAlternaDiccionario))){
            String datos;
            while ((datos = br.readLine()) != null){
                String[] opciones = datos.replaceAll("[()]", "").split("\\s+");
                if(opciones.length == 2){
                    arbol.add(new Association<>(opciones[0], opciones[1]));
                }
            } 
            System.out.println("Lectura del diccionario exitosa");

        }catch (IOException e){
            System.err.println("Error al tratar de leer los archivos.");
        }








        String rutaAlternaArchivo = "C:\\Users\\sebas\\OneDrive\\Escritorio\\HojaDeTrabajo7\\hoja7\\src\\main\\java\\uvg\\edu\\gt\\"+nombre;



        System.out.println("El archivo " + nombre + " se esta traduciendo");
        try (BufferedReader br2 = new BufferedReader(new FileReader(rutaAlternaArchivo))){
            String datos; 
            while ((datos = br2.readLine()) != null) 
            {
                String[] palabras = datos.split("\\s+");
                //System.out.println(palabras);
                for(String palabra:palabras){
                    String ajustes = palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    Association<String,String> busqueda = arbol.toString(new Association<>(ajustes, ""));
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Error al tratar de leer el documento.");;
        }
    }
}
