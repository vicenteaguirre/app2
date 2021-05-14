import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    Bibloteca biblo = new Bibloteca(CSVReader.LeerCSV(args[0]));
    Menu menu = new Menu();
    menu.runMenu(biblo);
  }
}