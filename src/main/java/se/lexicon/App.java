package se.lexicon;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Simple test" );
        Player p1 = new Player("Test", "test", 23);
        Player p2 = new Player("Test2", "test2", 253);
        List<Player> lp = new ArrayList<>();
        serialize(lp, "src/main/java/se/lexicon/files/test.ser");
    }


    public static List<Player> serialize(List<Player> source , String filePath){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ){
            out.writeObject(source);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return source;
    }



    public static <T> void serializeGeneric(List<T> source , String filePath){
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream out = new ObjectOutputStream(fileOutputStream)
        ){
            out.writeObject(source);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
