import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

import javax.swing.JTextArea;


public class SendButtonListener implements ActionListener {

	private JTextArea outgoing;
	private SocketChannel sockChannel;
	ByteBuffer header;
	SendButtonListener(JTextArea out, SocketChannel ch){
		outgoing = out;
		sockChannel = ch;

	}
	
	public void actionPerformed(ActionEvent ev){
		try{
			String str = outgoing.getText();
			byte[] bytes = str.getBytes();
			//char[] buf = str.toCharArray();
		    //byte[] bytes = new byte[buf.length << 1];
		    //CharBuffer cBuffer = ByteBuffer.wrap(bytes).asCharBuffer();
		    //for(int i = 0; i < buf.length; i++)
		        //cBuffer.put(buf[i]);
		    
			//byte[] bytes = str.getBytes();
			// создание заголовка для отличия пустых сообщений 
			// и состояния разъединения
			String s = "bg";
			byte[] byteAr = s.getBytes();
			ByteBuffer header = ByteBuffer.wrap(byteAr);
			
			ByteBuffer buffer = ByteBuffer.wrap(bytes);
			ByteBuffer[] sendBuf = {header, buffer};
			sockChannel.write(sendBuf);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		outgoing.setText("");
		outgoing.requestFocus();
	}
}
