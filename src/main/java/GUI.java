import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI {
    public static void main(String[] args) {
        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = null;

        JFrame mainWindow = new JFrame();
        JPanel mainGrid = new JPanel(gridLayout);
        JPanel buttons = new JPanel();
        JButton commitButton = new JButton("提交");
        JButton randomButton = new JButton("随机");
        JPanel inputAndOutput = new JPanel();
        JPanel input = new JPanel();
        JPanel output = new JPanel();
        JRadioButton yanhe = new JRadioButton("烟盒");
        JRadioButton shengfan = new JRadioButton("剩饭");
        JRadioButton baozhi = new JRadioButton("报纸");
        JRadioButton dianchi = new JRadioButton("电池");
        JTextField customInput = new JTextField("剩菜");

        JTextArea outputArea = new JTextArea(8, 5);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridLayout.addLayoutComponent(buttons, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridheight = 1;
        gridLayout.addLayoutComponent(inputAndOutput, gridBagConstraints);


        inputAndOutput.setLayout(new GridLayout(1, 2));
        input.setLayout(new GridLayout(5, 1));


        mainGrid.add(buttons);
        mainGrid.add(inputAndOutput);


        buttons.add(randomButton);
        buttons.add(commitButton);

        inputAndOutput.add(input);
        inputAndOutput.add(output);

        input.add(customInput);
        input.add(yanhe);
        input.add(shengfan);
        input.add(baozhi);
        input.add(dianchi);

        output.add(outputArea);

        customInput.setColumns(7);
        mainWindow.setContentPane(mainGrid);
        mainWindow.setLocation(300, 300);
        mainWindow.pack();
        mainWindow.setVisible(true);


        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExpertSystemRuleSet expertSystemRuleSet = new ExpertSystemRuleSet();
                ExpertSystemRule expertSystemRule = expertSystemRuleSet.get((int) (Math.random() * expertSystemRuleSet.size()));
                String[] conditions = expertSystemRule.getConditions();
                customInput.setText(conditions[(int) (conditions.length * Math.random())]);
                yanhe.setSelected(false);
                shengfan.setSelected(false);
                baozhi.setSelected(false);
                dianchi.setSelected(false);
            }
        });

        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InferenceEngine inferenceEngine = new InferenceEngine(customInput.getText());
                outputArea.setText(inferenceEngine.getConclusion());
            }
        });

        yanhe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customInput.setText("烟盒");
                shengfan.setSelected(false);
                baozhi.setSelected(false);
                dianchi.setSelected(false);
            }
        });

        shengfan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customInput.setText("剩饭");
                yanhe.setSelected(false);
                baozhi.setSelected(false);
                dianchi.setSelected(false);
            }
        });

        baozhi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customInput.setText("报纸");
                shengfan.setSelected(false);
                shengfan.setSelected(false);
                dianchi.setSelected(false);
            }
        });

        dianchi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customInput.setText("烟盒");
                yanhe.setSelected(false);
                shengfan.setSelected(false);
                baozhi.setSelected(false);
            }
        });
    }
}
