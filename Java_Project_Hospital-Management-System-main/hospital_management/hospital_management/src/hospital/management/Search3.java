package hospital.management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Search3 extends JFrame implements ActionListener{
   private JLabel JL_fname,JL_lname,JL_age,JL_id;
   private JLabel JT_fname1,JT_lname1,JT_age1,JL_sick,JL_sick1;
   private JPanel panel;
    private Font f;
    private JTextField JT_id;
    private String userId;
        private String username;
    
   private  JButton btn_search,btn_back;

      public Search3(){
          
          f = new Font("Arial",Font.BOLD,17);
          
            this.setTitle("Hospital Management - Search Appointment");
	         this.setBounds(500,50,700, 600);
	         this.setFont(f);
	         this.setResizable(false);
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         
               panel = new JPanel();
			 panel.setLayout(null);
			 this.add(panel);
			 panel.setBackground(Color.lightGray);           
         
          JL_id = new JLabel("Appointment Number :" );
	          JL_id.setBounds(40, 30, 200, 30);
	          JL_id.setFont(f); 
	          panel.add(JL_id);
          
          JT_id = new JTextField();
	          JT_id.setBounds(260, 30, 150, 30);
	          JT_id.setFont(f);
	          panel.add(JT_id);
          
          btn_search = new JButton("Search");
	          btn_search.setBounds(490, 33, 100, 25);
	          btn_search.setFont(f);
	          panel.add(btn_search);
	          btn_search.addActionListener(this);
          
           btn_back = new JButton("Back");
	          btn_back.setBounds(280, 500, 100, 25);
	          btn_back.setFont(f);
	          panel.add(btn_back);
	         btn_back.addActionListener(this);
          
           
         
         JL_fname = new JLabel("Doctor Name : ");
	          JL_fname.setBounds(40, 80, 200, 30);
	          JL_fname.setFont(f);
	          panel.add(JL_fname);
          
          JT_fname1 = new JLabel();
          JT_fname1.setBounds(260, 80, 200, 30);
          
          JL_lname = new JLabel("Doctor id : ");
          JL_lname.setBounds(37, 140, 200, 30);
           JL_lname.setFont(f);
	          panel.add(JL_lname);
          
          JT_lname1 = new JLabel();
          JT_lname1.setBounds(257, 140, 200, 30);
          panel.add(JT_lname1);
          
          JL_age = new JLabel("Patient Name :  ");
          JL_age.setBounds(37, 200, 200, 30);
          JL_age.setFont(f);
          panel.add(JL_age);
          
          JL_sick = new JLabel("Patient Dieases: ");
          JL_sick.setBounds(37, 255, 200, 30);
          JL_sick.setFont(f);
          panel.add(JL_sick);
          
          JL_sick1 = new JLabel();
          JL_sick1.setBounds(257, 255, 200, 30);
          panel.add(JL_sick1);
          
          JT_age1 = new JLabel();
          JT_age1.setBounds(257, 200, 200, 30);
          panel.add(JT_age1);
          
          setLayout(null);
          
          add(btn_search);
          add(btn_back);
          add(JL_fname);
          add(JT_fname1);
          add(JL_lname);
          add(JT_lname1);
          add(JL_age);
          add(JT_age1);
          add(JL_id);
          add(JT_id);
          add(JL_sick);
          add(JL_sick1);
    }

    
    public void actionPerformed(ActionEvent e) { 
    Function f = new Function();
    ResultSet rs = null;
    String fn = "d_name";
    String ln = "d_id";
    String ag = "p_id";
    
    String buttonClicked = e.getActionCommand();
    
    if(buttonClicked.equals(btn_back.getText()))
		{
			Managerhome l = new Managerhome(userId,username);
			l.setVisible(true);
			this.setVisible(false);
		}
    
    rs = f.find(JT_id.getText());
    try{
      if(rs.next()){
          JT_fname1.setText(rs.getString("d_name"));
            JT_lname1.setText(rs.getString("d_id"));
              JT_age1.setText(rs.getString("p_name"));
              JL_sick1.setText(rs.getString("p_sick"));
      }  else{
          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
      }
    }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
   public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?zeroDateTimeBehavior=convertToNull&useTimezone=True&serverTimezone=UTC","root","");
           ps = con.prepareStatement("select * from appointments where app_id = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   }

    
}

