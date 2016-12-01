// writer : yoo sun young
// writer's e-mail : luysunyoung9@gmail.com
// version : 0

package ycommonUI.panel.setting;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YSettingPanel extends JPanel{
	
	private int component_width = 195;
	private int component_height = 40;
	private int component_interval = 20;
	
	private ArrayList<String> name_list;
	private HashMap<String,JLabel> label_map;
	private HashMap<String,JComponent> enter_component_map;
	
	private Font default_font;
	
	public YSettingPanel(){
		init();
	}
	
	public void init(){
		this.setLayout(null);
		
		default_font = new Font("Sanserif",0,20);
		
		name_list = new ArrayList<String>();
		label_map = new HashMap<String,JLabel>();
		enter_component_map = new HashMap<String,JComponent>();
		
		this.setBounds(10,10,450,345);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	

	
	public void addEnterComponent(String name, JComponent newcomponent, int index){
		String result = "";
		
		if (0 <= index && index <= name_list.size()){
			result += "added component at " + index ;
			
			name_list.add(index, name);
		}
		else {
			result += "error : index out of bound. add component the end of the list.";
			 
			name_list.add(name);
		}
		
		JLabel jl = new JLabel(name);
		jl.setFont(default_font);
		label_map.put(name, jl);
		enter_component_map.put(name, newcomponent);
//		
//		System.out.println(result);
	
		renew();
	}
	
	public void addEnterComponent(String name, JComponent newcomponent){
		this.addEnterComponent(name, newcomponent, this.name_list.size());
	}
	
	public JComponent getEnterComponent(String name){
		return this.enter_component_map.get(name);
	}
	
	public HashMap<String,JComponent> getEnterComponent(){
		return this.enter_component_map;
	}
	
	public void renew(){
		for ( int i = 0 ; i < name_list.size() ; i++ ){
			String name = name_list.get(i);
			
			int x = component_interval;
			int y = component_interval*(i+1) + component_height*i;
			
			JLabel lb = label_map.get(name);
			lb.setBounds(x,y,component_width,component_height);
			
			x = x + component_width + component_interval;
			JComponent cp = enter_component_map.get(name);
			cp.setBounds(x,y,component_width,component_height);
			
			this.add(lb);
			this.add(cp);
		}
	}

	public void setComponentInterval(int interval){
		this.component_interval = interval;
		this.renew();
	}
	
	public void setComponentWidth(int width){
		this.component_width = width;
		this.renew();
	}
	
	public void setComponentHeight(int height){
		this.component_height = height;
		this.renew();
	}
	
	public int getComponent_width() {
		return component_width;
	}

	public int getComponent_height() {
		return component_height;
	}

	public int getComponent_interval() {
		return component_interval;
	}
	
	public static void main(String[] args){
		JFrame jf = new JFrame();
		jf.setLayout(null);
		jf.setSize(485, 520);
		YSettingPanel cp = new YSettingPanel();
		
		JComboBox jc = new JComboBox();
		
		cp.addEnterComponent("test",jc);
		jf.add(cp);
		jf.setVisible(true);
	}
	
}
