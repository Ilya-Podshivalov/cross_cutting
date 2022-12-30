import java.util.ArrayList;

public class DataBase {
    private static DataBase instance;
    private static ArrayList<String> equationsList = new ArrayList<String>();
    private DataBase(){
    }
    public static DataBase getInstance(String nameFile) {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
    public static void AddInformation (String equation){
        equationsList.add(equation);
    }
}
