package hospital.management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
class Doctorhome extends JFrame implements ActionListener
{
      private static final int RIGHT = 0;
    private  JLabel labelWelcome,labelName,labelid,labelexpert,labelid1,label2,label3,label4,label5,imgLabel;
    	private  JButton buttonLogout ;
       private Font f,f1;
        private ImageIcon img;
	private  JPanel panel;
        String appid,pname,psick,d_fee;
        
      
        
       
	public Doctorhome(String username,String userId, String expert,String pname,String psick, String d_fee)
	{
             
            
		this.setBounds(400,50,1000,950);
		this.setTitle("DOCTOR HOME");
		this.setFont(f);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
                panel.setBackground(Color.WHITE);
                
                f = new Font("Arial",Font.BOLD,17);
                
                img = new ImageIcon(getClass().getResource("index.jpg"));
		this.setIconImage(img.getImage());
		
		img = new ImageIcon(getClass().getResource("images.jpg"));
		imgLabel = new JLabel("",img,RIGHT);
		imgLabel.setBounds(350,50,750,700);
		panel.add(imgLabel);
		
		labelWelcome = new JLabel("DOCTOR HOMEPAGE");
		labelWelcome.setBounds(400, 50, 200, 30);
                f1 = new Font("Arial",Font.CENTER_BASELINE,18);
                labelWelcome.setFont(f1);
		panel.add(labelWelcome);
		
               labelName = new JLabel("Doctor Name	 : "+username);
		labelName.setBounds(150, 160, 200, 30);
                labelName.setFont(f);
		panel.add(labelName);
                
                 labelid = new JLabel("Doctor Id	:    "+userId);
		labelid.setBounds(150, 210, 200, 30);
                labelid.setFont(f);
		panel.add(labelid);
                
                  labelexpert = new JLabel("Doctor Expert at	    :	   "+expert);
		labelexpert.setBounds(150, 265, 300, 30);
                labelexpert.setFont(f);
		panel.add(labelexpert); 
                
                 label5 = new JLabel("Doctor Fee   :	"+d_fee);
		label5.setBounds(150, 330, 300, 30);
                label5.setFont(f);
		panel.add(label5);
                
                label2 = new JLabel("APPOINMENT OF PATIENT");
		label2.setBounds(400,540, 250, 30);
                f1 = new Font("Arial",Font.CENTER_BASELINE,18);
                label2.setFont(f1);
		panel.add(label2);
                
                
               label3 = new JLabel("* Patient Name	:  "+pname);
		label3.setBounds(150, 620, 200, 30);
                label3.setFont(f);
		panel.add(label3);
                
                label4 = new JLabel(" * Patient Disease	  :  "+psick);
		label4.setBounds(150, 700, 300, 30);
                label4.setFont(f);
		panel.add(label4);
               
                
                
             
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(320, 850, 150, 40);
                buttonLogout.setFont(f1);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
                 
               
                
		
		
		this.add(panel);
               
		
	}
	public void actionPerformed(ActionEvent ae){
        String buttonClicked = ae.getActionCommand();
		
		
	
		if(buttonClicked.equals(buttonLogout.getText()))
		{
                    Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
			
		}
               
                
                
               }
}
