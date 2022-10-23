
//********************CALCULATOR GUI*****************//


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;//import for color purposes

public class Calculator implements ActionListener{

//set up components
	JFrame frame;
	JTextField textfield;
	JButton[] numBtn = new JButton[10];
	JButton[] btnFuntions = new JButton[9];
	JButton add,subt,mul,div,dec, eql, del, clr, neg; 
	JPanel panel;
	
//set up variables
	char operator;
	double num1=0,num2=0,result=0;
	
	Calculator(){
		
		//frame Settings
		frame = new JFrame("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);//use to center the GUI in the desktop screen
		frame.getContentPane().setBackground(Color.MAGENTA);//Color of the JFrame
		
		//Textfield Settings
		Font myFont = new Font("MONOSPACED",Font.BOLD,25);// Font Characteristics
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		//Button settings
		add = new JButton("+");
		subt = new JButton("-");
		mul = new JButton("x");
		div = new JButton("/");
		dec = new JButton(".");
		eql = new JButton("=");
		del = new JButton("Del");
		clr = new JButton("C");
		neg = new JButton("(-)");
		
		btnFuntions[0] = add;
		btnFuntions[1] = subt;
		btnFuntions[2] = mul;
		btnFuntions[3] = div;
		btnFuntions[4] = dec;
		btnFuntions[5] = eql;
		btnFuntions[6] = del;
		btnFuntions[7] = clr;
		btnFuntions[8] = neg;
		
		for(int i =0;i<9;i++) {
			btnFuntions[i].addActionListener(this);
			btnFuntions[i].setFont(myFont);
			btnFuntions[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			numBtn[i] = new JButton(String.valueOf(i));
			numBtn[i].addActionListener(this);
			numBtn[i].setFont(myFont);
			numBtn[i].setFocusable(false);
		}
		//Jbuttons extra Operations
		neg.setBounds(50,430,100,50);
		neg.setBackground(Color.BLACK);
		neg.setForeground(Color.white);
		del.setBounds(150,430,100,50);
		del.setBackground(Color.BLACK);
		del.setForeground(Color.white);
		clr.setBounds(250,430,100,50);
		clr.setBackground(Color.BLACK);
		clr.setForeground(Color.white);

		//JPanel Settings
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.PINK);//Color of JPanel
		
		//JButton design in JPanel
		panel.add(numBtn[1]);
			numBtn[1].setBackground(Color.BLACK);
			numBtn[1].setForeground(Color.white);
		panel.add(numBtn[2]);
			numBtn[2].setBackground(Color.BLACK);
			numBtn[2].setForeground(Color.white);
		panel.add(numBtn[3]);
			numBtn[3].setBackground(Color.BLACK);
			numBtn[3].setForeground(Color.white);
		panel.add(add);
			add.setBackground(Color.BLACK);
			add.setForeground(Color.white);
		panel.add(numBtn[4]);
			numBtn[4].setBackground(Color.BLACK);
			numBtn[4].setForeground(Color.white);
		panel.add(numBtn[5]);
			numBtn[5].setBackground(Color.BLACK);
			numBtn[5].setForeground(Color.white);
		panel.add(numBtn[6]);
			numBtn[6].setBackground(Color.BLACK);		
			numBtn[6].setForeground(Color.white);
		panel.add(subt);
			subt.setBackground(Color.BLACK);
			subt.setForeground(Color.white);
		panel.add(numBtn[7]);
			numBtn[7].setBackground(Color.BLACK);		
			numBtn[7].setForeground(Color.white);
		panel.add(numBtn[8]);
			numBtn[8].setBackground(Color.BLACK);
			numBtn[8].setForeground(Color.white);
		panel.add(numBtn[9]);
			numBtn[9].setBackground(Color.BLACK);
			numBtn[9].setForeground(Color.white);
		panel.add(mul);
			mul.setBackground(Color.BLACK);
			mul.setForeground(Color.white);
		panel.add(dec);
			dec.setBackground(Color.BLACK);
			dec.setForeground(Color.white);
		panel.add(numBtn[0]);
			numBtn[0].setBackground(Color.BLACK);
			numBtn[0].setForeground(Color.white);
		panel.add(eql);
			eql.setBackground(Color.BLACK);
			eql.setForeground(Color.white);
		panel.add(div);
			div.setBackground(Color.BLACK);		
			div.setForeground(Color.white);

		frame.add(panel);
		frame.add(neg);
		frame.add(del);
		frame.add(clr);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numBtn[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==dec) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==add) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subt) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mul) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==div) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==eql) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clr) {
			textfield.setText("");
		}
		if(e.getSource()==del) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==neg) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}
}

