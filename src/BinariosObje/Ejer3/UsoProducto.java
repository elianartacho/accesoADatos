package BinariosObje.Ejer3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsoProducto {
    private static String directorio="src/BinariosObje/Ejer3/";
    private static String fichero="productos.dat";

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ArrayList<Object>productos=new ArrayList<>();
        System.out.println("Cuantos productos quieres introducir: ");
        int cant=(int) Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cant; i++) {
            System.out.println("Introduce el nombre del producto:");
            String nombre=sc.nextLine();
            System.out.println("Introduce el precio con decimales:");
            Double precio= (double) Double.parseDouble(sc.nextLine());
            System.out.println("Introduce el stock:");
            int stock= (int)Integer.parseInt(sc.nextLine());

            Producto prod=new Producto(nombre,precio,stock);
            productos.add(i,prod);
        }


        try(ObjectOutputStream escribir=new ObjectOutputStream(new FileOutputStream(directorio+fichero))){
           for (Object producto:productos){
               escribir.writeObject(producto);
           }

        } catch (IOException e) {
            System.out.println("Error en escritura de fichero");
        }

        try(ObjectInputStream leer =new ObjectInputStream(new FileInputStream(directorio+fichero))){
            for (int i = 0; i < productos.size(); i++) {
                Producto producto= (Producto) leer.readObject();
                System.out.println(producto.toString());
            }


        } catch (IOException e) {
            System.out.println("Error en lectura de fichero");
        }catch (ClassNotFoundException e) {
            System.out.println("Error al recuperar el objeto");
        }
    }


}
