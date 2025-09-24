package custompackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* El programa vuelca byte por byte el contenido de un archivo en otro.
* Ambos archivos se pasan como argumentos al programa (en orden, primero el que se lee y luego el que se crea).
* TODO: implementar concurrencia para que el programa sea más eficiente.
* */

public class Launcher {

    public static void main(String[] args) {

        if (args.length == 2) {
            try {
                FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\" + args[0]);
                FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") +  "\\" + args[1]);
                int buffer;
                while ((buffer = fis.read()) != -1) {
                    fos.write(buffer);
                }
                fis.close();
                fos.close();
                System.out.println("Copia finalizada del archivo <" + args[0] + "> en <" + args[1] + ">");
            } catch (IOException e) {
                System.err.println("Problema de entrada-salida: " + e.getMessage());
            }
        } else {
            System.out.println("Debes proporcionar dos parámetros: fichero de entrada y fichero de salida.");
        }
    }


}
