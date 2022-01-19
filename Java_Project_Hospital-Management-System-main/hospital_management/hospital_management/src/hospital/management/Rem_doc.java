package hospital.management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class Rem_doc extends JFrame implements ActionListener
{
    private  JLabel labelId;
     private JTextField DocIDTF;
    	private  JButton buttonback,buttonremDoc;
        private  JPanel panel;
        private String userId;
        private String username;
        private Font f;
        
        public  Rem_doc()
        	{     
                    f=new Font ("Arial",Font.BOLD,17);
                    
                      
		this.setTitle("Hospital Management System");
				this.setBounds(500,50,700,500);
				this.setFont(f);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
                panel.setBackground(Color.lightGray);
                
                labelId = new JLabel("Enter Id  :   " );
				labelId.setBounds(60,44,150,50);
				labelId.setFont(f);
				panel.add(labelId);
		
		DocIDTF = new JTextField();
				DocIDTF.setBounds(170,50,210,35);
				DocIDTF.setFont(f);
				panel.add(DocIDTF);
                
                 buttonremDoc = new JButton("REMOVE EMPLOYEE");
				buttonremDoc.setBounds(100, 300, 200, 40);
				buttonremDoc.setFont(f);
				buttonremDoc.addActionListener(this);
				panel.add(buttonremDoc);
                
               buttonback = new JButton("BACK");
				buttonback.setBounds(310, 300, 200, 40);
				buttonback.setFont(f);
		        buttonback.addActionListener(this);
				panel.add(buttonback);
                
                this.add(panel);
                    
                }
        
        public void actionPerformed(ActionEvent ae)
        {
        String buttonClicked = ae.getActionCommand();
		
		 if(buttonClicked.equals(buttonremDoc.getText()))
		{
			insertIntoDB();
		}
		
                 else if(buttonClicked.equals(buttonback.getText()))
		{
			 Managerhome maj = new Managerhome(userId,username);
			maj.setVisible(true);
			this.setVisible(false);
		}
        
        
        }
        public void insertIntoDB()
	{
            String query = "DELETE from users where user_id="+Integer.parseInt(DocIDTF.getText());
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull&useTimezone=True&serverTimezone=UTC","root","");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
                        JOptionPane.showMessageDialog(this,"Alas!!the employee hass been terminated"); 
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}

