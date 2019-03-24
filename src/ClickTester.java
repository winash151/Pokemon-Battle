import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class ClickTester {
	
	private class RightClicker extends MouseAdapter implements ActionListener{
		private boolean pressed = false;
		private boolean entered = false;
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("hola amigos");
		}
		
		public void mousePressed(MouseEvent e){
			if(e.getButton()==3){
				pressed = true;
			}
		}
		
		public void mouseReleased(MouseEvent e){
			if(e.getButton()==3){
				if(pressed && entered){
					actionPerformed(new ActionEvent(e.getSource(), e.getID(), ""));
				}
				pressed = false;
			}
		}
		
		public void mouseEntered(MouseEvent e){
			entered = true;
		}
		
		public void mouseExited(MouseEvent e){
			entered = false;
		}
	}
	
	
	public ClickTester(){
		JFrame frame = new JFrame("Click Tester");
		JButton button = new JButton(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 2753323407653307693L;

			public void paintComponent(Graphics g){
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		button.setBackground(Color.yellow);
		button.setBorder(null);
		@SuppressWarnings("unused")
		Rectangle e = new Rectangle(400,400);
		frame.setBackground(Color.red);
		frame.setSize(400,400);
		frame.getContentPane().add(button);
		button.setSize(100, 200);
		button.setPreferredSize(new Dimension(100,200));
		button.addMouseListener(new RightClicker());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ClickTester();
	}
}
