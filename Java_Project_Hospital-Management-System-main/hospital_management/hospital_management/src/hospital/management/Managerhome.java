package hospital.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.awt.Font;
import javax.swing.ImageIcon;

public class Managerhome extends JFrame implements ActionListener {
	
		private static final int RIGHT = 0;
		private  JLabel labelWelcome,labelName,imgLabel;
	    private  JButton buttonLogout,buttonAddDoc,buttonremDoc,buttonAddapp,buttonSearch,b1,b2;
	    private  JPanel panel;
	    private Font f,f1;
	    private ImageIcon img;
	    String username;
	       
		public Managerhome(String userId, String username)
		
		{ 
	            
			this.setBounds(400,50,900,800);
                         this.setTitle("MANAGER HOME");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel = new JPanel();
			panel.setLayout(null);
			this.add(panel);
			
			f = new Font("Arial",Font.BOLD,18);
			
			
			img = new ImageIcon(getClass().getResource("index.jpg"));
			this.setIconImage(img.getImage());
			
			img = new ImageIcon(getClass().getResource("management.jpg"));
			imgLabel = new JLabel("",img,RIGHT);
			imgLabel.setBounds(500,200,300,350);
			panel.add(imgLabel);
			
			labelWelcome = new JLabel("WELCOME TO HOSITAL MANAGEMENT");
			f1 = new Font("Arial",Font.BOLD,20);
			labelWelcome.setFont(f1);
			labelWelcome.setBounds(250, 60, 400, 60);
			panel.add(labelWelcome);
			
			labelName = new JLabel(" * Manager Name	  :	   "   +username);
			labelName.setBounds(140, 200, 400, 30);
			//f = new Font("Arial",Font.BOLD,17);
			labelName.setFont(f);
			panel.add(labelName);
			
	                
	                
	        buttonAddDoc = new JButton("ADD EMPLOYEE");
			buttonAddDoc.setBounds(140, 300, 300, 40);
			//f = new Font("Arial",Font.BOLD,17);
			buttonAddDoc.setFont(f);
			buttonAddDoc.addActionListener(this);
			panel.add(buttonAddDoc);
	                
	                
	        buttonremDoc = new JButton("REMOVE EMPLOYEE");
			buttonremDoc.setBounds(140, 360, 300, 40);
			buttonremDoc.setFont(f);
			buttonremDoc.addActionListener(this);
			panel.add(buttonremDoc);
	                
	                 
	        buttonAddapp = new JButton("ADD APPOINMENT");
	        buttonAddapp.setFont(f);
			buttonAddapp.setBounds(140, 430, 300, 40);
			buttonAddapp.addActionListener(this);
			panel.add(buttonAddapp);
	                
	        buttonSearch = new JButton("SEARCH");
			buttonSearch.setBounds(140, 490, 300, 40);
			buttonSearch.setFont(f);
			buttonSearch.addActionListener(this);
			panel.add(buttonSearch);

	                
	        buttonLogout = new JButton("LOGOUT");
			buttonLogout.setBounds(140, 670, 300, 40);
			buttonLogout.setFont(f);
			panel.add(buttonLogout);
			 buttonLogout.addActionListener(this);
                         
                     b1 = new JButton("EMPLOYEE LIST");
			b1.setBounds(140, 550, 300, 40);
			b1.setFont(f);
			panel.add(b1);
			b1.addActionListener(this);
                         
                        b2 = new JButton("APPOINTENT LIST");
			b2.setBounds(140, 610, 300, 40);
			b2.setFont(f);
			panel.add(b2);
			 b2.addActionListener(this);
		    
		    
		    this.username= username;
	                 
	               
	                
			
			
	
	               
			
		}

	public void actionPerformed(ActionEvent ae){
        String buttonClicked = ae.getActionCommand();
		
		
	
        
		if(buttonClicked.equals(buttonLogout.getText()))
		{
                    Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
			
		}
                
              else  if(buttonClicked.equals(buttonAddDoc.getText()))
		{
			Add_emp emp = new Add_emp ();
			this.setVisible(false);
			emp.setVisible(true);
		}
                
                 else  if(buttonClicked.equals(buttonAddapp.getText()))
		{
                    Add_app pat = new Add_app ();
			this.setVisible(false);
			pat.setVisible(true);
			
		}
                 else  if(buttonClicked.equals(buttonremDoc.getText()))
		{
			Rem_doc pat = new Rem_doc ();
			this.setVisible(false);
			pat.setVisible(true);
		}
                
                 else  if(buttonClicked.equals(buttonSearch.getText()))
		{
			Search3 pat = new Search3 ();
			this.setVisible(false);
			pat.setVisible(true);
		}
                else  if(buttonClicked.equals(b1.getText()))
		{
			Emp_table1 pat = new Emp_table1 ();
			this.setVisible(false);
			pat.setVisible(true);
		}
                else  if(buttonClicked.equals(b2.getText()))
		{
			App_table1 pat = new App_table1 ();
			this.setVisible(false);
			pat.setVisible(true);
		}
                
                
                
                
               }
}
    
    

