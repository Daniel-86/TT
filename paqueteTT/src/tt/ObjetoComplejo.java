package tt;

import java.beans.XMLDecoder;
import java.io.*;
import javax.media.j3d.*;
import javax.vecmath.*;


public class ObjetoComplejo extends TransformGroup {
	File dir=null;
	File []archivos=null;
	double ancho=0;
	double largo=0;
	
	public ObjetoComplejo(String path){
		dir=new File(path); System.out.println(path);
		FileFilter filtro=new FiltroExtension("xml");
		archivos=dir.listFiles(filtro);
		
		setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		for(File archivo:archivos)
			addChild(addDesdeXml(archivo));		
		setUserData(dir.getName());
//		posColor=posCol;
	}
	
	private Shape3D addDesdeXml(File archivo){
		
		Shape3D forma=null;
		try{
			XMLDecoder de = new XMLDecoder(new BufferedInputStream( new FileInputStream(archivo.getAbsolutePath())));
			forma=(Shape3D) de.readObject();
			if(forma.getUserData()!=null){
//				System.out.println(archivo.getName()+"\ttiene user data: "+((String)forma.getUserData()));
//				System.out.println(archivo.getPath());
			}
			de.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		forma.setUserData(archivo.getName());
		return forma;
	}
	
	public static void setTransformacion(TransformGroup el, double x, double y, double z, double orientacion){
		Transform3D tras=new Transform3D();
		Transform3D rot=new Transform3D();
		rot.rotY(orientacion);
		tras.setTranslation(new Vector3d(x,y,z));
		tras.mul(rot);
		el.setTransform(tras);
	}
}
