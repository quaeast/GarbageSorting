import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExpertSystemRuleSet {
    private static ArrayList<ExpertSystemRule> ExpertSystemList;

    public ExpertSystemRuleSet() {
        try {
            readJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int size(){
        return ExpertSystemList.size();
    }

    public ExpertSystemRule get(int index) {
        if (index < 0 || index >= ExpertSystemList.size()) {
            throw new IndexOutOfBoundsException(
                    "out of bounds, the length of ExpertSystemList is"
                            + ExpertSystemList.size());
        }
        return ExpertSystemList.get(index);
    }

    private static void readJson() throws IOException {
        File jsonFile = new File("src/main/resources/rules.json");
        byte[] fileContent = new byte[(int) jsonFile.length()];
        FileInputStream inputStream = new FileInputStream(jsonFile);
        int readLength = inputStream.read(fileContent);
        System.out.println("read Length: " + readLength);
        String json = new String(fileContent);

        /*
        It can be convert to java.util.ArrayList directly and safely,
        Because the object that it returned is java.util.ArrayList
        I checked it by reflect:

        test code:
        System.out.println(JSON.parseArray(json, ExpertSystemRule.class).getClass());

        output:
        class java.util.ArrayList
         */
        ExpertSystemList = (ArrayList<ExpertSystemRule>) JSON.parseArray(json, ExpertSystemRule.class);
        inputStream.close();
    }
}
