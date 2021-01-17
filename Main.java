import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Abro Scanner para pedir al usuario que me indique el tamaño de cada equipo

        Scanner scan = new Scanner(System.in);
        System.out.println("Please introduce a Battle Size: ");
        int partySize = scan.nextInt();

        // Creo dos listas de personajes para el firstParty y el secondParty

        ArrayList<Object> firstParty = new ArrayList<Object>();
        ArrayList<Object> secondParty = new ArrayList<Object>();

        // Creo um array de String para los nombres de los personajes del primer equipo

        String[] namesParty = new String[]{"Gollum", "Arwen", "Frodo", "Gimli", "Bilbo", "Boromir", "Peregrin", "Galadriel", "Elrond", "Eldarion"};

        // Creo un objeto de la clase random

        Random random = new Random();

        // Inicializo la variable rand y creo la variable String name para guardar los nombres del firstParty

        int rand = 0;
        String name;

        for (int i = 0; i < partySize; i++) {

            rand = random.nextInt(2); // Guardo en rand los números 0 o 1 de forma aleatoria

            name = namesParty[random.nextInt(10)]; // Calculo un número aleatorio entre 0-9 (he metido 10 personajes). El número que me dé será el índice que me indique el nombre del personaje del array namesParty

            for (int j = 0; j < firstParty.size(); j++) {

                if (firstParty.get(j).getClass().getName() == name) { // Si el nombre del personaje es el mismo que el nombre de uno de los personajes del firstParty, añado "Jr" al nuevo nombre

                    name = name + " Jr";
                }
            }

            if (rand == 0) { // Si rand es 0, creo warriors con sus atributos y los añado al firstParty. Junto con el id añado P1 o P2 para así luego saber en el graveyard de qué equipo viene estos personajes muertos

                Warrior warrior = new Warrior(Integer.toString(i) + "P1", name, random.nextInt(200 - 100 + 1) + 100, random.nextInt(50 - 10 + 1) + 10, random.nextInt(10 - 1 + 1) + 1);
                firstParty.add(warrior);

            } else { // Si rand es 1, creo wizards con sus atributos y los añado al firstParty
                Wizard wizard = new Wizard(Integer.toString(i) + "P1", name, random.nextInt(100 - 50 + 1) + 50, random.nextInt(50 - 10 + 1) + 10, random.nextInt(50 - 1 + 1) + 1);
                firstParty.add(wizard);
            }

        }

        File file = new File("secondParty.csv"); // abro el archivo .csv

        Scanner scanner1 = new Scanner(file); // creo scanner1 para leer la información del archivo (que lo he llamado file)

        scanner1.nextLine(); // leo la información de la primera línea

        String line; // creo la variable line para que me vaya guardando aqui la infromación del archivo .csv

        for (int i = 0; i < partySize; i++) { // creo un bucle para recorrer el texto de .csv

            line = scanner1.nextLine();

            String[] stats = scanner1.nextLine().split(", "); // separo las palabras de .csv y las guardo en stats

            if (stats[0] == "wizard") { // si el primer stats de cada linea es warrior o wizard, procedo a crear dicho personaje y agregarle sus atributos

                Wizard wizard = new Wizard(stats[1] + "P2", stats[2], Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), Integer.parseInt(stats[5]));
                secondParty.add(wizard);
            }

            if (stats[0] == "warrior") {

                Warrior warrior = new Warrior(stats[1] + "P2", stats[2], Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), Integer.parseInt(stats[5]));
                secondParty.add(warrior);
            }
        }

        scanner1.close();

        // Creo los dos party

        Party party1 = new Party("TEAM 1", firstParty);
        Party party2 = new Party("TEAM 2", secondParty);


        //Creo un objeto de clase battle

        Battle fight = new Battle (party1, party2);

        // Hago un bucle que me recorra la lista de graveyard para acceder a los atributos de los personajes que hay en ella y acceder al nombre e id.

        for (int i=0; i <fight.getGraveyard().size(); i++){



        }

        }
    }

