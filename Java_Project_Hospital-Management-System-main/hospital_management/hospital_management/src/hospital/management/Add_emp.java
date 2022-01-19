package hospital.management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.Font;
import javax.swing.ImageIcon;
import java.sql.*;
class Add_emp extends JFrame implements ActionListener
{
    
   private  JLabel labeld_Name,labeld_Id,labeld_expert,e_profession,e_password,e_fee;
    private JTextField d_nameTF, d_numberTF,P_expertTF,e_professiontf,e_passwordtf,e_feetf;
    	private  JButton buttonLogout,buttonAddDoc,buttonback;
        private  JPanel panel;
         private Font f;
           private ImageIcon img;
         String userId;
        String username;
        public  Add_emp()
        	{
                        this.setBounds(400,50,900,800);
                        this.setTitle("ADD EMPLOYEE");
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel = new JPanel();
		panel.setLayout(null);
                
                f = new Font("Arial",Font.BOLD,18);
                
                img = new ImageIcon(getClass().getResource("index.jpg"));
			this.setIconImage(img.getImage());
                
                labeld_Name = new JLabel("Enter Name : ");
		labeld_Name.setBounds(100,50,150,30);
                labeld_Name.setFont(f);
                panel.add(labeld_Name);
		
		d_nameTF = new JTextField();
		d_nameTF.setBounds(450,50,200,30);
		panel.add(d_nameTF);
                    
                labeld_Id = new JLabel("Enter Id Number : ");
		labeld_Id.setBounds(100,100,200,30);
                 labeld_Id.setFont(f);
		panel.add(labeld_Id);
		
		d_numberTF = new JTextField();
		d_numberTF.setBounds(450,100,200,30);
		panel.add(d_numberTF);
                
                labeld_expert = new JLabel("Employee Expert at: ");
		labeld_expert.setBounds(100,200,200,30);
                 labeld_expert.setFont(f);
		panel.add(labeld_expert);
		
		P_expertTF = new JTextField();
		P_expertTF.setBounds(450,200,200,30);
		panel.add(P_expertTF);
                
                 e_profession = new JLabel("Employee profession : ");
		e_profession.setBounds(100,150,250,30);
                 e_profession.setFont(f);
		panel.add(e_profession);
		
		e_professiontf = new JTextField();
		e_professiontf.setBounds(450,150,200,30);
		panel.add(e_professiontf);
                
                   e_password = new JLabel("New Password : ");
		e_password.setBounds(100,250,150,30);
                e_password.setFont(f);
		panel.add(e_password);
		
		e_passwordtf = new JTextField();
		e_passwordtf.setBounds(450,250,200,30);
		panel.add(e_passwordtf);
                
                e_fee = new JLabel(" Employee fee : ");
		e_fee.setBounds(100,300,150,30);
                 e_fee.setFont(f);
		panel.add(e_fee);
		
		e_feetf = new JTextField();
		e_feetf.setBounds(450,300,200,30);
		panel.add(e_feetf);
                
                
                
                
                buttonAddDoc = new JButton("Add Employee");
		buttonAddDoc.setBounds(150,400, 150, 30);
		buttonAddDoc.addActionListener(this);
		panel.add(buttonAddDoc);
                
                buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(350, 500, 80, 30);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
                
                 buttonback = new JButton("Back");
		buttonback.setBounds(450, 400, 80, 30);
		buttonback.addActionListener(this);
		panel.add(buttonback);
		
		this.add(panel);
                    
                }
        
        public void actionPerformed(ActionEvent ae)
        {
        String buttonClicked = ae.getActionCommand();
		
		 if(buttonClicked.equals(buttonAddDoc.getText()))
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
		String query = "INSERT INTO users VALUES ('"+d_numberTF.getText()+"','"+e_professiontf.getText()+"','"+e_passwordtf.getText()+"','"+d_nameTF.getText()+"','"+P_expertTF.getText()+"','0','0','0','"+e_feetf.getText()+"')";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull&useTimezone=True&serverTimezone=UTC","root","");
			Statement stm = con.createStatement();
			stm.execute(query);
			stm.close();
			con.close();
                        JOptionPane.showMessageDialog(this,"CONGATULATIONS EMPLOYEE HAS BEEN ADDED."); 
					
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
    }
}


