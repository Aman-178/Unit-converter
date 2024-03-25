import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Unitconverter {
    private JFrame frame;
    private JLabel inputLabel, outputLabel;
    private JTextField input, output;
    private JComboBox<String> fromUnit, toUnit;
    private JButton convertButton;

    protected void initComponents() {
        frame = new JFrame("UNIT Converter");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        inputLabel = new JLabel("Input:");
        input = new JTextField(10);
        outputLabel = new JLabel("Output:");
        output = new JTextField(10);
        // output agar edit nhi kar paye to
        output.setEditable(false);
        fromUnit = new JComboBox<>(new String[]{"METERS", "FEET", "INCHES", "CENTIMETER"});
        toUnit = new JComboBox<>(new String[]{"METERS", "FEET", "INCHES", "CENTIMETER"});
        convertButton = new JButton("CONVERT");

        inputLabel.setBounds(20, 50, 100, 20);
        input.setBounds(150, 50, 100, 20);
        outputLabel.setBounds(20, 90, 100, 20);
        output.setBounds(150, 90, 100, 20);
        fromUnit.setBounds(270, 50, 100, 20);
        toUnit.setBounds(270, 80, 100, 20);
        convertButton.setBounds(150, 120, 100, 20);

        frame.add(inputLabel);
        frame.add(input);
        frame.add(fromUnit);
        frame.add(outputLabel);
        frame.add(output);
        frame.add(toUnit);
        frame.add(convertButton);

        convertButton.addActionListener(new ConvertButtonListner());

    }
     private class ConvertButtonListner implements ActionListener {


         @Override
         public void actionPerformed(ActionEvent e) {
             String fromUnitType=fromUnit.getSelectedItem().toString();
             String toUnitType=toUnit.getSelectedItem().toString();
             double inputValue=Double.parseDouble(input.getText());
             double outputValue=0.0;
             if(fromUnitType.equals("METERS")){
                 if (toUnitType.equals("METERS")){
                     outputValue=Unitconverter.metersTometers(inputValue);
                 }else if(toUnitType.equals("FEET")){
                     outputValue=Unitconverter.metersToFeet(inputValue);
                 } else if (toUnitType.equals("INCHES")) {
                     outputValue=Unitconverter.metersToInches(inputValue);
                 }else if(toUnitType.equals("CENTIMETER")){
                     outputValue=Unitconverter.metersToCetimeters(inputValue);
                 }

             } else if (fromUnitType.equals("FEET")) {

             } else if (fromUnitType.equals("INCHES")) {

             } else if (fromUnitType.equals("CENTIMETER")) {

             }
          output.setText(""+outputValue);
         }
     }
     public static double metersTometers(double inputValue){
        double outValue;
        outValue=inputValue;
        return outValue;
     }
    public static double metersToCetimeters(double inputValue){
        double outValue;
        outValue=inputValue*100;
        return outValue;
    }
    public static double metersToFeet(double inputValue){
        double outValue;
        outValue=inputValue*3.28084;
        return outValue;
    }
    public static double metersToInches(double inputValue){
        double outValue;
        outValue=inputValue*3.28084*12;
        return outValue;
    }


    public Unitconverter() {
        initComponents();
    