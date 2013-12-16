/**********************************************************
 * Kade Nethercott
 * Project 1, Calculator
 * IDE: Eclipse
 * CS 2410 sec 001
 * 11/14/12
 * 
 *********************************************************/



package calculator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PersonalTrainer extends JFrame
{
	private final int WIDTH = 800;
	private final int HEIGHT = 475;
	
	private JTextField name_JTF;
	private JTextField height_JTF;
	private JTextField height_Inches_JTF;
	private JTextField weight_JTF;
	private JTextField age_JTF;
	
	private JTextArea results_JTA;
	
	
	private JButton BMI_JB;
	private JButton calories_JB;
	private JButton clear_History_JB;
	private JButton calculator_JB;
	
	private JRadioButton male_JRB, female_JRB;
	private JComboBox activity_JCB;
	private String [] activity_Levels= {"Sedentary", "Lightly Active", 
										"Moderately Active", "Very Active", "Extra Active"};
	private EventHandler handler;
	private ButtonGroup sex_BG;
	
	public PersonalTrainer()//constructor
	{
		//set up JFrame
		setTitle("Personal Trainer");
		setSize(WIDTH,HEIGHT);
		
		//create the pane
		Container pane = getContentPane();
	
		pane.setLayout(null);
	
	
		//create the jtextfields
		name_JTF= new JTextField(40);
		name_JTF.setSize(175,25);
		name_JTF.setLocation(100, 25);
		
		height_JTF= new JTextField(40);
		height_JTF.setSize(50,25);
		height_JTF.setLocation(100, 165);
		
		height_Inches_JTF= new JTextField(40);
		height_Inches_JTF.setSize(50,25);
		height_Inches_JTF.setLocation(190, 165);
		
		weight_JTF= new JTextField(40);
		weight_JTF.setSize(50,25);
		weight_JTF.setLocation(100,215);
		
		age_JTF= new JTextField(40);
		age_JTF.setSize(50,25);
		age_JTF.setLocation(100, 115); //265

		
		//create the Jradiobuttons size and location
		male_JRB=new JRadioButton("Male");
		male_JRB.setSize(60,30);
		male_JRB.setLocation(100,63);
		male_JRB.setBackground(Color.LIGHT_GRAY);
		
		female_JRB=new JRadioButton("Female");
		female_JRB.setSize(80,30);
		female_JRB.setLocation(180,63);
		female_JRB.setBackground(Color.LIGHT_GRAY);
		
		//create the jcombobox size and location
		activity_JCB=new JComboBox(activity_Levels);
		activity_JCB.setMaximumRowCount(5);
		activity_JCB.setSize(120,30); 
		activity_JCB.setLocation(155,265);  //110
		activity_JCB.setBackground(Color.white);
		
		//create the jtextarea
		results_JTA= new JTextArea(40,20);
		results_JTA.setSize(300,310);
		results_JTA.setLocation(450,25);
		results_JTA.setEditable(false);
		results_JTA.setLineWrap(true);
		results_JTA.setForeground(Color.white);
		results_JTA.setBackground(Color.black);
		
		//create the listener
		handler = new EventHandler();
		
		//create a font for the buttons and graphic strings
		Font buttonFont=new Font("Tahoma",Font.BOLD, 11); 
		
		//creaet the jbuttons
		BMI_JB = new JButton("Body Mass Index");
		BMI_JB.setSize(175,50);
		BMI_JB.setLocation(20, 350);
		BMI_JB.addActionListener(handler);
		BMI_JB.setFont(buttonFont);
		
		calories_JB = new JButton("Daily Caloric Expenditure");
		calories_JB.setSize(175,50);
		calories_JB.setLocation(220, 350);
		calories_JB.addActionListener(handler);
		calories_JB.setFont(buttonFont);
		
		clear_History_JB = new JButton("Clear History");
		clear_History_JB.setSize(140,50);
		clear_History_JB.setLocation(450, 350);
		clear_History_JB.addActionListener(handler);
		clear_History_JB.setFont(buttonFont);
		
		calculator_JB = new JButton("Calculator");
		calculator_JB.setSize(140,50);
		calculator_JB.setLocation(610, 350);
		calculator_JB.addActionListener(handler);
		calculator_JB.setFont(buttonFont);
		
		//add all the buttons and boxes to the pane
		pane.add(male_JRB);
		pane.add(female_JRB);
		pane.add(activity_JCB);
		pane.add(results_JTA);
		pane.add(BMI_JB);
		pane.add(calories_JB);
		pane.add(name_JTF);
		pane.add(height_JTF);
		pane.add(weight_JTF);
		pane.add(age_JTF);
		pane.add(clear_History_JB);
		pane.add(calculator_JB);
		pane.add(height_Inches_JTF);
		
		
		//create the button group for the radiobuttons
		sex_BG= new ButtonGroup();
	
		sex_BG.add(male_JRB);
		sex_BG.add(female_JRB);
		
		pane.setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		
		//close the program so it won't continue runing in the background
		this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }
    );
	
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		//paint the rounded rectangles
		g.setColor(new Color(0,150,255));
		g.setFont(new Font("Tahoma", Font.BOLD, 14));
		g.drawRoundRect(20, 40, 400, 300, 10, 20);
		g.drawRoundRect(445, 40, 325, 405, 10, 20);
		g.drawRoundRect(20, 360, 400, 85, 10, 20);
		
		//paint the different labels
		g.setColor(new Color(0,150,255));
		g.drawString("Name: ", 40, 70);
		g.drawString("Sex:",40, 110);
		g.drawString("Activity Level:", 40, 310); //160
		g.drawString("Height: ", 40, 210);
		g.drawString("ft", 170, 210);
		g.drawString("in", 260, 210);
		g.drawString("Weight:", 40, 260);
		g.drawString("lbs", 170, 260);
		g.drawString("Age:", 40, 160); //310
		g.drawString("yrs", 170, 160);
		
		
		
	}
	
	private class EventHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
	    {
	       
            String weight;
            String category;
            String client;
            String age;
            String activity_Level;
            
            double height_ft=0;
            double height_in=0; 
            double height=0;
            double BMI=0;
            double ideal_Weight=0;
            double weight_Loss=0;
            double calories=0;
            double BMR=0;
            
	        String str = String.valueOf(e.getActionCommand());
	        
		 if(str.equals("Body Mass Index")) //if user click on the body mass index button
	        {
	            
	           
	            try
	           {
	        	   
	        
	            	
	            client=name_JTF.getText();//get the name
	          
	            if(height_JTF.getText().equals(""))//check to see if user entered anything
	            {
	            	height_ft=0;
	            }
	            else
	            {
	            	height_ft=Double.parseDouble(height_JTF.getText());  //get the height
	            }
	            
	            if(height_Inches_JTF.getText().equals(""))//check for input
	            {
	            	height_in=0;
	            }
	            else
	            {
	            	height_in=Double.parseDouble(height_Inches_JTF.getText()); 
	            }
	            
	            
	           
	            
	            height= height_ft*12 + height_in;
	            weight=weight_JTF.getText();
	            
	            BMI = Double.parseDouble(weight)/(Math.pow((height), 2))*703;  //calculate the body mass index
	            ideal_Weight= (24*(Math.pow((height), 2))/703);  //calculate what the person's healthy weight should be based off of their height
	            
	            category = bmi_Category(BMI);  //get which category the clients falls into based off of their BMI score
	            
	            weight_Loss = Double.parseDouble(weight)-ideal_Weight;  //calculate how much weight they need to lose to get into a healthy range
	            if(BMI>24) //if their BMI is in an unhealthy range
	            {
	               
	               results_JTA.append(String.format("Client: %s %n  -BMI: %.2f %n  -Considered %s. %n  -Ideal weight: %.2f lbs. %n  -Needs to lose %.2f lbs to get to a healthy weight.%n "
	                        ,client,BMI, category, ideal_Weight, weight_Loss));
	            }
	            else  //if in a healthy range
	            {
	            	
	            	results_JTA.append(String.format("Client: %s %n  -BMI is: %.2f %n  -%s. %n  -Does not need to lose weight.%n"
	                    ,client,BMI, category));
	            }
	            
	           }
	           catch(ArithmeticException e2)  //check for division by 0
	            {
	        	   results_JTA.setText(e2.getMessage());               
	            }
	          
	           catch(NumberFormatException e2) //check for entering string when it should be a double
	            {
	        	   results_JTA.setText("Invalid numeric input type, try again \n");
	            }
	          
	           catch(Exception e2)
	            {
	        	   results_JTA.setText(e2.getMessage());                
	            }
	           
	        }
		 
		 	if(str.equals("Daily Caloric Expenditure"))
			{
		 				        	   			           			  
			         try
			         {
			            client=name_JTF.getText();
			            
			            if(height_JTF.getText().equals(""))
			            {
			            	height_ft=0;
			            }
			            else
			            {
			            	height_ft=Double.parseDouble(height_JTF.getText());  //get the height
			            }
			            
			            if(height_Inches_JTF.getText().equals(""))
			            {
			            	height_in=0;
			            }
			            else
			            {
			            	height_in=Double.parseDouble(height_Inches_JTF.getText()); 
			            }
			            
			            
			            height= height_ft*12 + height_in;
			            weight=weight_JTF.getText();
			            age= age_JTF.getText();
			            
			            activity_Level=activity_Levels[activity_JCB.getSelectedIndex()];//get the activity level from the combobox
			            
			            
			            if(male_JRB.isSelected())
			            {	//calculate the BMR for male
		            		//Men: BMR = 66 + ( 6.23 x weight in pounds ) + ( 12.7 x height in inches ) - ( 6.8 x age in year )
			            	BMR= 66+(6.23*Double.parseDouble(weight))+(12.7*height)-(6.8 * Double.parseDouble(age));
			            }
			            else if(female_JRB.isSelected())
			            {	//calculate the BMR for female
			            	// Women: BMR = 655 + ( 4.35 x weight in pounds ) + ( 4.7 x height in inches ) - ( 4.7 x age in years )
			            	BMR= 655+(4.35*Double.parseDouble(weight))+(4.7*height)-(4.7 * Double.parseDouble(age));
			            }
			            else
			            {	//if female or male has not been selected
			            	results_JTA.append("Male or Female is not selected\n");
			            }
			            
			            if(activity_Level.equals(activity_Levels[0]))
			            {	//if sedentary 
			            	calories=BMR*1.2;
			            }
			            if(activity_Level.equals(activity_Levels[1]))
					    {	//if  lightly active
			            	calories=BMR*1.37;
					    }
			            if(activity_Level.equals(activity_Levels[2]))
					    {	// if moderately active
			            	calories=BMR*1.55;
					    }
			            if(activity_Level.equals(activity_Levels[3]))
					    {	//if very active
			            	calories=BMR*1.725;
					    }
			            if(activity_Level.equals(activity_Levels[4]))
			            {	// if extra active
			            	calories=BMR*1.9;
			            }
			            
			            //put the output onto the jtextarea
			            results_JTA.append(String.format("Client: %s %n  -BMR is: %.2f %n -Daily Caloric Expenditure: %.2f calories%n"
			                    ,client,BMR, calories));
			           
			           
			            	
			         
			            
			            
			         }
			          catch(ArithmeticException e3)  //check for division by 0
			            {
			        	   results_JTA.setText(e3.getMessage());               
			            }
			          
			           catch(NumberFormatException e3) //check for entering string when it should be a double
			            {
			        	   results_JTA.setText("Invalid numeric input type, try again \n");
			            }
			          
			           catch(Exception e3)
			            {
			        	   results_JTA.setText(e3.getMessage());                
			            }
				}
			           
			
	        
	        if(str.equals("Clear History"))  //reset the JTextArea
	        {
	        	results_JTA.setText("");
	        }
	        
	        if(str.equals("Calculator")) //open the calculator GUI
	        {
	        	Calculator C = new Calculator();
	        }
	        
	    }
	  
	    public String bmi_Category(double BMI) //calculate the BMI score category or range
	    {
	        if(BMI>39)
	        {
	            return "Very Severly Obese";
	        }
	        else if(BMI>34)
	        {
	            return "Severly Obese";
	        }
	        else if(BMI>29)
	        {
	            return "Obese";
	        }
	        else if(BMI>24)
	        {
	            return "Overweight";
	        }
	        else if(BMI>18.5)
	        {
	            return "Has a normal/healthy weight";
	        }
	        else
	            return "Is considered Underweight";
	       
	    }
	}
	
	
	
	
	public static void main(String[] args)
    {
		 PersonalTrainer PT = new PersonalTrainer();  //create an instance of PT
    }
	
}
