import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    private Scanner scan;

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







    }


}
