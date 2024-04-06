package uvg.edu.gt;

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

        
    }
}
