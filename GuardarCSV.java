
import java.io.*;
import java.io.IOException;
public class GuardarCSV{
  
  public static void Guardar(String matriz[][], String argc){
    try{
      FileWriter writer = new FileWriter(argc);
      writer.append("titulo,autor,anio,estante_numero,estante_seccion,piso,edificio,sede\n");
      for (int i=0;i<matriz.length;i++){
        System.out.println("Libros: "+matriz.length+"\nCant de parametros: "+matriz[i].length);
        for (int j=0;j<matriz[i].length;j++){
          writer.append(matriz[i][j]);
          if (j != matriz[i].length-1){
            writer.append(",");
          }  
          else{
            writer.append("\n");
          }
        }
      }
      writer.close();  
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}