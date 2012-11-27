import java.io.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import tt.*;
import javax.swing.*;
import javax.vecmath.*;


public class Ventana extends JFrame {
	
	File dir;
	File []carpetas;
	Escenario escenario;
	String rutaRaiz;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5502761975394024380L;

	public Ventana(String ruta, String[] objetos){
		rutaRaiz=ruta;
		dir=new File(ruta);
		FileFilter filtro=new FiltroDirectorios();
		carpetas=dir.listFiles(filtro);
		
		setTitle("escena de blender");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		escenario=new Escenario();
		getContentPane().add(escenario.getCanvas(), BorderLayout.CENTER);
		escenario.setBG(new EscenaXml(rutaRaiz,"raiz","/home/daniel/workspaces/eclipse/dsa.gif"));
		Vector3d centro=escenario.ajustarVistaZ(15);
		escenario.addComportamiento(new Point3d(centro.x,centro.y,centro.z), new Integer[]{KeyEvent.VK_LEFT,
															KeyEvent.VK_2,
															KeyEvent.VK_RIGHT,
															KeyEvent.VK_8,
															KeyEvent.VK_UP,
															KeyEvent.VK_DOWN,
															KeyEvent.VK_Z,
															KeyEvent.VK_X});
		escenario.darVida();

		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Ventana ventana=new Ventana("/home/daniel/workspaces/eclipse/modelos",new String[]{"Edif1","Edif3","Edif4","Edif5"});
		ventana.setSize(500, 500);
		ventana.setVisible(true);

	}

}
