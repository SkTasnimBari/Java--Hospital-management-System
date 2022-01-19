
package hospital.management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Add_app extends JFrame implements ActionListener
{
    private static final int RIGHT = 0;
    private  JLabel labelName,labelId,labelprb,labeldoc,labeldocid,imgLabel,labelc;
    private JTextField p_nameTF, app_numberTF,P_prbTF,P_DocnameTF,P_DocnameidTF;
    	private  JButton buttonLogout,buttonback,buttonInsert;
        private ImageIcon img;
         private Font f,f1;
	private  JPanel panel;
        private String userId;
        private String username;
        
        public  Add_app()
        	{
                   f = new Font("Arial",Font.BOLD,14);	
	        	
	        this.setTitle("hospital Management System - Patient Appointment");
			this.setBounds(500,50,1050, 700);
			this.setFont(f);
	        this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.WHITE);
                        
                         img = new ImageIcon(getClass().getResource("i2.jpg"));
			imgLabel = new JLabel("",img,RIGHT);
			imgLabel.setBounds(600,100,430,200);
			panel.add(imgLabel);
		
                        
                        labelc = new JLabel("APPOINTMENT  FORM");
			labelc.setBounds(400,15,300,50);
			f1 = new Font("Arial",Font.BOLD,18);	
			labelc.setFont(f1);
			panel.add(labelc);
		
		labelName = new JLabel("Enter Patient Name : ");
			labelName.setBounds(30,90,150,30);
			labelName.setFont(f);
			panel.add(labelName);
                
                        
		p_nameTF = new JTextField();
			p_nameTF.setBounds(260,90,250,30);
			p_nameTF.setFont(f);
			panel.add(p_nameTF);
                    
                labelId = new JLabel("Enter Appointment Number : ");
			labelId.setBounds(30,140,250,30);
			labelId.setFont(f);
			panel.add(labelId);
		
		app_numberTF = new JTextField();
			app_numberTF.setBounds(260,140,250,30);
			app_numberTF.setFont(f);
			panel.add(app_numberTF);
                
               labelprb = new JLabel(" Patient Dieases Name : ");
			labelprb.setBounds(27,190,200,30);
			labelprb.setFont(f);
			panel.add(labelprb);
		
		P_prbTF = new JTextField();
			P_prbTF.setBounds(260,190,250,30);
			P_prbTF.setFont(f);
			panel.add(P_prbTF);
                
               labeldoc = new JLabel("Doctor  Name : ");
			labeldoc.setBounds(30,240,150,30);
			labeldoc.setFont(f);
			panel.add(labeldoc);
		
		P_DocnameTF = new JTextField();
			P_DocnameTF.setBounds(260,240,250,30);
			P_DocnameTF.setFont(f);
			panel.add(P_DocnameTF);
	                
                
                labeldocid = new JLabel("Doctor  id : ");
			labeldocid.setBounds(30,295,150,30);
			labeldocid.setFont(f);
			panel.add(labeldocid);
		
		P_DocnameidTF = new JTextField();
			P_DocnameidTF.setBounds(260,290,250,30);
			P_DocnameidTF.setFont(f);
			panel.add(P_DocnameidTF);
                
                buttonInsert = new JButton("Insert");
			buttonInsert.setBounds(410, 370, 100, 40);
			buttonInsert.setFont(f);
			buttonInsert.addActionListener(this);
			panel.add(buttonInsert);
                
                buttonLogout = new JButton("Logout");
			buttonLogout.setBounds(450, 550, 100, 40);
			buttonLogout.setFont(f);
			buttonLogout.addActionListener(this);
			panel.add(buttonLogout);
	                
                
               buttonback = new JButton("Back");
			buttonback.setBounds(330, 550, 100, 40);
			buttonback.setFont(f);
			buttonback.addActionListener(this);
			panel.add(buttonback);
			
		
		this.add(panel);
                
                
                
                
                
                }
        
       public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		 if(buttonClicked.equals(buttonInsert.getText()))
		{
			insertIntoDB();
		}
		else if(buttonClicked.equals(buttonLogout.getText()))
		{
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
                 
                 else if(buttonClicked.equals(buttonback.getText()))
		{
		      Managerhome l = new Managerhome(userId,username);
			l.setVisible(true);
			this.setVisible(false);
		}
	}
	public void insertIntoDB()
	{
		String query = "INSERT INTO appointments VALUES ('"+app_numberTF.getText()+"','"+P_DocnameTF.getText()+"','"+P_DocnameidTF.getText()+"','"+p_nameTF.getText()+"','"+P_prbTF.getText()+"')";
                String query1 = "UPDATE users SET p_name ='"+p_nameTF.getText()+"',p_sick='"+P_prbTF.getText()+"' where user_id="+Integer.parseInt(P_DocnameidTF.getText());
		System.out.println(query);
                System.out.println(query1);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull&useTimezone=True&serverTimezone=UTC","root","");
			Statement stm = con.createStatement();
			stm.execute(query);
                        stm.execute(query1);
			stm.close();
			con.close();
                        JOptionPane.showMessageDialog(this,"CONGATULATIONS YOUR Appointment HAS BEEN CREATED!!"); 
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}
