
package hospital.management;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener {
    
	public JLabel nameLabel, passLabel,imgLabel;
	public JTextField userNameTF;
	public JPasswordField passPF;
	public JButton buttonLogin, buttonClose,buttonreq_app;
	public JPanel panel;
        public JRadioButton  radiodoc,radiomaj;
	public ButtonGroup bg;
        private ImageIcon img;
        private static final int RIGHT = 0;
        private Font f;
	public boolean flag;
    

public Login()
{ 
	initComponent();	
	}
	public void initComponent(){
       
		
		this.setBounds(400,300,700,600);
		this.setTitle("Login");
		this.setFont(f);
                this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.add(panel);
                panel.setBackground(Color.white);
                
                img = new ImageIcon(getClass().getResource("index.jpg"));
		this.setIconImage(img.getImage());
		
		img = new ImageIcon(getClass().getResource("image.jpg"));
		imgLabel = new JLabel("",img,RIGHT);
		imgLabel.setBounds(400,200,300,275);
		panel.add(imgLabel);
 
		f = new Font("Arial",Font.BOLD,14);
		
                
                
                
                
                
		nameLabel = new JLabel("UserId	: ");
		nameLabel.setBounds(50, 55, 100, 25);
                nameLabel.setFont(f);
		panel.add(nameLabel);
		
		userNameTF = new JTextField();
		userNameTF.setBounds(150, 50, 200, 35);
		panel.add(userNameTF);
		
		passLabel = new JLabel("Password	: ");
		passLabel.setBounds(50, 115, 100, 25);
                passLabel.setFont(f);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(150, 110, 200, 35);
                passPF.setFont(f);
		passPF.setToolTipText("Type Your Password");
		panel.add(passPF);
		
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(50,350,150,50);
                buttonLogin.setFont(f);
		buttonLogin.addActionListener(this);
		panel.add(buttonLogin);
                
            
		
		buttonClose = new JButton("Close");
		buttonClose.setBounds(210,350,150,50);
                buttonClose.setFont(f);
		buttonClose.addActionListener(this);
		panel.add(buttonClose);
		
				
				
				
		
		}
	public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		if(buttonClicked.equals(buttonLogin.getText()))
		{
			System.out.println("hello");
			flag=true;
			check();
		}
		else if(buttonClicked.equals(buttonClose.getText()))
		{
			System.exit(0);
		}
	
	}
	
	public void check()
	{
        String query = "SELECT * FROM `users`;";
       
        
       //PreparedStatement ps;
       //connection con;
       //ResultSet rs;
       String uname=userNameTF.getText();
       String pass=String.valueOf(passPF.getPassword());
       Connection con=null; 
        Statement st = null;  
        ResultSet rs = null;  
       // String query="SELECT * FROM 'user' WHERE 'user_id'=? AND 'password'=?";
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull&useTimezone=True&serverTimezone=UTC","root","");
			System.out.println("connection done");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(query);
			System.out.println("results received");
					
			while(rs.next())
			{
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String pname= rs.getString("p_name");
                String psick= rs.getString("p_sick");
                String userp= rs.getString("user profession");

                
                
               
                
             
                String username= rs.getString("user name");
               String expert= rs.getString("d_expert");
               String dfee= rs.getString("d_fee");
				
				if(userId.equals(userNameTF.getText()))
				{
                                    
					flag=false;
					if(password.equals(passPF.getText()))
					{
						if(userp.equals("Doctor"))
						{
							Doctorhome doc = new Doctorhome(username,userId,expert,pname,psick,dfee);
							this.setVisible(false);
							doc.setVisible(true);
						}
						
                                                else if(userp.equals("Manager"))
                                                {
                                                  Managerhome maj = new Managerhome (userId,username);
							this.setVisible(false);
							maj.setVisible(true);  
                                                }
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid pass"); 
					}
				}			
			}
			if(flag){JOptionPane.showMessageDialog(this,"Invalid name"); }
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    } 
}
