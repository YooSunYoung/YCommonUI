// writer : yoo sun young
// writer's e-mail : luysunyoung9@gmail.com
// version : 0

package ycommonUI.panel.control;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YControlPanel extends JPanel{
	
	private JLabel name_label;
	private JButton start_button;
	private JButton stop_button;
	
	private String name;
	
	private Font default_font;
	
	public YControlPanel(){
		init();
	}
	
	public YControlPanel(String name){
		init();
		setName(name);
	}

	public JButton getStartButton(){
		return this.start_button;
	}
	
	public JButton getStopButton(){
		return this.stop_button;
	}
	
	public JLabel getNameLabel(){
		return this.name_label;
	}
	
	public void init(){
		//create fields
		default_font = new Font(Font.SANS_SERIF,0,20);
		start_button = new JButton("START");
		stop_button  = new JButton("STOP");
		name_label = new JLabel("");
		this.name_label.setFont(default_font);
		start_button.setFont(default_font);
		stop_button.setFont(default_font);
		this.setLayout(null);
		
		// set bounds default size is 450*450 pixel^2
		this.setBounds(10,10,450,345);
		
		// set border
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// set bounds
		name_label.setBounds(15,15,130,40);
		start_button.setBounds(160, 15, 130, 40);
		stop_button.setBounds(305, 15, 130, 40);
		
		// add components
		this.add(name_label);
		this.add(start_button);
		this.add(stop_button);
		
	}
	
	public void clickStart(){
		this.stop_button.setEnabled(true);
		this.start_button.setEnabled(false);
	}
	
	public void clickStop(){
		this.stop_button.setEnabled(false);
		this.start_button.setEnabled(true);
	}
	
	
	public void setName(String name){
		this.name = name;
		this.name_label.setText(name);
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(485, 520);
		YControlPanel cp = new YControlPanel("testhesthest");
		jf.add(cp);
		jf.setVisible(true);
	}

	
	
}
