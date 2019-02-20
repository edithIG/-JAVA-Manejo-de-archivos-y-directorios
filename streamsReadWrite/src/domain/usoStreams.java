package domain;

import java.io.*;
import java.nio.file.*;

public class usoStreams {
     //La variable Path crea un objeto el cual referencia a una ruta de un archivo
    static Path variablePath = Paths.get("c:/controlArchivos/miArchivo.txt");
     //Se crea la instancia y la referencia para el archivo con el que se esta trabajando
    static File varibaleFile = variablePath.toFile();
    
    
    public static void main(String args[]){
        escribeLineaEnArchivo("linea de texto");
        escribeLineaEnArchivo("linea de texto");
        leeElArchivo();
    }

    static void escribeLineaEnArchivo(String linea) {
        
        //try-with-resources
        //Esto permite escribir en un archivo
        try (PrintWriter ouputStream = new PrintWriter(
                                       new BufferedWriter(
                                       new FileWriter(varibaleFile,true)))) {
          ouputStream.println(linea);
          
        } catch (IOException e) {

        }
    }
    
    static void leeElArchivo(){
        if(Files.exists(variablePath)){
            try( BufferedReader inputStream = new BufferedReader(
                                              new FileReader(varibaleFile))){
                String linea=inputStream.readLine();
                
                while(linea!=null){//prevenir un error de IOE
                    System.out.println(linea);
                    linea=inputStream.readLine();
                }
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
