import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {

    private Scanner scan;

    private File file = new File("data/file.csv");

    public Main(){
        this.scan = new Scanner(System.in);
    }

    //opg 1
    public int promptNumber(String message) {
        try{
            System.out.println(message);
            return Integer.parseInt(scan.nextLine());
        }
        catch (NumberFormatException e){
            System.out.println("Wrong input");
            return promptNumber(message);
        }
    }

    //opg 2b
    public String getItem(ArrayList<String> items, int index) {
        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("Out of bounds. Index range is from 0 - " + (items.size() - 1));
        }
        return items.get(index);
    }


    //opg 3
    public ArrayList<String> readLines(String path) throws FileNotFoundException{
        ArrayList<String> textLines = new ArrayList<>();
        Scanner fileScanner = new Scanner(new File(path));
        while (fileScanner.hasNextLine()){
            textLines.add(fileScanner.nextLine());
        }
        return textLines;
    }


    public void main(){

        //Opgave 1
        //promptNumber("Indtast et tal");


        //Opgave 2
        Drink mojito = new Drink("Mojito", 60);

        try{
            mojito.setPrice(-30);
            System.out.println("Price is set to " + mojito.getPrice());
        }
        catch (IllegalArgumentException e){
            System.out.println("Error: price cannot be 0 or less");
        }


        //Opgave 2b
        ArrayList<String> items = new ArrayList();
        items.add(0, "Hey");
        items.add(1, "Ho");
        items.add(2, "Haha");
        try{
            System.out.println(getItem(items, 3));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        //Opgave 3
        try{
            ArrayList<String> textLines = readLines("data/file.csv");
            for(String line : textLines){
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }


        //Opgave 3b
        // min try catch håndteres allerede i main, se opgave 3.


        //Opgave 4 og 5
        ArrayList<String> data = new ArrayList<>();
        double sum = 0;
        data.add("Espresso, En kraftfuld og koncentreret kaffe, 25.0");
        data.add("Latte, Espresso med dampet mælk, 45.0");
        data.add("Cola, Kold og brusende, 30.0");

        for(String line : data){
            String[] lines = line.split(",");
            String name = lines[0].trim();
            String desc = lines[1].trim();
            try{
                double price = Double.parseDouble(lines[2].trim());
                System.out.println(name + " - " + desc + " (" + price + "kr.)");
                sum += price;
            }
            catch(NumberFormatException e){
                System.out.println("Error converting price");
            }
        }
        System.out.println("Total price: " + sum);


    }


}
