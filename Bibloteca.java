public class Bibloteca {
    public String matriz [][];
    public int cant_lineas;
    public String secciones[];
    public String sedes[];
    public String pisos[];
    public int cant_sec = 0;
    public int cant_sed = 0;
    public int cant_pis = 0;
    public Bibloteca(String matriz [][]){
        this.matriz = matriz;
        this.cant_lineas = this.matriz.length;
        inicializar_listas(this.matriz,this.cant_lineas);
    }
    private void inicializar_listas(String matriz [][],int cant_lineas){
        String new_secciones[] = new String[cant_lineas];
        String new_sedes[]= new String[cant_lineas];
        String new_pisos[]= new String[cant_lineas];
        int igual=0;

        for(int a =0;a< cant_lineas;a++){
            igual =0;
            if(a!=0){
                for(int b =0;b<cant_sec;b++){
                    if(new_secciones[b].equals(matriz[a][4])){
                        igual ++;
                    }
                }
                if(igual==0){
                    new_secciones[cant_sec] = matriz[a][4];
                    cant_sec++;
                }
            }
            else{
                new_secciones[a] = matriz[a][4];
                cant_sec++;
            }
        }
        for(int a =0;a< cant_lineas;a++){
            igual = 0;
            if(a!=0){
                for(int b =0;b<cant_sed;b++){
                    if(new_sedes[b].equals(matriz[a][7])){
                        igual ++;
                    }
                }
                if(igual==0){
                    new_sedes[cant_sed] = matriz[a][7];
                    cant_sed++;
                }
            }
            else{
                new_sedes[a] = matriz[a][7];
                cant_sed++;
            }
        }
        for(int a =0;a< cant_lineas;a++){
            igual=0;
            if(a!=0){
                for(int b =0;b<cant_pis;b++){
                    if(new_pisos[b].equals(matriz[a][5])){
                        igual ++;
                    }
                }
                if(igual==0){
                    new_pisos[cant_pis] = matriz[a][5];
                    cant_pis++;
                }
            }
            else{
                new_pisos[a] = matriz[a][5];
                cant_pis++;
            }
        }

        this.secciones = new_secciones;
        this.sedes = new_sedes;
        this.pisos = new_pisos;
        
    
    }
    public void imprimir_listas(){
        System.out.println("------------\nSecciones: \n");
        for(int x = 0; x<cant_sec;x++){
            System.out.println(secciones[x]);
        }
        System.out.println("------------\nSedes: \n");
        for(int x = 0; x<cant_sed;x++){
            System.out.println(sedes[x]);
        }
        System.out.println("------------\nPisos: \n");
        for(int x = 0; x<cant_pis;x++){
            System.out.println(pisos[x]);
        }
    }
    public void actualizar_bibloteca(String matriz[][]){
        this.matriz = matriz;
        this.cant_lineas = this.matriz.length; 
    }
    public void actualizar_secciones(String new_secciones[]){
        secciones = new_secciones;
        cant_sec = new_secciones.length;
    }
    public void actualizar_sedes(String new_sedes[]){
        this.sedes = new_sedes;
        cant_sed = new_sedes.length;
    }
    public void actualizar_pisos(String new_pisos[]){
        this.pisos = new_pisos;
        cant_pis = new_pisos.length;
    }
    public void imprimir_bibloteca(){
        for(int a = 0; a < cant_lineas; a++){
          for(int b = 0; b < 8; b++){
            System.out.println(matriz[a][b]+" "); 
          }
          System.out.println("\n"); 
    
        }
    
    }
    public void imprimir_libro(int pos){
        System.out.println("------------------");
        System.out.println("Titulo: "+matriz[pos][0]);
        System.out.println("Autor: "+matriz[pos][1]);
        System.out.println("Año: "+matriz[pos][2]);
        System.out.println("Numero de estante: "+matriz[pos][3]);
        System.out.println("Seccion de estante: "+matriz[pos][4]);
        System.out.println("Piso: "+matriz[pos][5]);
        System.out.println("Edificio: "+matriz[pos][6]);
        System.out.println("Sede: "+matriz[pos][7]);
        System.out.println("------------------");
    }   
}
