package BrawlStars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static int readInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
    public static String readString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.toString();
    }

    public static ArrayList<Brawler> brawlers = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("1. Ver Brawlers");
            System.out.println("2. Crear Brawler Legendario");
            System.out.println("3. Crear Bralwer Epico");
            System.out.println("4. Combatir");
            System.out.println("5. Salir");
            System.out.println();
            opcion = readInt("Opcion: ");

            switch (opcion){
                case 1: MirarBrawler(); break;
                case 2: CrearLegendario(); break;
                case 3: CrearEpico(); break;
                case 4: Combatir(); break;
            }

        }while(opcion != 5);


    }

    private static void MirarBrawler() {
        if (brawlers.size() == 0){
            System.out.println("Todavia no hay nada \n");
        }
        else {
            for (int i = 0; i <brawlers.size(); i++){
                System.out.println("["+brawlers.get(i).getName()+":"+brawlers.get(i).getHealth()+"]");
            }
        }
    }


    private static void CrearEpico() {

        String name = readString("Nombre");
        int health = readInt("Vida: ");
        int heals = readInt("curas: ");

        Epic personajeEpico = new Epic(name, health, heals);
    }

    public static void CrearLegendario() {

        String name = readString("Nombre");
        int health = readInt("Vida: ");
        int heals = readInt("curas: ");

        Epic personajeLegendario = new Epic(name, health, heals);
    }

    private static void Combatir() {
        String nombre1 = readString("Nombre del Brawler 1: ");
        String nombre2 = readString("Nombre del Brawler 2: ");

        Brawler luchador1 = null;
        Brawler luchador2 = null;

        for (int i = 0; i < brawlers.size(); i++){
            if (brawlers.get(i).getName().equals(nombre1)){
                luchador1 = brawlers.get(i);
            } else if (brawlers.get(i).getName().equals(nombre2)) {
                luchador2 = brawlers.get(i);
            }
        }
        if (luchador1 == null){
            System.out.println("Uno de los Brawlers no se ha encontrado...");
        } else if (luchador2 == null) {
            System.out.println("Uno de los Brawlers no se ha encontrado...");
        } else {
            System.out.println("["+luchador1.getName()+":"+luchador1.getHealth()+"]");
            System.out.println("["+luchador2.getName()+":"+luchador2.getHealth()+"]\n");

            luchador1.actionByCategory(luchador2);
            luchador2.actionByCategory(luchador1);
        }
    }


}