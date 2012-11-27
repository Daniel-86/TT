package tt;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
//import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;

public class Escenario {
	VirtualUniverse universo;
	Locale local;
	BranchGroup vistaBG;
	BranchGroup escenaBG;
	BranchGroup raizAbsoluta;
	Canvas3D canvas;
//	Point3d centroVista;
	TransformGroup vistaTG;
	ViewPlatform vistaP;
	
	public Escenario(){
		universo=new VirtualUniverse();
		local=new Locale(universo);
		vistaBG=crearVista();
		vistaBG.setCapability(BranchGroup.ALLOW_DETACH);
//		local.addBranchGraph(vistaBG);
		escenaBG=new BranchGroup();
		escenaBG.setCapability(BranchGroup.ALLOW_DETACH);
		raizAbsoluta=new BranchGroup();
		raizAbsoluta.setCapability(BranchGroup.ALLOW_DETACH);
//		raizAbsoluta.addChild(escenaBG);
//		raizAbsoluta.addChild(vistaBG);
		local.addBranchGraph(escenaBG);
//		centroVista=new Point3d();
	}
	
	public VirtualUniverse getUniverso(){
		return universo;
	}
	
	public Locale getLocal(){
		return local;
	}
	
	public BranchGroup crearVista(){
		BranchGroup vBG=new BranchGroup();
		
		vistaTG=new TransformGroup();
		vistaTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		vistaTG.setCapability(TransformGroup.ALLOW_BOUNDS_READ);
		vBG.addChild(vistaTG);
		
		vistaP=new ViewPlatform();
		vistaP.setUserData("vistaP");
		vistaTG.addChild(vistaP);
		
		View vista=new View();
		PhysicalBody cuerpo=new PhysicalBody();
		PhysicalEnvironment entorno=new PhysicalEnvironment();
		vista.setPhysicalBody(cuerpo);
		vista.setPhysicalEnvironment(entorno);
		vista.setBackClipDistance(30);
		vista.attachViewPlatform(vistaP);
		
		GraphicsConfigTemplate3D graficos=new GraphicsConfigTemplate3D();
		graficos.setSceneAntialiasing(GraphicsConfigTemplate.PREFERRED);
		GraphicsDevice gd[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		canvas=new Canvas3D(gd[0].getBestConfiguration(graficos));
		canvas.setSize(300, 300);
		vista.addCanvas3D(canvas);
		
		return vBG;
		
	}
	
	public void darVida(){
//		local.addBranchGraph(raizAbsoluta);
		if(vistaBG.getParent()!=null)
			local.addBranchGraph(vistaBG);
	}
	
	public void addComportamiento(Point3d centro,Integer[] teclasCode){
//		ColisionPick navTeclado=new ColisionPick(vistaTG,raizAbsoluta,vistaP,centro,teclasCode);
		ColisionPick navTeclado=new ColisionPick(vistaTG,escenaBG,vistaP,centro,teclasCode,1);
//		KeyNavigatorBehavior navTeclado=new KeyNavigatorBehavior(vistaTG);
		navTeclado.setSchedulingBounds(new BoundingSphere(new Point3d(),1000));
		local.removeBranchGraph(vistaBG);
		vistaBG.addChild(navTeclado);
		local.addBranchGraph(vistaBG);
	}
	
	public Canvas3D getCanvas(){
		return canvas;
	}
	
	public Vector3d ajustarVista(BranchGroup e){
		if(vistaBG==null){
			vistaBG=new BranchGroup();
			TransformGroup vistaTG=new TransformGroup();
			vistaBG.addChild(vistaTG);
			vistaTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		}
		BoundingSphere boundsEscena=(BoundingSphere) e.getBounds();
//		System.out.println(e.getBounds());
		Transform3D centroT3d=new Transform3D();
		Point3d centro=new Point3d();
		boundsEscena.getCenter(centro);
		centroT3d.setTranslation(new Vector3d(centro));
		Transform3D moverT3d=new Transform3D();
		moverT3d.setTranslation(new Vector3d(0,0,boundsEscena.getRadius()*2));
		centroT3d.mul(moverT3d);
//		Vector3d vect=new Vector3d();
//		centroT3d.get(vect); System.out.println("translational: "+vect.x+","+vect.y+","+vect.z);
		((TransformGroup)vistaBG.getChild(0)).setTransform(centroT3d);
		
		Vector3d vectorC=new Vector3d();
		centroT3d.get(vectorC);
		return vectorC;
	}
	
	public Vector3d ajustarVistaZ(double val){
		if(vistaBG==null){
			vistaBG=new BranchGroup();
			TransformGroup vistaTG=new TransformGroup();
			vistaBG.addChild(vistaTG);
			vistaTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		}
		Transform3D centroT3d=new Transform3D();
//		centroT3d.setTranslation(new Vector3d(5,0,val));
		centroT3d.setTranslation(new Vector3d(18,5	,60));
//		Vector3d vect=new Vector3d();
//		centroT3d.get(vect); System.out.println("translational: "+vect.x+","+vect.y+","+vect.z);
		((TransformGroup)vistaBG.getChild(0)).setTransform(centroT3d);
		
		Vector3d vectorC=new Vector3d();
		centroT3d.get(vectorC);
		return vectorC;
	}
	
	public BranchGroup setBG(BranchGroup b){
//		raizAbsoluta.removeChild(escenaBG);
//		raizAbsoluta.addChild(b);
		local.replaceBranchGraph(escenaBG, b);
		escenaBG=b;
		return b;
	}	
	public BranchGroup addBG(){
		BranchGroup b=new BranchGroup();
		b.setUserData("raizBG");
		local.addBranchGraph(b);
		return b;
	}
	
	public BranchGroup getBG(){
		return escenaBG;
	}
	
}
