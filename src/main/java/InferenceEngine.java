import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;


@Data
public class InferenceEngine {
    private final ArrayList<String> database;
    ExpertSystemRuleSet expertSystemRuleSet;
    private boolean isInferred = false;
    private String Conclusion = null;

    public InferenceEngine(String[] conditions) {
        database = new ArrayList<>();
        database.addAll(Arrays.asList(conditions));
        expertSystemRuleSet = new ExpertSystemRuleSet();
    }

    public void Infer() {
        isInferred = true;
        for (int i = 0; i < expertSystemRuleSet.size(); i++) {
            ExpertSystemRule expertSystemRule = expertSystemRuleSet.get(i);
            if (expertSystemRule.isContainCondition(database)) {
                if (expertSystemRule.isFinal()) {
                    Conclusion = expertSystemRule.getConclusion();
                    return;
                }else {
                    database.clear();
                    database.add(expertSystemRule.getConclusion());
                    Infer();
                }
            }
        }
    }
}
