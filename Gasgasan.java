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
	
	private Integer mesin = 0;
	private Integer gear = 0;
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel showLbl = new JLabel("00", JLabel.CENTER);
	private JButton bInc;
	private JButton bDec;
	private JButton onnlur;
	public JLabel label;
	public JLabel label2;
	public JLabel label3;
	

	
	public Gasgasan()
	{
		count = 0;
		rpm   = 0;
		
		
		panel = new JPanel();
		bInc = new JButton("Pedal Gas");
		bDec = new JButton("Pedal ReM");
		onnlur = new JButton("Mesin");
		label = new JLabel("");
		label2 = new JLabel("");
		label3 = new JLabel("");

		
		bInc.addActionListener(new Gas());
		bDec.addActionListener(new Rem()); //Ignore this error. You need to write this ActionListener at the bottom.
		onnlur.addActionListener(new Hidupkanmesin());	

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Aplikasi Gas Gasan ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() 
	{
		panel.add(onnlur);
		panel.add(bInc); 
		panel.add(bDec);	//TODO:Write some code that adds button "bDec" to the panel.
		panel.add(label);  //TODO:Write some code that adds label "label" to the panel.
		panel.add(label2);
		panel.add(label3);
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
			label.setText(count + "KM/H");
			}else if(mesin == 0){
			mesin = 1;
			label2.setText("Mesin Dinyalakan");

			}
		}
	}
	public class SetRPM implements ActionListener
	{
		public void actionPerformed(ActionEvent e){

		}
	}

	public class Gas implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e) 
		{
			 if(mesin == 1){

			count++; //TODO:Add some code to increment the counter
			label.setText(count + " KM/H"); //TODO:Add some code to setText() on the label
		}
			if(mesin == 0){
			rpm++;
			label3.setText("RPM :" + rpm);
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