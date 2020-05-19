import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;

public class Test {
    private static void testWrite() throws IOException {
        String[] condition = new String[]{"wang", "liu", "li"};
        ExpertSystemRule a = new ExpertSystemRule(condition, "fang", true);
        ExpertSystemRule b = new ExpertSystemRule(condition, "ang", true);
        ArrayList<ExpertSystemRule> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        String json = JSON.toJSONString(list);
        System.out.println(json);
        FileWriter fr = new FileWriter("src/main/resources/rules.json");
        fr.write(json);
        fr.close();
    }

    private static void testRead() throws IOException {
        File jsonFile = new File("src/main/resources/rules.json");
        byte[] fileContent = new byte[(int) jsonFile.length()];
        FileInputStream inputStream = new FileInputStream(jsonFile);
        inputStream.read(fileContent);
        String json = new String();
        System.out.println(json);
    }

    public static void main(String[] args) {
        try {
            testRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
