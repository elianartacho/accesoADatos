package BinariosObje.Ejer2;

import java.io.*;


public class Ejercicio2 {
    private static String directorio = "src/binariosDos/Ejer2/";
    private static String fichero = "alumnos.dat";

    public static void main(String[] args) {
        Alumno[] alumnos = {
                new Alumno("Laura", 8.5),
                new Alumno("Carlos", 6.75),
                new Alumno("Beatriz", 9.2),
                new Alumno("David", 5.0),
                new Alumno("Elena", 7.8)
        };


        try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(directorio + fichero))) {
            for (Alumno alumno : alumnos) {
                escribir.writeObject(alumno);
            }

        } catch (IOException e) {
            System.out.println("Error al escribir los objetos");
        }

        try (ObjectInputStream leer = new ObjectInputStream(new FileInputStream(directorio + fichero))) {
            for (int i = 0; i < alumnos.length; i++) {
                Alumno alumno = (Alumno) leer.readObject();
                System.out.println(alumno);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("No se encuentra la clase alumno error al leer ");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }


    }

}