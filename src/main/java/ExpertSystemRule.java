import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.List;


@Data
@AllArgsConstructor
@Value
public class ExpertSystemRule {
    @JSONField(name = "conditions")
    String[] conditions;
    @JSONField(name = "conclusion")
    String conclusion;
    @JSONField(name = "isFinal")
    boolean isFinal;

    boolean isContainCondition(List<String> conditions) {
        for (String i:conditions){
            boolean isExist = false;
            for (String j:this.conditions){
                if (i.equals(j)){
                    isExist = true;
                    break;
                }
            }
            if (!isExist){
                return false;
            }
        }
        return true;
    }
}
