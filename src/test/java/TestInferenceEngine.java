public class TestInferenceEngine {
    public static void main(String[] args) {
        String[] s = new String[]{"烟盒", "镜子"};
        InferenceEngine inferenceEngine = new InferenceEngine("烟盒");
        InferenceEngine inferenceEngine2 = new InferenceEngine(s);
        System.out.println(inferenceEngine.getConclusion());
        System.out.println(inferenceEngine2.getConclusion());
    }
}
