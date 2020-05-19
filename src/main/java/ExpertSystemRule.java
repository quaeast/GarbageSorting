import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpertSystemRule {
    @JSONField(name = "conditions")
    private final String[] conditions;
    @JSONField(name = "conclusion")
    private final String conclusion;
    @JSONField(name = "isFinal")
    private final boolean isFinal;

    public Boolean isMatch(List<String> conditionStrings) {
        boolean isExist;
        for (String myCondition : conditions) {
            isExist = false;
            for (String inputCondition : conditionStrings) {
                if (myCondition.equalsIgnoreCase(inputCondition)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return false;
            }
        }
        return true;
    }

    public Boolean isMatch(String... conditionStrings) {
        return isMatch(Arrays.asList(conditionStrings));
    }

    public void print() {
        System.out.println("Condition: ");
        for (String condition : conditions) {
            System.out.println("\t" + condition);
        }
        System.out.println("\nConclusion: " + conclusion + "\n");
    }
}
