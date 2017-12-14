import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI  extends JFrame implements ActionListener{

    private JTextField a;
    private JCheckBox f;
    private JCheckBox c;
    private JButton clear;
    private JButton submit;
    private Container pane;
    
    public GUI(){
		this.setTitle("Temperature Converter");
		this.setSize(500,80);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		pane = this.getContentPane();
		pane.setLayout(new FlowLayout());
		
		a = new JTextField(10);
		f = new JCheckBox("Fahrenheit");
		c = new JCheckBox("Celsius");
		clear = new JButton("Clear");
		submit = new JButton("Submit");
		
		a.addActionListener(this);
		f.addActionListener(this);
		c.addActionListener(this);
		clear.addActionListener(this);
		submit.addActionListener(this);
		
		pane.add(a);
		pane.add(f);
		pane.add(c);
		pane.add(clear);
		pane.add(submit);
	
    }


    public void actionPerformed(ActionEvent e){
		String s = e.getActionCommand();
		System.out.println(s);
		double res = Double.parseDouble(a.getText());
		if(s.equals("Submit")){
			if (f.isSelected()){
				a.setText(""+ CtoF(res));
			}
			if (c.isSelected()){
				a.setText(""+ FtoC(res));
			}
		}
		
		if(s.equals("Clear")){
            //button code here
            a.setText("");
        }
	
    }


    public static double CtoF(double c){
		return c*(9/5) + 32;
    }

    public static double FtoC(double f){
		return (f-32)*(5/9);
    }
    
    public static void main(String[] args){
    	GUI test = new GUI();
    	test.setVisible(true);
    }

    
}
