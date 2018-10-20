
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
	private Integer mesin = 0;
	private Integer gear = 0;
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JLabel showLbl = new JLabel("00", JLabel.CENTER);
	private JButton bInc;
	private JButton bDec;
	private JButton onnlur;
	public JLabel label;
	public JLabel label2;
	

	
	public Gasgasan()
	{
		count = 0;
		
		
		panel = new JPanel();
		bInc = new JButton("Pedal Gas");
		bDec = new JButton("Pedal ReM");
		onnlur = new JButton("Mesin");
		label = new JLabel("");
		label2 = new JLabel("Status Mesin");

		
		bInc.addActionListener(new IncreaseCount());
		bDec.addActionListener(new DecreaseCount()); //Ignore this error. You need to write this ActionListener at the bottom.
		onnlur.addActionListener(new Hidupkanmesin());	

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setTitle("Aplikasi Gas Gasan ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() 
	{
		//I added the button "bInc" to the panel here.
		panel.add(onnlur);
		panel.add(bInc); 
		panel.add(bDec);	//TODO:Write some code that adds button "bDec" to the panel.
		panel.add(label);  //TODO:Write some code that adds label "label" to the panel.
		panel.add(label2);
		
		
		//This adds the panel to the class, which is a JFrame.
		this.add(panel);
		
		this.setVisible(true);
	}
	
	public class Hidupkanmesin implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(mesin == 1){
			mesin = 0;
			label2.setText(mesin + " Mesin Dimatikan");
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

	public class IncreaseCount implements ActionListener
	{
	
		public void actionPerformed(ActionEvent e) 
		{
			 if(mesin == 1){

			count++; //TODO:Add some code to increment the counter
			label.setText(count + " KM/H"); //TODO:Add some code to setText() on the label
		}
		}	
		
	}
	
	public class DecreaseCount implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			count = 0;
			label.setText(count + "KM/H");
		}
	}
	//TODO:Add a DecreaseCount class that implements ActionListener here.
		 	//Under ActionPerformed...
			//TODO:Add some code to decrement the counter
			//TODO:Add some code to setText() on the label

	
}