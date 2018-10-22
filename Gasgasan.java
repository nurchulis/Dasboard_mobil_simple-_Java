import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Gasgasan extends JFrame {

	private final int FRAME_WIDTH = 350;
	private final int FRAME_HEIGHT = 400;
	private int count = 0;
	private int rpm = 0;
	private int i  = 1;
	
	private Integer mesin = 0;
	private Integer gear = 0;
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel showLbl = new JLabel("00", JLabel.CENTER);
	private JButton bInc;
	private JButton bDec;
	private JButton onnlur;
	private JButton gearup;
	private JButton geardown;
	public JLabel label;
	public JLabel label2;
	public JLabel label3;
	public JLabel label4;
	

	
	public Gasgasan()
	{
		count = 0;
		rpm   = 0;
		
		
		panel = new JPanel();
		bInc = new JButton("Pedal Gas");
		bDec = new JButton("Pedal ReM");
		onnlur = new JButton("Mesin");
		gearup = new JButton("Gear Up");
		geardown = new JButton("Gear down");
		label = new JLabel("");
		label2 = new JLabel("");
		label3 = new JLabel("");
		label4 = new JLabel("");

		
		bInc.addActionListener(new Gas());
		bDec.addActionListener(new Rem()); //Ignore this error. You need to write this ActionListener at the bottom.
		onnlur.addActionListener(new Hidupkanmesin());	
		gearup.addActionListener(new Gearup());
		geardown.addActionListener(new Geardown());

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Aplikasi Gas Gasan ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() 
	{	

		panel.add(gearup);
		panel.add(geardown);
		panel.add(onnlur);
		panel.add(bInc); 
		panel.add(bDec);	//TODO:Write some code that adds button "bDec" to the panel.
		panel.add(label);  //TODO:Write some code that adds label "label" to the panel.
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public class Hidupkanmesin implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(mesin == 1){
			mesin = 0;
			label2.setText("Mesin Dimatikan");
			count = 0;
				rpm = 0;
				label3.setText("RPM :" + rpm);
			label.setText(count + "KM/H");
			}else if(mesin == 0){
			mesin = 1;
			label2.setText("Mesin Hidup");

			}
		}
	}
	public class Gearup implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(mesin == 1 && gear <= 4 ){
			gear++;
			label4.setText(gear + "");		
			}
		
		}
	}
	public class Geardown implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(mesin == 1 && gear >= 1 && gear <= 5){
			
			if(gear <= 1){
			gear--;
			count = 0;
			label.setText(count + "");
			label4.setText(gear + "");		
			}
			if(gear >= 2) {
			gear--;
			count = 20;
			label.setText(count + "");
			label4.setText(gear + "");
			}
			if(gear >= 3) {
			gear--;
			count = 20;
			label.setText(count + "");
			label4.setText(gear + "");	
			}
			if(gear == 4) {
				gear--;
			count = 30;
			label.setText(count + "");
			label4.setText(gear + "");
			}
			if (gear == 5) {
				gear--;
			count = 40;
			label.setText(count + "");
			label4.setText(gear + "");
			}

		}
		
		}
	}

	public class Gas implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e) 
		{
			 if(mesin == 1){
			 	if(gear == 0){
				rpm++;
				label3.setText("RPM :" + rpm);	 		
			 	}
			 	if (gear == 1) {
			 	
			 	if(count < 20){
					count++;
					label.setText(count +"KM/H");
					rpm = 0;
					label3.setText("RPM :" + rpm);	
				}
			 	}
			 	if(gear == 2){
				if(count < 40){
					count++;
					label.setText(count +"KM/H");
				}	
				}
				if(gear == 3){
				if(count < 80){
					count++;
					label.setText(count +"KM/H");
				}	
				}
				if(gear == 4){
				if(count < 100){
					count++;
					label.setText(count +"KM/H");
				}	
				}
				if(gear == 5){
				if(count < 130){
					count++;
					label.setText(count +"KM/H");
				}	
				}

				
		}
			
		}
		
	}
	
	public class Rem implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			count = 0;
			label.setText(count + "KM/H");
		}
	}
	

	
}