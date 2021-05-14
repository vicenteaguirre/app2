import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CSVReader{
  public static String[][] LeerCSV(String argc){
    //Datos_no_asociados(argc);
    int cant_lineas = ContarLineas(argc);
    String linea = "";
    int fila=0;
    String matriz[][] =new String[cant_lineas][8]; //Donde se va a guardar la informacion 
    try {
      BufferedReader br = new BufferedReader(new FileReader(argc));
      br.readLine(); //Lee los titulos de las columnas
      String fila_lista[] =new String[8]; //Se va guardando la linea leida
      while ((linea = br.readLine()) != null) {
        // En linea se almacena la linea leida, es decir el nombre, autor, año ,etc.
        String[] comas = linea.split(","); // Se guarda la info hasta la coma (Es una matriz con informacion hasta la coma.)    
        //creamos los contadores para ayudarnos
        int cant_comas=comas.length;
        int cant_comillas=0;
        int cant_columnas=0;
        int contador_comas=0;

        while (contador_comas<cant_comas){
          if(cant_columnas<8){
            if ((cant_comillas%2)==0){
              fila_lista[cant_columnas]=comas[contador_comas];
              cant_columnas++;
              
              for (int ii = 0; ii < comas[contador_comas].length(); ii++){
                if (comas[contador_comas].charAt(ii) == (char)34){ //char(34):comillas dobles
                  cant_comillas++;
                }
              }
              contador_comas++;
            }
            if ((cant_comillas%2)==1){
              fila_lista[cant_columnas-1]=fila_lista[cant_columnas-1]+","+comas[contador_comas];
              
              for (int ii = 0; ii < comas[contador_comas].length(); ii++) {
                if (comas[contador_comas].charAt(ii) == (char)34) {
                  cant_comillas++;
                  
                }
              }
            
              contador_comas++;
            }
            
          }
          
          if(cant_columnas>8){
            contador_comas++;
          }
          
        }
        for (int x=0; x<8;x++){
          matriz[fila][x]=fila_lista[x];
        }
        fila++;
      }
    br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return matriz;
  }

  public static void Datos_no_asociados(String argc){
    int cant_lineas = ContarLineas(argc);
    String linea_no_asociados = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(argc));
      br.readLine();
      int cant_virg=0;
      
      while ((linea_no_asociados = br.readLine()) != null) {
        String[] separador_virg = linea_no_asociados.split("~"); //separa lineas en virgulillas
        if (separador_virg[0].charAt(0) == '.'){ //reconoce la fila de datos no asociados
          cant_virg++;
        }
        if (cant_virg==1){
          String[] separador_comas = separador_virg[1].split(",");
          String[] seccion=new String[separador_comas.length-1];
          for(int i=0;i<separador_comas.length;i++){
            seccion[i]=separador_comas[i];
          }
          cant_virg++;
        }
        if (cant_virg==2){
          String[] separador_comas = separador_virg[2].split(",");
          String[] piso=new String[separador_comas.length-1];
          for(int i=0;i<separador_comas.length;i++){
            piso[i]=separador_comas[i];
          }
          cant_virg++;
        }
        if (cant_virg==3){
          String[] separador_comas = separador_virg[3].split(",");
          String[] edificio=new String[separador_comas.length-1];
          for(int i=0;i<separador_comas.length;i++){
            edificio[i]=separador_comas[i];
          }
          cant_virg++;
        }
        if (cant_virg==4){
          String[] separador_comas = separador_virg[4].split(",");
          String[] sede=new String[separador_comas.length-1];
          for(int i=0;i<separador_comas.length;i++){
            sede[i]=separador_comas[i];
          }
          cant_virg++;
        }
      }
     
      br.close();
      }catch (FileNotFoundException e) {
      e.printStackTrace();
      } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int ContarLineas(String argc) {
    String linea = "";
    int cant_lineas=0;
    try {
      BufferedReader br = new BufferedReader(new FileReader(argc));
      br.readLine();
      
      while ((linea = br.readLine()) != null) {
        cant_lineas++;
        String[] slash= linea.split(",");
        if (slash[0]== "~"){ //no cuenta la ultima linea, ya que no tendra libros, si no que info.
          cant_lineas--;
        }

      }br.close();
    }catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //System.out.println("Cantidad de lineas: "+cant_lineas);

    
    return cant_lineas;
  }

}
