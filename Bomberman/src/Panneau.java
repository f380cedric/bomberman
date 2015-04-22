import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	//Position initiale
	public int posX = 0;
	public int posY = 0;
	public Bedrock blokk = new Bedrock(5,6);
	private Board board = new Board();

  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  this.setBackground(Color.white);

	  // Joueur
	  try{
		  Image img = ImageIO.read(new File("image1.jpeg"));
		  g.drawImage(img, posX*40, posY*40, this);
	  }catch (IOException e){
		  e.printStackTrace();
	  }
	  
	  
	  
	  //Plateau de jeu
	  for(int i = 0; i < board.table.length; i++){
		  for(int j = 0; j < board.table.length; j++){
			  if(board.table[i][j] != null){
				  try{
					  Image img = ImageIO.read(new File(board.table[i][j].skin));
					  g.drawImage(img, board.table[i][j].getPosx()*40,
							     board.table[i][j].getPosy()*40, this);
				  }catch (IOException e){
					  e.printStackTrace();
				  }
				  
				  
			  }
		  }
	  }
	  
  }  
  
  
  
  
  
  // METHODES GET
  public int getPosX() {
    return posX;
  }
  public int getPosY() {
	    return posY;
	  }

  
  // METHODES SET
  public void setPosX(int posX) {
    this.posX = posX;
  }
  public void setPosY(int posY) {
    this.posY = posY;
  }       
  public void setElemInBoard(int posx,int posy,Element a){
	  board.table[posx][posy]=a;
	  Fenetre.update();
  }
  public Element getElemInBoard(int posx,int posy){
	  return board.table[posx][posy];
  }
}