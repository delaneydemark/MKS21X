import javax.swing.*;
import java.awt.*;


public class GUI  extends JFrame implements ActionListener{

    private JTextField a;
    public GUI(){
	this.setTitle("Temperature Converter");
	this.setSize(500,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
    }

    public static void main(String[] args){
    }

    public void actionPerformed(ActionEvent e){
	String s = e.getActionCommand();
	System.out.println(s);
	
    }



    public static double CtoF(double c){
	return c*(9/5) + 32;
    }

    public static double FtoC(double f){
	return (f-32)*(5/9);
    }

    
}
