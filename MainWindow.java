import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import javax.swing.*;

//import ChatClient.SendButtonListener;

public class MainWindow {
	JFrame mainFrame;
	FightPanel enemyPanel;
	FightPanel ownPanel;
	Fleet ownFleet;
	Fleet enemyFleet;
	ButtonPanelListener deployer1;
	ButtonPanelListener deployer2;
	SocketChannel sockChannel;
	JTextArea incoming;
	JTextArea outgoing;
	String gamerName;

	public void go() throws IOException{
		sockChannel = SocketChannel.open();
		sockChannel.connect(new InetSocketAddress("127.0.0.1", 22000));
		sockChannel.configureBlocking(false);
		mainFrame = new JFrame();
		ownFleet = new Fleet();
		enemyFleet = new Fleet();
		CellListener cl = new CellListener();
		enemyPanel = new FightPanel(cl);
		ownPanel = new FightPanel(cl);

		deployer1 = new ButtonPanelListener(ownFleet);
		deployer2 = new ButtonPanelListener(enemyFleet);

		mainFrame.setSize(800, 700);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("SeaWar");

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		mainFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);

		ownFleet = new Fleet();
		ButtonPanel buttonPanel = new ButtonPanel(deployer1);
		buttonPanel.setSize(360, 80);

		SideInfoPanel sidePanel = new SideInfoPanel(deployer1);
		sidePanel.setBounds(250, 20, 120, 240);
		ownPanel.add(sidePanel);
		deployer1.setArrayButton(sidePanel.getArrayButton());

		centerPanel.add(enemyPanel);
		centerPanel.add(ownPanel);
		mainFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

		JPanel menuPanel = new JPanel();
		JPanel chatPanel = getChatPanel();

		mainFrame.getContentPane().add(BorderLayout.EAST, chatPanel);
		mainFrame.getContentPane().add(BorderLayout.NORTH, menuPanel);
		mainFrame.setVisible(true);
		
		gamerName = "Anonymous";
		StartDialog dialog = new StartDialog(mainFrame, gamerName);
		dialog.setVisible(true);

		Selector selector = Selector.open();
		sockChannel.register(selector, SelectionKey.OP_READ);

		Set<SelectionKey> keySet = selector.selectedKeys();
		Iterator<SelectionKey> iter = keySet.iterator();

		ByteBuffer bytebuf = ByteBuffer.allocate(256);
		while(true){
			selector.select();
			System.out.println("сработал game селектор");
			keySet = selector.selectedKeys();
			iter = keySet.iterator();
			SelectionKey key = iter.next();
			SocketChannel sch = (SocketChannel) key.channel();
			sch.read(bytebuf);

			bytebuf.flip();
			//byte[] bytes = new byte[bytebuf.remaining()];
			//bytebuf.get(bytes, 0, bytes.length);

			if(bytebuf.remaining() < 2){
				sch.close();
				System.out.println("канал закрыт");
			} else {
				byte[] bytes = new byte[bytebuf.remaining()];
				bytebuf.get(bytes, 0, bytes.length);

				String data = new String(bytes);
				String msg = data.substring(2);
				msg += '\n';

				incoming.append(msg);
				bytebuf.clear();
				iter.remove();
			}
		}
	}

		public JPanel getChatPanel(){

			// cоздание поля для пришедших сообщений
			incoming = new JTextArea(15, 30);
			incoming.setWrapStyleWord(true);
			incoming.setLineWrap(true);
			incoming.setEditable(false);

			JScrollPane qScroller = new JScrollPane(incoming);
			qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			JPanel scrolPanel = new JPanel();
			scrolPanel.add(qScroller);

			// создание поля для отправки сообщения
			outgoing = new JTextArea(10, 30);
			outgoing.setEditable(true);

			JButton sendButton = new JButton("send");
			SendButtonListener sendListener = new SendButtonListener(outgoing, sockChannel);
			sendButton.addActionListener(sendListener);

			JPanel outPanel = new JPanel();
			outPanel.setLayout(new BorderLayout());

			outPanel.add(BorderLayout.CENTER,outgoing);
			outPanel.add(BorderLayout.SOUTH, sendButton);
			JPanel containerOutPanel = new JPanel();
			containerOutPanel.add(outPanel);

			JPanel chatPanel = new JPanel();
			chatPanel.setLayout(new BorderLayout());
			//chatPanel.setLayout(new GridLayout(3, 1));
			chatPanel.add(BorderLayout.NORTH, scrolPanel);
			chatPanel.add(BorderLayout.CENTER, containerOutPanel);

			return chatPanel;
		}

	}
