package binariosDos;

import java.io.*;
import java.util.Scanner;

public class NumBecarios {
    private static String directorio="src/binariosDos/";
    private static String fichero="datosbeca.bin";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean fin = false;
        System.out.println("¿Cuántos becarios deseas introducir?");
        int numBecarios = Integer.parseInt(sc.nextLine());

        try(DataOutputStream escribir= new DataOutputStream(new FileOutputStream(directorio+fichero, true))){
            for (int i = 0; i < numBecarios; i++) {
                System.out.println("introduce los datos del becario;");
                System.out.println("Nombre");
                String nombre = sc.nextLine();
                System.out.println("Apellidos");
                String apellidos = sc.nextLine();
                System.out.println("Sexo:H-M");
                String sexo = sc.nextLine();
                if (!sexo.equalsIgnoreCase("H") && !sexo.equalsIgnoreCase("M")) {
                    System.out.println("Debe ser H o M.");
                }
                System.out.println("Edad (20-60):");
                int edad = Integer.parseInt(sc.nextLine());
                if (edad < 20 || edad > 60) {
                    System.out.println("La edad debe estar entre 20 y 60 años.");
                }
                System.out.println("Número de suspensos del curso anterior (0-4):");
                int suspensos = Integer.parseInt(sc.nextLine());
                if (suspensos < 0 || suspensos > 4) {
                    System.out.println("El número de suspensos debe estar entre 0 y 4.");
                }
                System.out.println("Residencia familiar (SI/NO):");
                String residencia = sc.nextLine();
                if (!residencia.equalsIgnoreCase("si") && !residencia.equalsIgnoreCase("no")) {
                    System.out.println(" Responda SI o NO.");
                }
                System.out.println("Ingresos anuales de la familia:");
                double ingresosAnuales = Double.parseDouble(sc.nextLine());
                System.out.println("Tiene beca (SI/NO):");
                String tieneBeca = sc.nextLine();
                if (!tieneBeca.equalsIgnoreCase("si") && !tieneBeca.equalsIgnoreCase("no")) {
                    System.out.println(" Responda SI o NO.");
                }

                escribir.writeUTF(nombre);
                escribir.writeUTF(apellidos);
                escribir.writeUTF(sexo);
                escribir.writeInt(edad);
                escribir.writeInt(suspensos);
                escribir.writeUTF(residencia);
                escribir.writeDouble(ingresosAnuales);
                escribir.writeUTF(tieneBeca);


                numBecarios++;

            }

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: ");
        }

        try(DataInputStream leer=new DataInputStream(new FileInputStream(directorio+fichero))) {

            while(leer.available() > 0) {
                String nombre = leer.readUTF();
                String apellidos = leer.readUTF();
                String sexo = leer.readUTF();
                int edad = leer.readInt();
                int suspensos = leer.readInt();
                String residencia = leer.readUTF();
                double ingresosAnuales = leer.readDouble();
                String tieneBeca = leer.readUTF();

                System.out.println(nombre + " " + apellidos  );
                System.out.println("Sexo " +sexo +" "+ edad + " años  ");
                System.out.println(suspensos + " suspensos - Residencia: " + residencia + " - Ingresos: " + ingresosAnuales + " - Beca: " + tieneBeca);

            }


        } catch (IOException e) {
            System.out.println("Error al leer en el fichero: ");
        }
    }
}
