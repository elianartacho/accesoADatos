package binariosDos.vehiculo;

import java.io.*;
import java.util.Scanner;

public class UsoVehiculo {
    private static String directorio= "src/binariosDos/vehiculo/";
    private static String fichero="listavehiculos.dat";
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Cuantos coches quieres introducir en el fichero");
        int cant;
        cant=Integer.parseInt(sc.nextLine());

        try(DataOutputStream escribir=new DataOutputStream(new FileOutputStream(directorio+fichero,true))) {
          int i=1;

            while (i<=cant){
                System.out.println("Escribe la matricula");
                String matricula= sc.nextLine();
                escribir.writeUTF(matricula);

                System.out.println("Marca vehículo ");
                String marca = sc.nextLine();
                escribir.writeUTF(marca);

                System.out.println("Modelo vehículo ");
                String modelo = sc.nextLine();
                escribir.writeUTF(modelo);

                System.out.println("Depósito vehículo ");
                double deposito = Double.parseDouble(sc.nextLine());
                escribir.writeDouble(deposito);
                i++;
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream leeFichero = new DataInputStream(new FileInputStream(directorio+fichero))) {

            while (true)  { // Finaliza cuando se alcanza el final del fichero y se produce una EOFException.
                String matricula = leeFichero.readUTF();
                String marca = leeFichero.readUTF();
                String modelo = leeFichero.readUTF();
                double deposito = leeFichero.readDouble();

                // Mostrar los datos en una sola línea
                System.out.println( matricula + " | " + marca + " | " + deposito + " | " + modelo);
            }

        } catch (EOFException e) {
            System.out.println("Fin de fichero.");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }

        sc.close();

    }
}
