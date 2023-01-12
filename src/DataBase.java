import java.util.ArrayList;

public class DataBase {
    private static DataBase instance;
    private static ArrayList<MathExample> exampleList = new ArrayList<MathExample>();
    private DataBase(){
    }
    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
    public void AddData (ArrayList<String> exampleListString){
        int count = exampleListString.size();
        for(int i = 0; i < count; i++){
            MathExample stringMathExample = new MathExample(exampleListString.get(i));
            exampleList.add(stringMathExample);
        }

    }
    public static void Print(){
        int count = exampleList.size();
        for(int i = 0; i < count; i++){
            System.out.println(exampleList.get(i).example);
        }
    }
}
