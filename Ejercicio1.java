package BinariosObje;

import java.io.*;

public class Ejercicio1 {
    private static String directorio= "src/binariosObje/";
    private static String fichero="numeros.dat";

    public static void main(String[] args)  {

        try(DataOutputStream escribir= new DataOutputStream(new FileOutputStream(directorio+fichero))){
            for (int i = 0; i <= 50; i++) {
                escribir.write(i);
            }

        }catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }

        try(DataInputStream leer = new DataInputStream((new FileInputStream(directorio+fichero)))){
            int dato;
            while((dato= leer.read())!= -1){
                System.out.println(dato);
            }

        }catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

}
