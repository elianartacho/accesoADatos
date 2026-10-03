package binarios.vehiculo;

import java.io.*;
import java.util.Scanner;

public class UsoVehiculo {
    private static String directorio= "src/binarios/vehiculo";
    private static String fichero="listavehiculos.dat";
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Cuantos coches quieres introducir en el fichero");
        int cant;
        cant=Integer.parseInt(sc.nextLine());

        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(directorio+fichero,true))) {
          int i=1;
            if(i<cant){
                System.out.println("Escribe la matricula");
                String matricula= sc.nextLine();
                escribir.writeUTF(matricula);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
