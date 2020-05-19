import java.util.ArrayList;

public class ExpertSystemRuleSet {
    public static ArrayList<ExpertSystemRule> ExpertSystemList = new ArrayList<>();
    public static ArrayList<String> database = null;


    public static String ratiocinate(String... conditionStrings){
        database = new ArrayList<>();
        for (String conditionString : conditionStrings){
            database.add(conditionString);
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
