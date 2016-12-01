// writer : yoo sun young
// writer's e-mail : luysunyoung9@gmail.com
// version : 0

package ycommonUI.frame;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ycommonUI.panel.control.YControlPanel;
import ycommonUI.panel.monitor.YMonitorPanel;
import ycommonUI.panel.setting.YSettingPanel;

public class YFrame extends JFrame{
	private YControlPanel control_panel;
	private YSettingPanel setting_panel;
	private YMonitorPanel monitor_panel;
	
	public YFrame(){
		init();
	}
	
	public void init(){
		this.setLayout(null);
		
		control_panel = new YControlPanel();
		setting_panel = new YSettingPanel();
		monitor_panel = new YMonitorPanel();
		
		control_panel.setBounds(15,25,control_panel.getWidth(),control_panel.getHeight());
		setting_panel.setBounds(30+control_panel.getWidth(),25,setting_panel.getWidth(),setting_panel.getHeight());
		monitor_panel.setBounds(15,55+control_panel.getHeight(),control_panel.getWidth()+setting_panel.getWidth()+15,monitor_panel.getHeight());
		
		JLabel j1 = new JLabel("[CONTROL]");
		j1.setFont(new Font(Font.SANS_SERIF,0,20));
		JLabel j2 = new JLabel("[SETTING]");
		j2.setFont(new Font(Font.SANS_SERIF,0,20));
		JLabel j3 = new JLabel("[MONITOR]");
		j3.setFont(new Font(Font.SANS_SERIF,0,20));
		
		j1.setBounds(control_panel.getX()+15,control_panel.getY()-20,200,20);
		j2.setBounds(setting_panel.getX()+15,setting_panel.getY()-20,200,20);
		j3.setBounds(monitor_panel.getX()+15,monitor_panel.getY()-20,200,20);
		
		this.add(j1);
		this.add(j2);
		this.add(j3);
		
		this.add(control_panel);
		this.add(setting_panel);
		this.add(monitor_panel);
		
		this.setSize(monitor_panel.getWidth()+45, monitor_panel.getHeight()*2+105);
		this.setVisible(true);
	}
	
	
	
	public YControlPanel getControl_panel() {
		return control_panel;
	}

	public YSettingPanel getSetting_panel() {
		return setting_panel;
	}

	public YMonitorPanel getMonitor_panel() {
		return monitor_panel;
	}

	
	public static void main(String[] args){
		YFrame y = new YFrame();
	}
}
