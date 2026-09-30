package binarios;

import java.io.*;
import java.util.Scanner;

public class BinariosDos {
    private static String directorio= "src/binarios/";
    private static String fichero="registro.dat";
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce un nombre");
        String nombre= sc.nextLine();
        System.out.println("Introduce la edad");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce la nota media");
        double nota = Double.parseDouble(sc.nextLine());

        try(DataOutputStream escribir= new DataOutputStream(new FileOutputStream(directorio+fichero))){
            escribir.writeUTF(nombre);
            escribir.writeInt(edad);
            escribir.writeDouble(nota);
            System.out.println("El fichero se escribio correctamente");
        }catch (IOException e){
            System.out.println("Error al escribir el fichero");
        }

        try(DataInputStream leer= new DataInputStream(new FileInputStream(directorio+fichero))){
            nombre= leer.readUTF();
            edad= leer.readInt();
            nota= leer.readDouble();
            System.out.println("el fichero se lee correctamente");

        }catch (IOException e){
            System.out.println("Error al leer el fichero");
        }
    }
}
