package tt;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.media.j3d.*;
import javax.vecmath.*;

public class EscenaXml extends BranchGroup {
	File dir;
	File []archivos;
	int posx;
	private final int Edif1 = new Color( 0,0,0 ).getRGB( );
	private final int Edif2 = new Color( 255,0,0 ).getRGB( );
	private final int Edif3 = new Color( 255,255,0 ).getRGB( );
	private final int Edif4 = new Color( 117,44,0 ).getRGB( );
	private final int Edif5 = new Color( 224,255,0 ).getRGB( );
	private final int Edif6 = new Color( 36,79,18 ).getRGB( );
	private final int Edif7 = new Color( 90,110,92 ).getRGB( );
	private final int Edif8 = new Color( 220,41,115 ).getRGB( );
	private final int Edif9 = new Color( 220,255,223 ).getRGB( );
	private final int Edif10 = new Color( 93,155,117 ).getRGB( );
	private final int Edif11 = new Color( 149,81,156 ).getRGB( );
	private final int Edif12 = new Color( 141,47,210 ).getRGB( );
	private final int Edif13 = new Color( 197,238,174 ).getRGB( );
	private final int Edif14 = new Color( 132,187,28 ).getRGB( );
	private final int Edif15 = new Color( 255,255,215 ).getRGB( );
	private final int Edif16 = new Color( 19,255,19 ).getRGB( );
	private final int Edif17 = new Color( 181,138,82 ).getRGB( );
	private final int Edif18 = new Color( 32,138,184 ).getRGB( );

	private final int Edif1b = new Color( 0,0,1 ).getRGB( );
	private final int Edif2b = new Color( 255,0,1 ).getRGB( );
	private final int Edif3b = new Color( 255,255,1 ).getRGB( );
	private final int Edif4b = new Color( 117,44,1 ).getRGB( );
	private final int Edif5b = new Color( 224,255,1 ).getRGB( );
	private final int Edif6b = new Color( 36,79,19 ).getRGB( );
	private final int Edif7b = new Color( 90,110,93 ).getRGB( );
	private final int Edif8b = new Color( 220,41,116 ).getRGB( );
	private final int Edif9b = new Color( 220,255,224 ).getRGB( );
	private final int Edif10b = new Color( 93,155,118 ).getRGB( );
	private final int Edif11b = new Color( 149,81,157 ).getRGB( );
	private final int Edif12b = new Color( 141,47,211 ).getRGB( );
	private final int Edif13b = new Color( 197,238,175 ).getRGB( );
	private final int Edif14b = new Color( 132,187,29 ).getRGB( );
	private final int Edif15b = new Color( 255,255,216 ).getRGB( );
	private final int Edif16b = new Color( 19,255,20 ).getRGB( );
	private final int Edif17b = new Color( 181,138,83 ).getRGB( );
	private final int Edif18b = new Color( 32,138,185 ).getRGB( );
	
	
	private final int Edif1vi = new Color( 0,0,2 ).getRGB( );
	private final int Edif2vi = new Color( 255,0,2 ).getRGB( );
	private final int Edif3vi = new Color( 255,255,2 ).getRGB( );
	private final int Edif4vi = new Color( 117,44,2 ).getRGB( );
	private final int Edif5vi = new Color( 224,255,2 ).getRGB( );
	private final int Edif6vi = new Color( 36,79,20 ).getRGB( );
	private final int Edif7vi = new Color( 90,110,94 ).getRGB( );
	private final int Edif8vi = new Color( 220,41,117 ).getRGB( );
	private final int Edif9vi = new Color( 220,255,225 ).getRGB( );
	private final int Edif10vi = new Color( 93,155,119 ).getRGB( );
	private final int Edif11vi = new Color( 149,81,158 ).getRGB( );
	private final int Edif12vi = new Color( 141,47,212 ).getRGB( );
	private final int Edif13vi = new Color( 197,238,176 ).getRGB( );
	private final int Edif14vi = new Color( 132,187,30 ).getRGB( );
	private final int Edif15vi = new Color( 255,255,217 ).getRGB( );
	private final int Edif16vi = new Color( 19,255,21 ).getRGB( );
	private final int Edif17vi = new Color( 181,138,84 ).getRGB( );
	private final int Edif18vi = new Color( 32,138,186 ).getRGB( );
	
	private final int Edif1vd = new Color( 0,0,3 ).getRGB( );
	private final int Edif2vd = new Color( 255,0,3 ).getRGB( );
	private final int Edif3vd = new Color( 255,255,3 ).getRGB( );
	private final int Edif4vd = new Color( 117,44,3 ).getRGB( );
	private final int Edif5vd = new Color( 224,255,3 ).getRGB( );
	private final int Edif6vd = new Color( 36,79,21 ).getRGB( );
	private final int Edif7vd = new Color( 90,110,95 ).getRGB( );
	private final int Edif8vd = new Color( 220,41,118 ).getRGB( );
	private final int Edif9vd = new Color( 220,255,226 ).getRGB( );
	private final int Edif10vd = new Color( 93,155,120 ).getRGB( );
	private final int Edif11vd = new Color( 149,81,159 ).getRGB( );
	private final int Edif12vd = new Color( 141,47,213 ).getRGB( );
	private final int Edif13vd = new Color( 197,238,177 ).getRGB( );
	private final int Edif14vd = new Color( 132,187,31 ).getRGB( );
	private final int Edif15vd = new Color( 255,255,218 ).getRGB( );
	private final int Edif16vd = new Color( 19,255,22 ).getRGB( );
	private final int Edif17vd = new Color( 181,138,85 ).getRGB( );
	private final int Edif18vd = new Color( 32,138,187 ).getRGB( );
	
	private final int banca1 = new Color( 10,255,0 ).getRGB( );
	private final int banca2 = new Color( 20,255,0 ).getRGB( );
	private final int banca3 = new Color( 30,255,0 ).getRGB( );
	private final int banca4 = new Color( 0,255,0 ).getRGB( );
	
	private final int banca1b = new Color( 10,255,1 ).getRGB( );
	private final int banca2b = new Color( 20,255,1 ).getRGB( );
	private final int banca3b = new Color( 30,255,1 ).getRGB( );
	private final int banca4b = new Color( 0,255,1 ).getRGB( );
	
	private final int banca1vi = new Color( 10,255,2 ).getRGB( );
	private final int banca2vi = new Color( 20,255,2 ).getRGB( );
	private final int banca3vi = new Color( 30,255,2 ).getRGB( );
	private final int banca4vi = new Color( 0,255,2 ).getRGB( );
	
	private final int banca1vd = new Color( 10,255,3 ).getRGB( );
	private final int banca2vd = new Color( 20,255,3 ).getRGB( );
	private final int banca3vd = new Color( 30,255,3 ).getRGB( );
	private final int banca4vd = new Color( 0,255,3 ).getRGB( );
	
	private final int persona1 = new Color( 100,0,100 ).getRGB( );
	private final int persona2 = new Color( 100,5,100 ).getRGB( );
	private final int persona3 = new Color( 100,10,100 ).getRGB( );
	private final int persona4 = new Color( 100,15,100 ).getRGB( );
	private final int persona5 = new Color( 100,20,100 ).getRGB( );
	
	private final int persona1b = new Color( 100,0,101 ).getRGB( );
	private final int persona2b = new Color( 100,5,101 ).getRGB( );
	private final int persona3b = new Color( 100,10,101 ).getRGB( );
	private final int persona4b = new Color( 100,15,101 ).getRGB( );
	private final int persona5b = new Color( 100,20,101 ).getRGB( );
	
	private final int persona1i = new Color( 100,0,102 ).getRGB( );
	private final int persona2i = new Color( 100,5,102 ).getRGB( );
	private final int persona3i = new Color( 100,10,102 ).getRGB( );
	private final int persona4i = new Color( 100,15,102 ).getRGB( );
	private final int persona5i = new Color( 100,20,102 ).getRGB( );
	
	private final int persona1d = new Color( 100,0,103 ).getRGB( );
	private final int persona2d = new Color( 100,5,103 ).getRGB( );
	private final int persona3d = new Color( 100,10,103 ).getRGB( );
	private final int persona4d = new Color( 100,15,103 ).getRGB( );
	private final int persona5d = new Color( 100,20,103 ).getRGB( );
	
	private final int carretera = new Color( 1,0,215 ).getRGB( );
	private final int carreterav = new Color( 1,0,216 ).getRGB( );
	private final int interseccion = new Color( 214,0,199 ).getRGB( );
	private final int plano = new Color( 36,255,100 ).getRGB( );
	private final int planoverde = new Color( 36,255,101 ).getRGB( );
	
	private final int arbol = new Color( 0,182,222 ).getRGB( );
	private final int arbol1 = new Color( 50,50,50 ).getRGB( );
	private final int arbol2 = new Color( 200,100,0 ).getRGB( );
	private final int agua = new Color( 150,150,0 ).getRGB( );
	private final int bote = new Color( 0,150,0 ).getRGB( );
 
	
	public EscenaXml(String ruta, Object datos, String rutaImagen){

		System.out.println(rutaImagen);
		BufferedImage mapa=null;
		URL url=null;
		try{
			url=new File(rutaImagen).toURI().toURL();
			mapa=(BufferedImage) ImageIO.read(url);
		}
		catch(Exception e){
			System.out.println("Error leyendo mapa: "+url.getProtocol());
//			System.exit(1);
		}
		
		if (mapa == null)
			System.out.println("error creando mapa");
		
		Hashtable <Integer,ObjetoComplejo> objetos=new Hashtable <Integer, ObjetoComplejo>();
		Hashtable <Integer,Double> orientaciones=new Hashtable <Integer, Double>();
		ObjetoComplejo edf1TG=new ObjetoComplejo(ruta+"/Edif1");
		edf1TG.ancho=10;
		edf1TG.largo=5;
		objetos.put(Edif1, edf1TG);
		orientaciones.put(Edif1, 0.0);
		objetos.put(Edif1b, edf1TG);
		orientaciones.put(Edif1b, Math.PI);
		{
		objetos.put(Edif1vi, edf1TG);
		orientaciones.put(Edif1vi, Math.PI/2);
		objetos.put(Edif1vd, edf1TG);
		orientaciones.put(Edif1vd, -Math.PI/2);
//		System.out.println("edificio 1 ancho:"+edf1TG.ancho+" largo:"+edf1TG.largo);
		ObjetoComplejo edf2TG=new ObjetoComplejo(ruta+"/Edif2");
		edf2TG.ancho=8;
		edf2TG.largo=8;
		objetos.put(Edif2, edf2TG);
		orientaciones.put(Edif2, 0.0);
		objetos.put(Edif2b, edf2TG);
		orientaciones.put(Edif2b, Math.PI);
		objetos.put(Edif2vi, edf2TG);
		orientaciones.put(Edif2vi, Math.PI/2);
		objetos.put(Edif2vd, edf2TG);
		orientaciones.put(Edif2vd, -Math.PI/2);
//		System.out.println("edificio 2 ancho:"+edf2TG.ancho+" largo:"+edf2TG.largo);
		ObjetoComplejo edf3TG=new ObjetoComplejo(ruta+"/Edif3");
		edf3TG.ancho=8;
		edf3TG.largo=6;
		objetos.put(Edif3, edf3TG);
		orientaciones.put(Edif3, 0.0);
		objetos.put(Edif3b, edf3TG);
		orientaciones.put(Edif3b, Math.PI);
		objetos.put(Edif3vi, edf3TG);
		orientaciones.put(Edif3vi, Math.PI/2);
		objetos.put(Edif3vd, edf3TG);
		orientaciones.put(Edif3vd, -Math.PI/2);
//		System.out.println("edificio 3 ancho:"+edf3TG.ancho+" largo:"+edf3TG.largo);
		ObjetoComplejo edf4TG=new ObjetoComplejo(ruta+"/Edif4");
		edf4TG.ancho=8;
		edf4TG.largo=6;
		objetos.put(Edif4, edf4TG);
		orientaciones.put(Edif4, 0.0);
		objetos.put(Edif4b, edf4TG);
		orientaciones.put(Edif4b, Math.PI);
		objetos.put(Edif4vi, edf4TG);
		orientaciones.put(Edif4vi, Math.PI/2);
		objetos.put(Edif4vd, edf4TG);
		orientaciones.put(Edif4vd, -Math.PI/2);
//		System.out.println("edificio 3 ancho:"+edf3TG.ancho+" largo:"+edf3TG.largo);
		ObjetoComplejo edf5TG=new ObjetoComplejo(ruta+"/Edif5");
		edf5TG.ancho=8;
		edf5TG.largo=6;
		objetos.put(Edif5, edf5TG);
		orientaciones.put(Edif5, 0.0);
		objetos.put(Edif5b, edf5TG);
		orientaciones.put(Edif5b, Math.PI);
		objetos.put(Edif5vi, edf5TG);
		orientaciones.put(Edif5vi, Math.PI/2);
		objetos.put(Edif5vd, edf5TG);
		orientaciones.put(Edif5vd, -Math.PI/2);
//		System.out.println("edificio 3 ancho:"+edf3TG.ancho+" largo:"+edf3TG.largo);
		ObjetoComplejo edf6TG=new ObjetoComplejo(ruta+"/Edif6");
		edf6TG.ancho=8;
		edf6TG.largo=6;
		objetos.put(Edif6, edf6TG);
		orientaciones.put(Edif6, 0.0);
		objetos.put(Edif6b, edf6TG);
		orientaciones.put(Edif6b, Math.PI);
		objetos.put(Edif6vi, edf6TG);
		orientaciones.put(Edif6vi, Math.PI/2);
		objetos.put(Edif6vd, edf6TG);
		orientaciones.put(Edif6vd, -Math.PI/2);
		ObjetoComplejo edf7TG=new ObjetoComplejo(ruta+"/Edif7");
		objetos.put(Edif7, edf7TG);
		orientaciones.put(Edif7, 0.0);
		objetos.put(Edif7b, edf7TG);
		orientaciones.put(Edif7b, Math.PI);
		objetos.put(Edif7vi, edf7TG);
		orientaciones.put(Edif7vi, Math.PI/2);
		objetos.put(Edif7vd, edf7TG);
		orientaciones.put(Edif7vd, -Math.PI/2);
//		System.out.println("edificio 3 ancho:"+edf3TG.ancho+" largo:"+edf3TG.largo);
		ObjetoComplejo edf8TG=new ObjetoComplejo(ruta+"/Edif8");
		objetos.put(Edif8, edf8TG);
		orientaciones.put(Edif8, 0.0);
		objetos.put(Edif8b, edf8TG);
		orientaciones.put(Edif8b, Math.PI);
		objetos.put(Edif8vi, edf8TG);
		orientaciones.put(Edif8vi, Math.PI/2);
		objetos.put(Edif8vd, edf8TG);
		orientaciones.put(Edif8vd, -Math.PI/2);
		ObjetoComplejo edf9TG=new ObjetoComplejo(ruta+"/Edif9");
		objetos.put(Edif9, edf9TG);
		orientaciones.put(Edif9, 0.0);
		objetos.put(Edif9b, edf9TG);
		orientaciones.put(Edif9b, Math.PI);
		objetos.put(Edif9vi, edf9TG);
		orientaciones.put(Edif9vi, Math.PI/2);
		objetos.put(Edif9vd, edf9TG);
		orientaciones.put(Edif9vd, -Math.PI/2);
		ObjetoComplejo edf10TG=new ObjetoComplejo(ruta+"/Edif10");
		objetos.put(Edif10, edf10TG);
		orientaciones.put(Edif10, 0.0);
		objetos.put(Edif10b, edf10TG);
		orientaciones.put(Edif10b, Math.PI);
		objetos.put(Edif10vi, edf10TG);
		orientaciones.put(Edif10vi, Math.PI/2);
		objetos.put(Edif10vd, edf10TG);
		orientaciones.put(Edif10vd, -Math.PI/2);
		ObjetoComplejo edf11TG=new ObjetoComplejo(ruta+"/Edif11");
		objetos.put(Edif11, edf11TG);
		orientaciones.put(Edif11, 0.0);
		objetos.put(Edif11b, edf11TG);
		orientaciones.put(Edif11b, Math.PI);
		objetos.put(Edif11vi, edf11TG);
		orientaciones.put(Edif11vi, Math.PI/2);
		objetos.put(Edif11vd, edf11TG);
		orientaciones.put(Edif11vd, -Math.PI/2);
		ObjetoComplejo edf12TG=new ObjetoComplejo(ruta+"/Edif12");
		objetos.put(Edif12, edf12TG);
		orientaciones.put(Edif12, 0.0);
		objetos.put(Edif12b, edf12TG);
		orientaciones.put(Edif12b, Math.PI);
		objetos.put(Edif12vi, edf12TG);
		orientaciones.put(Edif12vi, Math.PI/2);
		objetos.put(Edif12vd, edf12TG);
		orientaciones.put(Edif12vd, -Math.PI/2);
		ObjetoComplejo edf13TG=new ObjetoComplejo(ruta+"/Edif13");
		objetos.put(Edif13, edf13TG);
		orientaciones.put(Edif13, 0.0);
		objetos.put(Edif13b, edf13TG);
		orientaciones.put(Edif13b, Math.PI);
		objetos.put(Edif13vi, edf13TG);
		orientaciones.put(Edif13vi, Math.PI/2);
		objetos.put(Edif13vd, edf13TG);
		orientaciones.put(Edif13vd, -Math.PI/2);
		ObjetoComplejo edf14TG=new ObjetoComplejo(ruta+"/Edif14");
		objetos.put(Edif14, edf14TG);
		orientaciones.put(Edif14, 0.0);
		objetos.put(Edif14b, edf14TG);
		orientaciones.put(Edif14b, Math.PI);
		objetos.put(Edif14vi, edf14TG);
		orientaciones.put(Edif14vi, Math.PI/2);
		objetos.put(Edif14vd, edf14TG);
		orientaciones.put(Edif14vd, -Math.PI/2);
		ObjetoComplejo edf15TG=new ObjetoComplejo(ruta+"/Edif15");
		objetos.put(Edif15, edf15TG);
		orientaciones.put(Edif15, 0.0);
		objetos.put(Edif15b, edf15TG);
		orientaciones.put(Edif15b, Math.PI);
		objetos.put(Edif15vi, edf15TG);
		orientaciones.put(Edif15vi, Math.PI/2);
		objetos.put(Edif15vd, edf15TG);
		orientaciones.put(Edif15vd, -Math.PI/2);
		ObjetoComplejo edf16TG=new ObjetoComplejo(ruta+"/Edif16");
		objetos.put(Edif16, edf16TG);
		orientaciones.put(Edif16, 0.0);
		objetos.put(Edif16b, edf16TG);
		orientaciones.put(Edif16b, Math.PI);
		objetos.put(Edif16vi, edf16TG);
		orientaciones.put(Edif16vi, Math.PI/2);
		objetos.put(Edif16vd, edf16TG);
		orientaciones.put(Edif16vd, -Math.PI/2);
		ObjetoComplejo edf17TG=new ObjetoComplejo(ruta+"/Edif17");
		objetos.put(Edif17, edf17TG);
		orientaciones.put(Edif17, 0.0);
		objetos.put(Edif17b, edf17TG);
		orientaciones.put(Edif17b, Math.PI);
		objetos.put(Edif17vi, edf17TG);
		orientaciones.put(Edif17vi, Math.PI/2);
		objetos.put(Edif17vd, edf17TG);
		orientaciones.put(Edif17vd, -Math.PI/2);
		ObjetoComplejo edf18TG=new ObjetoComplejo(ruta+"/Edif18");
		objetos.put(Edif18, edf18TG);
		orientaciones.put(Edif18, 0.0);
		objetos.put(Edif18b, edf18TG);
		orientaciones.put(Edif18b, Math.PI);
		objetos.put(Edif18vi, edf18TG);
		orientaciones.put(Edif18vi, Math.PI/2);
		objetos.put(Edif18vd, edf18TG);
		orientaciones.put(Edif18vd, -Math.PI/2);
		ObjetoComplejo bnc1TG=new ObjetoComplejo(ruta+"/banca1");
		bnc1TG.ancho=2;
		bnc1TG.largo=1;
		objetos.put(banca1, bnc1TG);
		orientaciones.put(banca1, 0.0);
		objetos.put(banca1b, bnc1TG);
		orientaciones.put(banca1b, Math.PI);
		objetos.put(banca1vi, bnc1TG);
		orientaciones.put(banca1vi, Math.PI/2);
		objetos.put(banca1vd, bnc1TG);
		orientaciones.put(banca1vd, -Math.PI/2);
		ObjetoComplejo bnc2TG=new ObjetoComplejo(ruta+"/banca2");
		bnc2TG.ancho=2;
		bnc2TG.largo=1;
		objetos.put(banca2, bnc2TG);
		orientaciones.put(banca2, 0.0);
		objetos.put(banca2b, bnc2TG);
		orientaciones.put(banca2b, Math.PI);
		objetos.put(banca2vi, bnc2TG);
		orientaciones.put(banca2vi, Math.PI/2);
		objetos.put(banca2vd, bnc2TG);
		orientaciones.put(banca2vd, -Math.PI/2);
		ObjetoComplejo bnc3TG=new ObjetoComplejo(ruta+"/banca3");
		bnc3TG.ancho=2;
		bnc3TG.largo=1;
		objetos.put(banca3, bnc3TG);
		orientaciones.put(banca3, 0.0);
		objetos.put(banca3b, bnc3TG);
		orientaciones.put(banca3b, Math.PI);
		objetos.put(banca3vi, bnc3TG);
		orientaciones.put(banca3vi, Math.PI/2);
		objetos.put(banca3vd, bnc3TG);
		orientaciones.put(banca3vd, -Math.PI/2);
		ObjetoComplejo bnc4TG=new ObjetoComplejo(ruta+"/banca4");
		bnc4TG.ancho=2;
		bnc4TG.largo=1;
		objetos.put(banca4, bnc4TG);
		orientaciones.put(banca4, 0.0);
		objetos.put(banca4b, bnc4TG);
		orientaciones.put(banca4b, Math.PI);
		objetos.put(banca4vi, bnc4TG);
		orientaciones.put(banca4vi, Math.PI/2);
		objetos.put(banca4vd, bnc4TG);
		orientaciones.put(banca4vd, -Math.PI/2);
//		System.out.println("banca 4 ancho:"+bnc4TG.ancho+" largo:"+bnc4TG.largo);
		ObjetoComplejo crtTG=new ObjetoComplejo(ruta+"/carretera");
		crtTG.ancho=2;
		crtTG.largo=1;
		objetos.put(carretera, crtTG);
		orientaciones.put(carretera, 0.0);
		objetos.put(carreterav, crtTG);
		orientaciones.put(carreterav, Math.PI/2);
		ObjetoComplejo interTG=new ObjetoComplejo(ruta+"/interseccion");
		interTG.ancho=2;
		interTG.largo=1;
		objetos.put(interseccion, interTG);
		orientaciones.put(interseccion, 0.0);
		ObjetoComplejo plnTG=new ObjetoComplejo(ruta+"/plano");
		plnTG.ancho=2;
		plnTG.largo=1;
		objetos.put(plano, plnTG);
		orientaciones.put(plano, 0.0);
		ObjetoComplejo plnverTG=new ObjetoComplejo(ruta+"/planoverde");
		plnverTG.ancho=2;
		plnverTG.largo=1;
		objetos.put(planoverde, plnverTG);
		orientaciones.put(planoverde, 0.0);
		ObjetoComplejo prs1TG=new ObjetoComplejo(ruta+"/persona1");
		prs1TG.ancho=4;
		prs1TG.largo=4;
		objetos.put(persona1, prs1TG);
		orientaciones.put(persona1, 0.0);
		objetos.put(persona1b, prs1TG);
		orientaciones.put(persona1b, Math.PI);
		objetos.put(persona1i, prs1TG);
		orientaciones.put(persona1i, -Math.PI/2);
		objetos.put(persona1d, prs1TG);
		orientaciones.put(persona1d, Math.PI/2);
		ObjetoComplejo prs2TG=new ObjetoComplejo(ruta+"/persona2");
		prs2TG.ancho=4;
		prs2TG.largo=4;
		objetos.put(persona2, prs2TG);
		orientaciones.put(persona2, 0.0);
		objetos.put(persona2b, prs2TG);
		orientaciones.put(persona2b, Math.PI);
		objetos.put(persona2i, prs2TG);
		orientaciones.put(persona2i, -Math.PI/2);
		objetos.put(persona2d, prs2TG);
		orientaciones.put(persona2d, Math.PI/2);
		ObjetoComplejo prs3TG=new ObjetoComplejo(ruta+"/persona3");
		prs3TG.ancho=4;
		prs3TG.largo=4;
		objetos.put(persona3, prs3TG);
		orientaciones.put(persona3, 0.0);
		objetos.put(persona3b, prs3TG);
		orientaciones.put(persona3b, Math.PI);
		objetos.put(persona3i, prs3TG);
		orientaciones.put(persona3i, -Math.PI/2);
		objetos.put(persona3d, prs3TG);
		orientaciones.put(persona3d, Math.PI/2);
		ObjetoComplejo prs4TG=new ObjetoComplejo(ruta+"/persona4");
		objetos.put(persona4, prs4TG);
		orientaciones.put(persona4, 0.0);
		objetos.put(persona4b, prs4TG);
		orientaciones.put(persona4b, Math.PI);
		objetos.put(persona4i, prs4TG);
		orientaciones.put(persona4i, -Math.PI/2);
		objetos.put(persona4d, prs4TG);
		orientaciones.put(persona4d, Math.PI/2);
		ObjetoComplejo prs5TG=new ObjetoComplejo(ruta+"/persona5");
		objetos.put(persona5, prs5TG);
		orientaciones.put(persona5, 0.0);
		objetos.put(persona5b, prs5TG);
		orientaciones.put(persona5b, Math.PI);
		objetos.put(persona5i, prs5TG);
		orientaciones.put(persona5i, -Math.PI/2);
		objetos.put(persona5d, prs5TG);
		orientaciones.put(persona4d, Math.PI/2);
		ObjetoComplejo arbTG=new ObjetoComplejo(ruta+"/arbol");
		objetos.put(arbol, arbTG);
		orientaciones.put(arbol, 0.0);
		ObjetoComplejo arb1TG=new ObjetoComplejo(ruta+"/arbol1");
		objetos.put(arbol1, arb1TG);
		orientaciones.put(arbol1, 0.0);
		ObjetoComplejo arb2TG=new ObjetoComplejo(ruta+"/arbol2");
		objetos.put(arbol2, arb2TG);
		orientaciones.put(arbol2, 0.0);
		ObjetoComplejo agaTG=new ObjetoComplejo(ruta+"/agua");
		objetos.put(agua, agaTG);
		orientaciones.put(agua, 0.0);
		ObjetoComplejo botTG=new ObjetoComplejo(ruta+"/bote");
		objetos.put(bote, botTG);
		orientaciones.put(bote, 0.0);}
//		System.out.println("persona 3 ancho:"+prs3TG.ancho+" largo:"+prs3TG.largo);
		
		
		setCapability(BranchGroup.ALLOW_DETACH);
		System.out.println("\n");
		
		for(int y=0;y<mapa.getHeight();y++)
//		for(int y=0;y<1;y++)
			for(int x=0;x<mapa.getWidth();x++){
				int colorObj=mapa.getRGB(x, y);
				ObjetoComplejo obj=objetos.get(colorObj);
				if(obj!=null){
					TransformGroup elemento=(TransformGroup)obj.cloneTree();
					double rot=orientaciones.get(colorObj);
					ObjetoComplejo.setTransformacion(elemento,x, 0, y, rot);
					addChild(elemento);
				}
//				else{
//					Color colAux=new Color(colorObj);
//					System.out.println("no hay objeto definido para "+colAux.getRed()+","+colAux.getGreen()+","+colAux.getBlue());
//				}
			}
		
		AmbientLight luz=new AmbientLight();
		luz.setUserData("luz ambiente");
		luz.setInfluencingBounds(new BoundingSphere(new Point3d(),1000));
		DirectionalLight luzd=new DirectionalLight();
		luzd.setUserData("luz direccional");
		luzd.setInfluencingBounds(new BoundingSphere(new Point3d(),1000));
		luzd.setDirection(0, -200, -40);
		addChild(luz);
		addChild(luzd);
		
		setUserData(datos);
		
	}

}