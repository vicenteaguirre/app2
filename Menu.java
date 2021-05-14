import java.util.Scanner; 

public class Menu {
  boolean exit;

  /* Auxliares */
  private int getInput(){
    Scanner kb = new Scanner(System.in);
    int choice = 0;
    while(choice < 1 || choice >5){
      try{
        System.out.print("\nIngresa tu selección: ");
        choice = Integer.parseInt(kb.nextLine());
        if(choice > 5){
          System.out.println("\nSelección invalida. Por favor intentalo nuevamente.");
        }
        if(choice < 1){
          System.out.println("\nSelección invalida. Por favor intentalo nuevamente.");
        }
      }
      catch(NumberFormatException e){
        System.out.println("\nSelección invalida. Por favor intentalo nuevamente.");
      }
    }
    return choice;
  }
  private String getInputStr(){
    Scanner leer = new Scanner(System.in);
    String texto = leer.nextLine();
    return texto;
  } 
  private void printHeader(){
    System.out.println("+---------------------------------------------+");
    System.out.println("|               Bienvenido a la               |");
    System.out.println("|             Biblioteca  virtual             |");
    System.out.println("+---------------------------------------------+");
  }
  private void printMenu(){
    System.out.println("");
    System.out.println("¿Qué decea hacer?");
    System.out.println("Seleccione una opción:");
    System.out.println("");
    System.out.println("1) Agregar elemento.");
    System.out.println("2) Quitar elemento.");
    System.out.println("3) Editar elemento.");
    System.out.println("4) Buscar un libro.");
    System.out.println("5) Salir.");
  }
  private void printAddElement(){
    System.out.println("");
    System.out.println("¿Qué decea agregar?");
    System.out.println("Seleccione una opción:");
    System.out.println("");
    System.out.println("1) Agregar un libro.");
    System.out.println("2) Agregar una sede.");
    System.out.println("3) Agregar una sección.");
    System.out.println("4) Agregar un piso.");
    System.out.println("5) Salir.");
  }
  private void printRemoveElement(){
    System.out.println("");
    System.out.println("¿Qué decea quitar?");
    System.out.println("Seleccione una opción:");
    System.out.println("");
    System.out.println("1) Quitar un libro.");
    System.out.println("2) Quitar una sede.");
    System.out.println("3) Quitar una sección.");
    System.out.println("4) Quitar un piso.");
    System.out.println("5) Salir.");
  }
  private void printEditElement(){
    System.out.println("");
    System.out.println("¿Qué decea cambiar?");
    System.out.println("Seleccione una opción:");
    System.out.println("");
    System.out.println("1) Editar un libro.");
    System.out.println("2) Cambiar un libro de sede.");
    System.out.println("3) Cambiar un  libro de sección.");
    System.out.println("4) Cambiar un libro de piso.");
    System.out.println("5) Salir.");
  }
  

  /* Funciones menu */

  public void runMenu(Object p){
    printHeader();
    while(!exit){
      printMenu();
      int choice =  getInput();
      performAction(choice,p);
    }
  }
  private void performAction(int choice, Object p){
    switch(choice){
      case 1:
        printAddElement();
        int choice1 = getInput();
        caseAddElement(choice1,p);
        break;
      case 2:
        printRemoveElement();
        int choice2 = getInput();
        caseRemoveElement(choice2,p);
        //removeElement();
        break;
      case 3:
        printEditElement();
        int choice3 = getInput();
        caseEditElement(choice3);
        break;
      case 4:
        searchLibro(p);
        break;
      case 5:
        exit = true;
        System.out.println("\nGracias por visitar la biblioteca virtual.");
        break;
      default:
        System.out.println("Un error desconocido a ocurrido.");
    }
  }
  private void caseAddElement(int choice1, Object p){
    switch(choice1){
      case 1:
        System.out.println("AGREGAR LIBRO.");
        addLibro(p);
        break;
      case 2:
        System.out.println("AGREGAR SEDE.");
        addSede(p);
        break;
      case 3:
        System.out.println("AGREGAR SECCIÓN.");
        addSeccion(p);
        break;
      case 4:
        System.out.println("AGREGAR PISO.");
        addPiso(p);
        break;
      case 5:
        exit = true;
        System.out.println("\nGracias por visitar la biblioteca virtual.");
        break;
      default:
        System.out.println("Un error desconocido a ocurrido.");
    }
  }
  private void caseRemoveElement(int choice2, Object p){
    switch(choice2){
      case 1:
        System.out.println("QUITAR LIBRO.");
        //removeLibro();
        break;
      case 2:
        System.out.println("QUITAR SEDE.");
        removeSede(p);
        break;
      case 3:
        System.out.println("QUITAR SECCIÓN.");
        removeSeccion(p);
        break;
      case 4:
        System.out.println("QUITAR PISO.");
        removePiso(p);
        break;
      case 5:
        exit = true;
        System.out.println("\nGracias por visitar la biblioteca virtual.");
        break;
      default:
        System.out.println("Un error desconocido a ocurrido.");
    }
  }
  private void caseEditElement(int choice3){
    switch(choice3){
      case 1:
        System.out.println("EDITAR LIBRO.");
        //editLibro();
        break;
      case 2:
        System.out.println("CAMBIAR LIBRO DE SEDE.");
        //editSede();
        break;
      case 3:
        System.out.println("CAMBIAR LIBRO DE SECCIÓN.");
        //editSeccion();
        break;
      case 4:
        System.out.println("CAMBIAR LIBRO DE PISO.");
        //editPiso();
        break;
      case 5:
        exit = true;
        System.out.println("\nGracias por visitar la biblioteca virtual.");
        break;
      default:
        System.out.println("Un error desconocido a ocurrido.");
    }
  }
  
  /* Funcionalidades */

  public void addLibro(Object p){
    
    String texto;
    int cant_lineas = ((Bibloteca)p).cant_lineas; 
    System.out.println("Cantidad de libros: "+cant_lineas);

    String new_matriz[][] = new String[cant_lineas+1][8];
    System.out.println("Revisando la matriz, cantidad de lineas: "+new_matriz.length);

    // Guarda lo que teniamos en la nueva matriz
    for(int a = 0; a < cant_lineas; a++){
      for(int b = 0; b < 8;b++){
        new_matriz[a][b] = ((Bibloteca)p).matriz[a][b];
      }
    }
    
    System.out.println("Ingrese el titulo del libro: ");
    texto = getInputStr();
    new_matriz[cant_lineas][0] = '"'+texto+'"';
    System.out.println("Ingrese el autor del libro: ");
    texto = getInputStr();
    new_matriz[cant_lineas][1] = '"'+texto+'"';
    System.out.println("Ingrese el año del libro: ");
    texto = getInputStr();
    new_matriz[cant_lineas][2] = texto;
    System.out.println("Ingrese el numero del estante: ");
    texto = getInputStr();
    new_matriz[cant_lineas][3] = texto;
    System.out.println("Ingrese la seccion del estante: ");
    texto = getInputStr();
    new_matriz[cant_lineas][4] = '"'+texto+'"';
    System.out.println("Ingrese el piso: ");
    texto = getInputStr();
    new_matriz[cant_lineas][5] = texto;
    System.out.println("Ingrese el edificio: ");
    texto = getInputStr();
    new_matriz[cant_lineas][6] = '"'+texto+'"';
    System.out.println("Ingrese la sede: ");
    texto = getInputStr();
    new_matriz[cant_lineas][7] = '"'+texto+'"';
    
    for(int a = 0; a < cant_lineas+1; a++){
      for(int b = 0; b < 8; b++){
        System.out.println(new_matriz[a][b]+" "); 
      }
      System.out.println("\n"); 

    }
    
    


    ((Bibloteca)p).actualizar_bibloteca(new_matriz);
    System.out.println("Se ha agregado correctamente.");
   
    System.out.println("Cantidad de libros: "+((Bibloteca)p).cant_lineas);
  }
  public void addSeccion(Object p){
    int igual = 0;
    String texto;
    int cant_secciones = ((Bibloteca)p).cant_sec;
    System.out.println("Ingrese la seccion que desea agregar: ");
    texto = getInputStr();
    texto = '"'+texto+'"';
    for(int i =0; i< cant_secciones;i++){
      if(texto.equals(((Bibloteca)p).secciones[i])){
        igual ++;
      }
    }
    if(igual==0){
      String new_secciones[] = new String[cant_secciones+1];
      for(int a = 0; a < cant_secciones; a++){
        new_secciones[a] = ((Bibloteca)p).secciones[a];
      }
      new_secciones[cant_secciones] = texto;
      ((Bibloteca)p).actualizar_secciones(new_secciones);
      System.out.println("Se ha agregado correctamente.");
    }
    else{
      System.out.println("Ya existe ese seccion");
    }
  }
  public void addSede(Object p){
    int igual = 0;
    String texto;
    int cant_sedes = ((Bibloteca)p).cant_sed;
    System.out.println("Ingrese la sede que desea agregar: ");
    texto = getInputStr();
    texto = '"'+texto+'"';
    for(int i =0; i< cant_sedes;i++){
      if(texto.equals(((Bibloteca)p).sedes[i])){
        igual ++;
      }
    }
    if(igual==0){
      String new_sedes[] = new String[cant_sedes+1];
      for(int a = 0; a < cant_sedes; a++){
        new_sedes[a] = ((Bibloteca)p).sedes[a];
      }
      new_sedes[cant_sedes] = texto;
      ((Bibloteca)p).actualizar_sedes(new_sedes);
      System.out.println("Se ha agregado correctamente.");
    }
    else{
      System.out.println("Ya existe esa sede");
    }
  }
  public void addPiso(Object p){
    int igual = 0;
    String texto;
    int cant_pisos = ((Bibloteca)p).cant_pis;
    System.out.println("Ingrese el piso que desea agregar: ");
    texto = getInputStr();
    for(int i =0; i< cant_pisos;i++){
      if(texto.equals(((Bibloteca)p).pisos[i])){
        igual ++;
      }
    }
    if(igual==0){
      String new_pisos[] = new String[cant_pisos+1];
      for(int a = 0; a < cant_pisos; a++){
        new_pisos[a] = ((Bibloteca)p).pisos[a];
      }
      new_pisos[cant_pisos] = texto;
      ((Bibloteca)p).actualizar_pisos(new_pisos);
      System.out.println("Se ha agregado correctamente.");
    }
    else{
      System.out.println("Ya existe ese piso");
    }
  }

  //public void removeLibro(Object p){}

  public void removeSede(Object p){
    String texto;
    int cant_sedes = ((Bibloteca)p).cant_sed;
    int aux = 0;
    boolean igual = false;
    String new_sedes[] = new String[cant_sedes-1];
    System.out.println("Ojo, para poder quitar una sede esta no debe tener libros asociados.\n\nQue sede desea remover: ");
    texto = getInputStr();
    texto = '"'+texto+'"';
    for(int i = 0; i<cant_sedes;i++){
      if(texto.equals(((Bibloteca)p).sedes[i])){
        igual = true;
        aux = i;
      }
    }
    if(igual){
      int cont_sedes=0;
      for(int j = 0; j<cant_sedes;j++){
        if(j!=aux){
          new_sedes[cont_sedes] = ((Bibloteca)p).sedes[j];
          cont_sedes ++;
          if(cont_sedes == cant_sedes-1){
            System.out.println("Se ha eliminado correctamente la sede.");
            break;
          }
        }
      }
      ((Bibloteca)p).actualizar_sedes(new_sedes);
    }
    else{
      System.out.println("No existe la sede que desea eliminar.");
    }

  }
  public void removeSeccion(Object p){
    String texto;
    int cant_secciones = ((Bibloteca)p).cant_sec;
    int aux = 0;
    boolean igual = false;
    String new_secciones[] = new String[cant_secciones-1];
    System.out.println("Ojo, para poder quitar una seccion esta no debe tener libros asociados.\n\nQue seccion desea remover: ");
    texto = getInputStr();
    texto = '"'+texto+'"';
    for(int i = 0; i<cant_secciones;i++){
      if(texto.equals(((Bibloteca)p).secciones[i])){
        igual = true;
        aux = i;
      }
    }
    if(igual){
      int cont_secciones=0;
      for(int j = 0; j<cant_secciones;j++){
        if(j!=aux){
          new_secciones[cont_secciones] = ((Bibloteca)p).secciones[j];
          cont_secciones ++;
          if(cont_secciones == cant_secciones-1){
            System.out.println("Se ha eliminado correctamente la seccion.");
            break;
          }
        }
      }
      ((Bibloteca)p).actualizar_secciones(new_secciones);
    }
    else{
      System.out.println("No existe la seccion que desea eliminar.");
    }
  }
  public void removePiso(Object p){
    String texto;
    int cant_pisos = ((Bibloteca)p).cant_pis;
    int aux = 0;
    boolean igual = false;
    String new_pisos[] = new String[cant_pisos-1];
    System.out.println("Ojo, para poder quitar un piso este no debe tener libros asociados.\n\nQue piso desea remover: ");
    texto = getInputStr();
    for(int i = 0; i<cant_pisos;i++){
      if(texto.equals(((Bibloteca)p).pisos[i])){
        igual = true;
        aux = i;
      }
    }
    if(igual){
      int cont_pisos=0;
      for(int j = 0; j<cant_pisos;j++){
        if(j!=aux){
          new_pisos[cont_pisos] = ((Bibloteca)p).pisos[j];
          cont_pisos ++;
          if(cont_pisos == cant_pisos-1){
            System.out.println("Se ha eliminado correctamente el piso.");
            break;
          }
        }
      }
      ((Bibloteca)p).actualizar_pisos(new_pisos);
    }
    else{
      System.out.println("No existe el piso que desea eliminar.");
    }
  }

  //editLibro(){}

  //editSede(){}

  //editSeccion(){}

  //editPiso(){}
  
  private void searchLibro(Object p){
    System.out.println("Indique el titulo del libro que busca: ");
    String libro = getInputStr();
    libro = '"'+libro+'"';
    for(int a = 0; a < ((Bibloteca)p).cant_lineas; a++){
      if(libro.equals(((Bibloteca)p).matriz[a][0])){
        System.out.println("\nInformación del libro: ");
        ((Bibloteca)p).imprimir_libro(a);
        return;
      }
    }
    System.out.println("No se ha encontrado el libro.");
  }

  
}
