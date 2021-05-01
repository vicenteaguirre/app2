import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // CSVReader leer= new CSVReader(args[0]);
    LeerCSV(args[0]);
  }

  public static int ContarLineas(String argc) {
    String linea = "";
    int cant_lineas=0;
    try {
      BufferedReader br = new BufferedReader(new FileReader(argc));
      br.readLine();
      
      while ((linea = br.readLine()) != null) {
        cant_lineas++;
      }
    }catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return cant_lineas;
  }

  public static void LeerCSV(String argc) {
    int cant_lineas=ContarLineas(argc);
    String linea = "";
    int fila=0;
    try {
      BufferedReader br = new BufferedReader(new FileReader(argc));
      br.readLine();
      String fila_lista[] =new String[8] ;
      String matriz[][] =new String[cant_lineas][8];

      while ((linea = br.readLine()) != null) {
        String[] comas = linea.split(",");
        int y=comas.length;
        int n=0;
        int i=0;
        int cont=0;
        
        while (cont<y){
          if(i<8){
            if ((n%2)==0){
              fila_lista[i]=comas[cont];
              i++;
              
              for (int ii = 0; ii < comas[cont].length(); ii++){
                if (comas[cont].charAt(ii) == (char)34){ //char(34):comillas dobles
                  n++;
                }
              }
              cont++;
            }
            if ((n%2)==1){
              fila_lista[i-1]=fila_lista[i-1]+","+comas[cont];
              
              for (int ii = 0; ii < comas[cont].length(); ii++) {
                if (comas[cont].charAt(ii) == (char)34) {
                  n++;
                  
                }
              }
              if ((n%2)==1){

              }
                
              cont++;
            }
            
          }
          if(i>8){
            cont++;
          }
        } 
        for (int x=0; x<8;x++){
          matriz[fila][x]=fila_lista[x];
           
        }
        fila++;
      }
    System.out.println(matriz[0][1]); 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}
