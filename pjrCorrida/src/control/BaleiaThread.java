package control;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BaleiaThread extends JLabel implements Runnable {
    private Thread baleiaThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    private static int pos=0;
    private String nome;
    // CONSTRUTOR DEFAULT
    public BaleiaThread() {
       
    }
    // CONSTRUTOR SOBRECARREGADO
    public BaleiaThread(String nome, ImageIcon img, int posX, int posY){
    super(img);
    this.imagem = img;
    this.posX = posX;
    this.posY = posY;
    this.nome = nome;
 
    baleiaThread = new Thread(this, nome);
    baleiaThread.start();
   
    }
    // M�TODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        posX += new Random().nextInt(3) * 100;
        this.setLocation(posX, posY);

        if (posX >= 1280) {
        	pos++;
        	 JOptionPane.showMessageDialog(null, pos + ")" + nome);
        	return;

        }
            
        try {
            Thread.sleep(new Random().nextInt(5) * 100);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}