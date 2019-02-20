package usoarchivos;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivos {

    public static void main(String args[]) {
        try {
           // creaDirectorio("c:/controlArchivos");
           // creaDirectorio("c:/controlArchivos/subdirectorio");
           // creaArchivo("c:/controlArchivos/archivo.txt");
           // creaArchivo("c:/controlArchivos/subdirectorio/archivo1.txt");
           // muestraInfoArchivo("c:/controlArchivos/subdirectorio/archivo1.txt");
           //  muetsraArchivosDeDirectorio("c:/controlArchivos");
          // borraArchivoDirectorio("c:/controlArchivos/subdirectorio/archivo.txt");
          // borraArchivoDirectorio("c:/controlArchivos/subdirectorio");
           // copiaArchivo("c:/controlArchivos/archivo.txt", "c:/controlArchivos/subdirectorio/archivo.txt");
            mueveArchivo("c:/controlArchivos/archivo.txt", "c:/controlArchivos/subdirectorio/archivoMovido.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Metodo para crear un directorio

    static void creaDirectorio(String directorio) throws IOException {
        Path dirPath = Paths.get(directorio);
        if (Files.notExists(dirPath)) {
            Files.createDirectories(dirPath);
        }
    }

    //metodo que crea un archivo
    static void creaArchivo(String rutaArchivo) throws IOException {
        Path dirPath = Paths.get(rutaArchivo);
        if (Files.notExists(dirPath)) {
            Files.createFile(dirPath);
        }
    }

    //metdo que muestra informacion de un archivo
    static void muestraInfoArchivo(String rutaArchivo) throws IOException {
        Path dirFile = Paths.get(rutaArchivo);
        System.out.println("Nombre del archivo: " + dirFile.getFileName());
        System.out.println("Ruta absoluta: " + dirFile.toAbsolutePath());
        System.out.println("El archivo es rescribible? : " + Files.isWritable(dirFile));
        System.out.println("Que tamaño tiene el archivo: " + Files.size(dirFile));

    }
    
    static void muetsraArchivosDeDirectorio(String directorio) throws IOException{
        Path dirFile = Paths.get(directorio);
        if(Files.exists(dirFile) && Files.isDirectory(dirFile) ){
            System.out.println("Directrorio: " + dirFile.toAbsolutePath()); 
            System.out.println("Archivos: ");
            
            DirectoryStream<Path> diStream= Files.newDirectoryStream(dirFile);
            
            //recorre el arreglo diStream de los elementos que trae
            for (Path path : diStream) {
                if(Files.isRegularFile(path)){
                    System.out.println("   " + path.getFileName() );
                }
                
            }
        }
    }
    
    //borrar un  archivo o un directorio
    static void borraArchivoDirectorio(String directorioArchivo) throws IOException{
        Path dirFile = Paths.get(directorioArchivo);
        if(Files.exists(dirFile) && Files.isDirectory(dirFile)){
            Files.delete(dirFile);
            
        }else{
          Path filePath = Paths.get(directorioArchivo); 
          if(Files.exists(filePath) && Files.isRegularFile(filePath)){
              Files.delete(filePath);
          }
        }
    }
    
    //copiar un archivo de un origen a un destino
    static void copiaArchivo(String origen, String destino) throws IOException{
        Path filePathO = Paths.get(origen);
        Path filePathD = Paths.get(destino);
        
        Files.copy(filePathO, filePathD);
    }
    
    //mover un archivo de una ruta hacia otra 
    static void mueveArchivo(String origen, String destino) throws IOException{
     Path filePathO = Paths.get(origen);
        Path filePathD = Paths.get(destino);
        
        Files.move(filePathO, filePathD);
}
}
