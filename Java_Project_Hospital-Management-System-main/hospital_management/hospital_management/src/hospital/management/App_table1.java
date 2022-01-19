package hospital.management;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class App_table1 extends JFrame implements ActionListener

{
    private  JButton buttonback;
    JTable table;
    ResultSet rs;
    dataacess da;
    String userId;
        String username;

    public App_table1()
    {
        	this.setBounds(400,300,700,600);
                buttonback = new JButton("Back");
			buttonback.setBounds(330, 200, 100, 40);
		
			buttonback.addActionListener(this);
			add(buttonback);
			
		
		

		
		
                this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable();
        dataacess da = new dataacess();
        String[] columnNames = new String[] {
            "app_id", "d_id", "p_sick"
        };
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        String query = "select * from appointments";
        rs = da.getData(query);
        try{
            while(rs.next())
            {
                String col1 = rs.getString("app_id");
                String col2 = rs.getString("d_id");
                String col3 = rs.getString("p_sick");                
                model.addRow(new Object[]{col1, col2, col3});
            }
            table.setModel(model);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
              
        this.add(new JScrollPane(table));
         
        this.setTitle("Appoinment Table");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
    }
     
    /*public static void main(String[] args)
    {
        new App_table1();
    }*/
    
    public void actionPerformed(ActionEvent ae)
	{
		String buttonClicked = ae.getActionCommand();
		
		 if(buttonClicked.equals(buttonback.getText()))
		{
			Managerhome l = new Managerhome(userId,username);
			l.setVisible(true);
			this.setVisible(false);

                        
		}
}
}
