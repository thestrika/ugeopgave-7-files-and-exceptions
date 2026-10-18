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


    public String getItem(ArrayList<String> items, int index) {
        if(index < 0 || index >= items.size()){
            throw new IllegalArgumentException("Out of bounds. Index range is from 0 - " + (items.size() - 1));
        }
        return items.get(index);
    }



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


        //Opgave 4







    }


}
