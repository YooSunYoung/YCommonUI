// writer : yoo sun young
// writer's e-mail : luysunyoung9@gmail.com
// version : 0

package ycommonUI.panel.monitor;

import java.awt.Color;
import java.awt.Font;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class YMonitorPanel extends JPanel{
	
	private YMonitorOutputStream monitor_output_stream; // monitor_area's output stream
	private JTextArea text_area; // where the output stream goes.
	
	private JScrollPane monitor_scroll_pane;
	
	private Font default_font;
	
	public YMonitorPanel(){
		init();
	}
	
	public YMonitorPanel(String name){
		init();
		setName(name);
	}
	
	
	public void init(){
		// default font
		default_font = new Font("Sanserif",0,20);
		
		// create fields
		text_area = new JTextArea();
		monitor_output_stream = new YMonitorOutputStream(text_area);
		
		
		// set monitor text area
		text_area.setEditable(false);
		text_area.setFont(default_font);
		
		// add components
		
		monitor_scroll_pane = new JScrollPane(text_area);
		monitor_scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		monitor_scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(monitor_scroll_pane);
		monitor_scroll_pane.setBounds(15,30,880,310);
		
		
		this.setLayout(null);
		this.setBounds(10,10,450,350);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public YMonitorOutputStream getMonitorOutputStream(){
		return this.monitor_output_stream;
	}
	
	public JScrollPane getMonitorScrollPane(){
		return this.monitor_scroll_pane;
	}
	
	public PrintStream getMonitorPrintStream(){
		return new PrintStream(this.monitor_output_stream);
	}
	
	public JTextArea getTextArea(){
		return this.text_area;
	}
	
	
	
	// test 
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(485, 520);
		YMonitorPanel cp = new YMonitorPanel("testhesthest");
		
		System.setOut(new PrintStream(cp.getMonitorOutputStream()));
		
		
		for (int i = 0 ; i < 20 ; i++){		
			System.out.println("zzan");
		}

		jf.add(cp);
		jf.setContentPane(cp);
		jf.setVisible(true);
	}
	
}
