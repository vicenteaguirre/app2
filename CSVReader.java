import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CSVReader{
  public static void LeerCSV (String argc){
    String linea="";
    System.out.println("gol");
    try{
      BufferedReader br = new BufferedReader(new FileReader(argc));

      while((linea=br.readLine())!= null){
        String[] columnas= linea.split(",");
        System.out.println(columnas[0]);
      }
    } catch (FileNotFoundException e){
      e.printStackTrace();
    }catch (IOException e){
      e.printStackTrace();
    }

  }
}
