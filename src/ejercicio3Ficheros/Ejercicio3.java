package ejercicio3Ficheros;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {


    public static void main(String[] args) {
        File  directorio= new File("copias");
        File fichero1= new File(directorio,"config.txt");
        String [] elementos= directorio.list();

         if(!directorio.exists()){
             directorio.mkdir();
             System.out.println("Directorio creado");
         }else {
             System.out.println("El directorio ya existe");
         }

         if(directorio.exists()) {
             try {
                 if(!fichero1.exists()){
                     fichero1.createNewFile();
                     System.out.println("Fichero creado");
                 }else {
                     System.out.println("El fichero ya exite");
                 }

             } catch (IOException e) {
                 System.out.println("No se creo el fichero");
             }
         }
         if(elementos!= null){
             for (String n: elementos){
                 File elemento= new File(directorio,n);
                 if(elemento.isDirectory()){
                     System.out.println("Directorio"+ n);
                 }else{
                     System.out.println("Fichero "+ n);
                 }
             }
         }
     /*    if(fichero1.delete()){
             System.out.println("Fichero eliminado");
         }else{
             System.out.println("Error al eliminar el fichero");
         }*/
         if(directorio.delete()){
             System.out.println("Directorio eliminado");
         }else{
             System.out.println("Error al eliminar el directorio");
         }
    }
}
