package DataBase;
import java.util.ArrayList;

public class DataBase {
    private static volatile DataBase instance;

    private static Object mutex = new Object();

    public static ArrayList<String> exampleList = new ArrayList<String>();
    private DataBase(){
    }
    public static DataBase getInstance() {
        DataBase result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new DataBase();
            }
        }
        return result;
    }
    public void AddData (ArrayList<String> exampleListString){
        int count = exampleListString.size();
        for(int i = 0; i < count; i++){
            // MathExample stringMathExample = new MathExample(exampleListString.get(i));
            exampleList.add(exampleListString.get(i));
        }

    }
    public static void Print(){
        int count = exampleList.size();
        for(int i = 0; i < count; i++){
            System.out.println(exampleList.get(i));
        }
    }
}
