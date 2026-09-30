package binarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinariosUno {
    private static String fichero="src/binarios/numerosBinarios.dat";

    public static void main(String[] args) {

        try(FileOutputStream escribir= new FileOutputStream(fichero)){
            for (int i = 0; i < 100; i++) {
                escribir.write(i);
            }

        }catch (IOException e){
            System.out.println("Error al escribir el fichero");
        }

        try(FileInputStream leer = new FileInputStream(fichero)){
            int dato;
            while ((dato= leer.read())!= -1){
                System.out.println(dato);
            }
        }catch (IOException e){
            System.out.println("Error al leer el archivo");
        }
    }
}
