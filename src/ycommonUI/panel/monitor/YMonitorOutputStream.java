// writer : yoo sun young
// writer's e-mail : luysunyoung9@gmail.com
// version : 0

package ycommonUI.panel.monitor;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class YMonitorOutputStream extends OutputStream{
	
	private StringBuilder sb;
	private JTextArea textarea;
	
	public YMonitorOutputStream(JTextArea textarea){
		sb = new StringBuilder();
		this.textarea = textarea;
	}

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		if(b == '\r'){
			return ;
		}
		
		else if (b == '\n'){
			String text = sb.toString() + "\n";
			textarea.append(text);
			
			sb.setLength(0);
			return;
		}
		
		sb.append((char) b);
	}

}
