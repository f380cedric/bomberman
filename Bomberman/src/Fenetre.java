import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements KeyListener{
	
	public Panneau pan = new Panneau();
	JTextField KeyCodeT = new JTextField("Key Code:");


	//Constructeur de la simple fenêtre
	public Fenetre(){		
		this.addKeyListener(this);
		
		this.setTitle("Animation");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		
		//"Charge" le contenu JPanel sur la page
		this.setContentPane(pan);
		this.setVisible(true);
		
		//Recharge la page
		go();
	}
	
	/////////////////
	//Lorsqu'une touche est appuy�e
	public void keyPressed(KeyEvent e){
		int x = pan.getPosX();
		int y = pan.getPosY();
		 
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			 pan.setPosX(x+10);
		 if(e.getKeyCode()==KeyEvent.VK_LEFT)
			 pan.setPosX(x-10);
		 
		 if(e.getKeyCode()==KeyEvent.VK_UP)
			 pan.setPosY(y-10);
		 if(e.getKeyCode()==KeyEvent.VK_DOWN)
			 pan.setPosY(y+10);
	}
	
	//Touche lach�e
	public void keyReleased(KeyEvent e){
	}
	
	public void keyTyped(KeyEvent e){
	
	
}
	
	
	
	
	
	
	
	
	private void go(){  
		while(true){
			//On redessine notre Panneau
		      pan.repaint();
		      try {
		        Thread.sleep(3);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		}
	}
}

  
