import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Fenetre extends JFrame implements KeyListener{
	
	//coucou Nico // Coucou baby
	public Panneau pan;


	//Constructeur de la simple fenêtre
	public Fenetre(){		
		this.addKeyListener(this);
		pan = new Panneau();
				
		//Propre � JFrame
		this.setTitle("Bomberman !");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Conteneur utile
		pan.setPreferredSize(new Dimension(600,600));
		
		//Ajoute le contenu JPanel
		this.setContentPane(pan);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//Recharge la page
		go();
	}
	
	/////////////////
	//Lorsqu'une touche est appuyée
	//Le check permet de ne rien faire si un block est la ou on
	//veut aller
	public void keyPressed(KeyEvent e){
		int x = pan.getPosX();
		int y = pan.getPosY();
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT && x < 14)
			if(check(x+1,y))
				pan.setPosX(x+1);
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT && x > 0)
			if(check(x-1,y))
				pan.setPosX(x-1);
		 
		if(e.getKeyCode()==KeyEvent.VK_UP && y > 0)
			if(check(x,y-1))
				pan.setPosY(y-1);
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN && y < 14)
			if(check(x,y+1))
				pan.setPosY(y+1);	

		//BOMBAAA
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
				pan.board.table[x][y] = new Bomb(x,y,pan);	// Rajout de pan en argument
	}
	
	//Check si pas de collision
	public boolean check(int pX, int pY){
		if (pan.board.table[pX][pY] == null)
			return true;
		else
			return false;
	}
	
	
	//Touche lach�e
	public void keyReleased(KeyEvent e){}
	
	//Par ex : CTRL + touch
	public void keyTyped(KeyEvent e){}
	
	
	//Actualise l'affichage
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

  
