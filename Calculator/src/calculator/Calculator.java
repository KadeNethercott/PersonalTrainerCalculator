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
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame implements ActionListener
{
    private JTextField displayText_JTF = new JTextField(60);
    private JTextArea pastResults_JTA= new JTextArea(40,20);
    private JButton[] button_JB = new JButton[19];
    private String[] keys = {"7", "8", "9","/",
                            "4", "5", "6","*",
                            "1", "2", "3", "+",
                            ".","0","C", "-",
                            "=", "BMI", "Clear History" };
   
  
    private String numStr1 ="";
    private String numStr2= "";
    private String equation="";
    
    private char op;
    private boolean firstInput = true;  //for tracking whether the first number has been entered
    private boolean arithmetic_Input = false; //used to see if user has entered *,+,-,/ 
  
    public Calculator()
    {	
    	//set up JFrame
        setTitle("Personal Trainer Calculator");
        setSize(650, 365);
        
        //create pane
        Container pane = getContentPane();
        pane.setLayout(null);
        
        //create the JTextField, size, location
        displayText_JTF.setSize(415,30);
        displayText_JTF.setLocation(10,10);
       
        //create the JTextArea, size, location, color
        pastResults_JTA.setSize(300,250);
        pastResults_JTA.setLocation(450,10);
        pastResults_JTA.setEditable(false);
        pastResults_JTA.setLineWrap(true);
        pastResults_JTA.setForeground(Color.white);
        pastResults_JTA.setBackground(Color.black);
       
        //add the Jtextfield and area to the pane
        pane.add(displayText_JTF);
        pane.add(pastResults_JTA);
       
        Font buttonFont=new Font("Tahoma",Font.BOLD, 14);  
        
        //Set JButton font using new created font  
        
        int x, y;
      
        x=10;
        y=45;
        
        //create the JButtons using a loop and arrays
        for(int index=0; index<16; index++)
        {
            button_JB[index]= new JButton(keys[index]);
            button_JB[index].addActionListener(this);
            button_JB[index].setSize(100,50);
            button_JB[index].setLocation(x,y);
            button_JB[index].setFont(buttonFont);
            pane.add(button_JB[index]);
          
            x=x+105;
          
            if((index+1)%4==0) //after placing four buttons on a line start a new line
            {
                x=10;
                y=y+55;
            }
          
        }
     
       //create the equals button, size, location, add to pane
        button_JB[16]= new JButton(keys[16]);
        button_JB[16].addActionListener(this);
        button_JB[16].setSize(205,50);
        button_JB[16].setLocation(10,265);
        button_JB[16].setFont(buttonFont);
        pane.add(button_JB[16]);
      
        
        //create the clear history button
        button_JB[18]= new JButton(keys[18]);
        button_JB[18].addActionListener(this);
        button_JB[18].setSize(205,50);
        button_JB[18].setLocation(220,265);
        button_JB[18].setFont(buttonFont);
        pane.add(button_JB[18]);
      
        //use anonymous class to assign a windowAdapter 
        this.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            }
        );
        
        pane.setBackground(Color.black);
        setVisible(true);
       
        //use anonymous class to add the keylistener to the JTextField, so user can use the keyboard buttons instead of JButtons
        displayText_JTF.addKeyListener(new KeyAdapter()
        {
        
            public void keyTyped(KeyEvent e)
            {
               String resultStr;
               
                 String str = String.valueOf(e.getKeyChar()); //get the key character
               
                 //System.out.println(str);
                
                 char ch = str.charAt(0);//convert to a char to use in switch statement
               
                 switch(ch)
                 {
                 case '0':
                 case '1':
                 case '2':
                 case '3':
                 case '4':
                 case '5':
                 case '6':
                 case '7':
                 case '8':
                 case '9':
                 case '.':
                     if(firstInput) //if firstinput is true then the number is part of the first entry
                     {	
                    
                         numStr1= numStr1+ch; //add the number to the first entry
                         equation+=ch;
                         
                     }
                     else if(arithmetic_Input)// if the an arithmetic button has been pressed then go on to the second entry
                     {
                         numStr2=numStr2+ch;
                         equation+=ch;
                        
                     }
                     else if(!arithmetic_Input) //if no arithmetic button has been pressed but their is something in the firstinput then start replacing the firstinput with the new input
                  	 {//this is for when a calculation has already been made and the user enters another number without clearing the field or pressing an arithmetic operator button
                    	firstInput=true;
                 		numStr1="";
                 		equation="";
                 		numStr1= numStr1+ch;
                 		equation+=ch;
                  	 }
                     break;
                   
                 case '+':
                 case '-':
                 case '*':
                 case '/':
                	 if(ch=='+') //add to the total equation so it can be added to the history
                 	{
                 		equation+="+";
                 	}
                 	if(ch=='-')
                 	{
                 		equation+="-";
                 	}
                 	if(ch=='*')
                 	{
                 		equation+="*";
                 	}
                 	if(ch=='/')
                 	{
                 		equation+="/";
                 	}
                 	
                     op = ch;
                     firstInput = false; //the first entry has been completed
                     arithmetic_Input=true; //arithmetic button has been used
                     break;
                   
                 case '=':
                	 
                	 equation+="=";//add to total equation
                     resultStr=evaluate(); //get the result of the expression
                     equation+=resultStr;
                     equation+="\n";
                     
                     displayText_JTF.setText(resultStr); // show the result
                     pastResults_JTA.append(equation);
                     numStr1= resultStr; //set the first input to what the result is incase user wants to continue using it for more calculations
                     numStr2="";
                     equation=resultStr;
                     firstInput = false; //using result as the firstInput
                     arithmetic_Input=false; //arithmetic operator has not been pressed yet, used for catching user error when they 
                     							//enter more numbers in before clearing out the answer or pressing arithmetic operator
                     break;
                   
                 case 'C':
                     displayText_JTF.setText(""); //clear the jtextfield
                     numStr1=""; //reset everything
                     numStr2="";
                     equation="";
                     firstInput= true;
                     break;
                 }
               
             }
               
          
        });
    }
  
   
    public void actionPerformed(ActionEvent e)
    {
        String resultStr;
      
        String str = String.valueOf(e.getActionCommand()); //get the JButton that caused the action
      
        char ch = str.charAt(0); //convert to a char to use in switch statement
      
        switch(ch)
        {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
        case '.':       
            if(firstInput)  //if part of the first number in calculation
            {	
           
                numStr1= numStr1+ch; //continue adding the number to the first number
                equation+=ch;
                displayText_JTF.setText(numStr1); //put the number in the jtextfield
            }
            else if(arithmetic_Input) //check to see if an arithmetic button has been clicked
            {
            	equation+=ch;
                numStr2=numStr2+ch;
                displayText_JTF.setText(numStr2);
            }
            else if(!arithmetic_Input) //check to see if user has entered a number right after performing a previous calculation without clicking clear or an arithmetic button
         	{
            	firstInput=true;
        		numStr1="";
        		equation="";
        		numStr1= numStr1+ch;
        		equation+=ch;
        		displayText_JTF.setText(numStr1);
         	}
            break;
          
        case '+':
        case '-':
        case '*':
        case '/':
        	if(ch=='+')
        	{
        		equation+="+";
        	}
        	if(ch=='-')
        	{
        		equation+="-";
        	}
        	if(ch=='*')
        	{
        		equation+="*";
        	}
        	if(ch=='/')
        	{
        		equation+="/";
        	}
        	
            op = ch;
            firstInput = false; //set to false so it can start building the second number in the calculation
            arithmetic_Input=true;
            break;
          
        case '=':
        	equation+="=";
            resultStr=evaluate();
            equation+=resultStr;
            equation+="\n";
            displayText_JTF.setText(resultStr);
            pastResults_JTA.append(equation);
            
            numStr1= resultStr;
            numStr2="";
            equation=resultStr;
            firstInput = false;
            arithmetic_Input=false;
            
            break;
          
        case 'C':
            displayText_JTF.setText("");
            numStr1="";
            numStr2="";
            equation="";
            firstInput= true;
            break;  
        
      
        }
       
        
        
        if(str.equals("Clear History"))  //reset the JTextArea
        {
        	pastResults_JTA.setText("");
        }
        
    }
  
   
    public String evaluate()  //calculate the value of the arithmetic 
    {
        final char BEEP = '\u0007';
      
        try
        {
            double num1 = Double.parseDouble(numStr1); //convert from a string to a double
            double num2 = Double.parseDouble(numStr2);
            double result =0;
          
            switch(op) //find out which operation to do
            {
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
      
            }
          
            return String.valueOf(result); //return a string of the final result
          
        }
      
        catch(ArithmeticException e) //check for input errors, division by 0;
        {
            System.out.print(BEEP);
            return "ERROR: " + e.getMessage();
        }
      
        catch(NumberFormatException e)
        {
            System.out.print(BEEP);
          
            if(numStr1.equals(""))
            {
                return "ERROR: Invalid First Number";
            }
            else
            {
                return "ERROR: Invalid Second Number";
            }
        }
      
        catch(Exception e)
        {
            System.out.print(BEEP);
            return "ERROR";
        }
    }
 
    public static void main(String[] args)
    {
    	 PersonalTrainer PT = new PersonalTrainer();  //create an instance of PT
    }
  
  
  
}




