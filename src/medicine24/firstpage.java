package medicine24;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableCell;

import com.mysql.cj.xdevapi.Statement;

public class firstpage extends JFrame implements ActionListener{
	public static void main (String[] args) {
		new firstpage();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static String url="jdbc:mysql://localhost:3306/medidata?serverTimezone=UTC";
	static String user="root";
	static String pwd="asdf1324";
	

	
	private PreparedStatement pstmt1 = null;
    private ResultSet rs1 = null;
	    private PreparedStatement pstmt = null;
	    private ResultSet rs = null;
	    private PreparedStatement pstmt2 = null;
	    private ResultSet rs2 = null;
	    Vector<String> search1 = new Vector<String>();
	    Vector<String> search2 = new Vector<String>();

	    
	 	 
	  
	    
		
	    
	    JPanel jp = new JPanel();
	    private String colNames[] = {"제품명","성분", "확인"};  // 테이블 컬럼 값들
        private DefaultTableModel model = new DefaultTableModel(colNames, 0){
        	
        	
            public boolean isCellEditable(int i, int c){
                return false;
               }
              };;
        
	     
		JFrame jf = new JFrame();
		JTextField jt1 = new JTextField();
		JLabel jl1 = new JLabel("검색할 성분:" );
		JTextField jt2 = new JTextField();
		JLabel jl2 = new JLabel("제외할 성분:" );
		JTextField jt3 = new JTextField();
		JLabel jl3 = new JLabel("한국 의약품으로 검색하기: " );
		
		String t[] = {"감기약", "해열제","진통제"};
		JComboBox<String> typee= new JComboBox<String>(t);
		
	
		JButton search = new JButton("검색");
	
		
		JTable tb = new JTable(model);  
		JScrollPane scrollPane = new JScrollPane(tb); 
		
		
		String aa= "자세히보기";

		JLabel jll0 = new JLabel();
		  JLabel jll1 = new JLabel();
		    JLabel jll2 = new JLabel();
		    JLabel jll3 = new JLabel();
		    JLabel jll4 = new JLabel();  
			
		    JLabel jll5 = new JLabel();
		    JTextArea jll6 = new JTextArea("1. 다음과 같은 사람들을 위해 복용하지 마십시오.\n(1)본제 또는 본약의 성분등에 의해 알레르기 증상을 일으켰던 적이 있는 사람.　\n(2)본약, 다른 감기약, 해열진통약의 복용으로 천식을 일으켰던 적이 있는 사람. \n2.이 약을 복용하는 동안 다음 약을 사용하지 마십시오.　\n3. 다른 감기약, 해열진통제, 진정제, 거담담제, 항히스타민제가 함유된 내복약(비염, 멀미, 알레르기약 등)을 복용한 후에는 차량이나 기계를 운전하지 마십시오.　(졸음이 나타날 수 있습니다.)     \n4. 복용 전후에 술을 마시지 마십시오. \n5. 장시간 지속적으로 사용하지 마십시오.\r\n"
		    		+ "1. 다음 사람은 복용하지 않는 것 \n(1)본제 또는 본제의 성분에 의해 알레르기 증상을 일으켰던 적이 있는 사람.　\n(2)본제 또는 다른 감기약 또는 해열진통약을 복용하여 천식을 일으켰던 적이 있는 사람. \n2.본제를 복용하는 동안은 다음 어느 의약품도 사용하지 않는 것. 기타 감기약, 해열진통제, 진정제, 진해제거담제, 항히스타민제를 함유한 내복약 등(비염, 병태병, 알레르기약 등 내복약) \n3. 복용 후 차량이나 기계를 조작하지 마십시오 (졸음 등이 나타날 수 있습니다.) \n4. 복용 전후에 술을 마시지 마십시오 \n5. 장시간 지속적으로 사용하지 마십시오.\r\n"
		    		+ "\r\n"
		    		+ ""
		    		+ "");
		
		
	
	
		
		

	public firstpage() {
		
try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con = DriverManager.getConnection(url,user,pwd);
			  
			 
			  System.out.println("DB연결됨");
		}
		 catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		
		
		
		
		
	
           // 테이블에 마우스리스너 연결
          
		  jf.setSize(650, 500);
	      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      jp.setLayout(null);
	      jf.add(jp);
	      
	      jp.add(jt1);
	      jp.add(jt2);
	      jp.add(jl1);
	      jp.add(jl2);
	      jp.add(jt3);
	      jp.add(jl3);
	      jp.add(search);
	      jp.add(typee);
	      jp.add(tb);
	      jp.add(scrollPane);
	      
	      
	      jl1.setLocation(20,25);
	      jl1.setSize(100,20);
	      jt1.setSize(100,20);
	      jt1.setLocation(100,25);
	      search.setLocation(100, 150);
	      jl2.setLocation(20, 60);
	      jl2.setSize(100,20);
	      jt2.setSize(100,20);
	      jt2.setLocation(100,60);
	      typee.setLocation(20, 100);
	      typee.setSize(100,20);
	      search.setSize(80,20);
	      tb.setSize(300,410);
	      tb.setLocation(290,10);
	     
	      jt1.addActionListener(this);
	      jt2.addActionListener(this);
	      search.addActionListener(this);
	      typee.addActionListener(this);
	      
	      
	      JLabel sub = new JLabel("mg");
	      JLabel sub2 = new JLabel("부작용: ");
	
		  
		    ArrayList<String> list = new ArrayList<String>();
	     
	      
	      jf.setVisible(true);
	      
	      tb.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
					  if(e.getClickCount() == 2) { 
						  
						  int row = tb.getSelectedRow();
					      TableModel data = tb.getModel();
					      String a = (String)data.getValueAt(row,0);
						  String b;
					      JTextArea ta = new JTextArea("");
					      
						  
						  try{
							  
							  
					    	  Connection con = DriverManager.getConnection(url,user,pwd);
					    	  
					    	  String mmain = "SELECT * FROM medii WHERE jname LIKE '%"+a+"%'";
								
					    	  pstmt1= con.prepareStatement(mmain);
							  rs1 = pstmt1.executeQuery();
							   
							   while (rs1.next()) {
								   
								   jll0.setText(rs1.getString("jname"));
								   jll1.setText(rs1.getString("main"));
								   jll2.setText(rs1.getString("maina"));
								   jll3.setText(rs1.getString("sef"));
								   jll4.setText(rs1.getString("type1"));
								   jll5.setText(rs1.getString("addi"));
								   
								   
								  
								    
								   }

							 
							 
					      
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					  
						  JFrame jf2 = new JFrame();
						  JPanel jp2 = new JPanel();
						  
						  jf2.setSize(650, 500);
					    jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					    JScrollPane js2 = new JScrollPane();
					    jp2.setLayout(null);
					    jf2.add(jp2);
					    jp2.add(sub);
					    jp2.add(sub2);
					    jp2.add(jll0);
					    jp2.add(jll1);
					    jp2.add(jll2);
					    jp2.add(jll3);
					    jp2.add(jll4);
					    jp2.add(jll5);
					
					    jp2.add(jll6);
					    jp2.add(js2);
					    jll0.setBounds(20,170,1000,20);
					    jll1.setBounds(20,200,300,20);
					    jll2.setBounds(120,200,300,20);
					    jll5.setBounds(20, 220, 1000,20);
					    sub.setBounds(140, 200, 300,20);
					    jll6.setBounds(20, 300, 1000,500);
					 
					    
					    
					    sub2.setBounds(20, 250, 50,20);
					    jll3.setBounds(70, 250, 300,20);
					    
					    jll4.setBounds(20,275,300,20);
					    
					    jf2.setVisible(true);
					    
						
						

					    String click="";
					    
					    
					   
							
							
							
					  
					  
					  
					  
					 
					
					  
				    
				 
				    
	            
	      
	      
	      
	      }}});
	      
	      
}
		
	
	            
	      

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		if(e.getSource()==search) {//버튼눌렀을때
			if(jt1.getText().length()<1) {//필요성분 입력x
				if(jt2.getText().equals("")) {//제외x
					
				
					try {

						Connection con = DriverManager.getConnection(url,user,pwd);
						  String q1 = "SELECT * FROM medii WHERE type1 LIKE '%"+typee.getSelectedItem().toString()+"%' ORDER BY maina DESC";
						  
						  pstmt= con.prepareStatement(q1);
						   rs = pstmt.executeQuery();
						   
						   while (rs.next()) {
							   
							    
							   model.addRow(new Object[] {rs.getString("jname"), rs.getString("main")+aa});
							   
							   }
						   
						  
						   

						}catch (SQLException e2) {
					        // TODO Auto-generated catch block
					        System.out.println("[에러] : " + e2.getMessage());
					    }
					
				}
				
			}
			else if((jt1.getText().length()>=1)){model.setNumRows(0);//필요성분입력
				if(jt2.getText().equals("")) {//제외x
					try {

						Connection con = DriverManager.getConnection(url,user,pwd);
						  String q1 = "SELECT * FROM medii WHERE ( main LIKE '%"+jt1.getText()+"%' AND type1 LIKE '%"+typee.getSelectedItem().toString()+"%') ORDER BY un7 DESC";
						  
						  pstmt= con.prepareStatement(q1);
						   rs = pstmt.executeQuery();
						   
						   while (rs.next()) {
							   
							    
							   model.addRow(new Object[] {rs.getString("jname"), rs.getString("main")+aa});
							   
							   }
						   
						  
						   

						}catch (SQLException e2) {
					        // TODO Auto-generated catch block
					        System.out.println("[에러] : " + e2.getMessage());
					    }
					
					
				       
				}
				
				else if(!jt2.getText().equals("")){ model.setNumRows(0);
					  
					try {
						
						Connection con = DriverManager.getConnection(url,user,pwd);
						String q2 = "SELECT * FROM medii WHERE (main LIKE '%"+jt1.getText()+"%' AND type1 LIKE'%"+typee.getSelectedItem().toString() +"%' AND main NOT LIKE '%"+jt2.getText()+"%') ORDER BY un7 DESC";
						  
						  pstmt2 = con.prepareStatement(q2);
						 rs2 = pstmt2.executeQuery();
						
						
						   while (rs2.next()) {
							 
							   model.addRow(new Object[] {rs2.getString("jname")+aa});
							    
							 
							   }
						   
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
					   
					
					
					
					//필요성분 종류 제외 모두
				}
				
			

			

					
			}}
			
	}

		

	   
	
	  


}




