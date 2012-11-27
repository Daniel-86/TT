package tt;

import java.awt.AWTEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import javax.media.j3d.Behavior;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.PickBounds;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.WakeupCriterion;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import com.sun.j3d.utils.picking.PickResult;
import com.sun.j3d.utils.picking.PickTool;

public class ColisionPick extends Behavior {
	private TransformGroup miTG=null;
	private BranchGroup BG=null;
	private WakeupCriterion despertar;
	private PickBounds boundsPick=null;
	private Node cubo;
	private Point3d centro;
	private PickTool picktool;
	private Vector<Integer> teclas;
	private double radio;
	private double valRot;
	private double rotTotal=0;
	
	/**
	 * Navegacion usando el teclado y con deteccion de colisiones implementada
	 * usando @see pickTool
	 * @param t transformGroup a modificar
	 * @param b BranchGroup sobre el que opera el PickTool
	 * @param c objeto sobre el que se detecta la colision
	 * @param centr centro del Bounds al momento de inicializar
	 * @param tec arreglo de las teclas (izq, abj, der, arb, atr, adl)
	 */
	public ColisionPick(TransformGroup t, BranchGroup b, Node c, Point3d centr, Integer[] tec, double r){
		miTG=t;
		BG=b;
		despertar=new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED);
		cubo=c;
		setUserData("micompor");
//		t.setCapability( TransformGroup.ALLOW_TRANSFORM_WRITE );
//		t.setCapability( Node.ALLOW_BOUNDS_READ );
		centro=centr;
//		System.out.println(BG.getUserData());
		picktool=new PickTool(b);
		teclas=new Vector<Integer>(Arrays.asList(tec));
//		System.out.println("centro: "+centro);
		radio=r;
	}

	@Override
	public void initialize() {
		wakeupOn(despertar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void processStimulus(Enumeration arg0) {
		WakeupCriterion criterio;
		WakeupOnAWTEvent criterioAWT;
		AWTEvent[] eventos;
		boolean bandera=false;
		
		while(arg0.hasMoreElements()){
			criterio=(WakeupCriterion)arg0.nextElement();
			if(criterio instanceof WakeupOnAWTEvent){
				criterioAWT=(WakeupOnAWTEvent)criterio;
				eventos=criterioAWT.getAWTEvent();
				picktool.setMode(PickTool.BOUNDS);
				
				for(AWTEvent evento:eventos){
					KeyEvent teclaso=(KeyEvent)evento;
					if(teclaso.getID()==KeyEvent.KEY_PRESSED){
						Transform3D tAct=new Transform3D();
						Transform3D tNueva=new Transform3D();
						Transform3D tNueva2=new Transform3D();
						miTG.getTransform(tAct);
						Point3d desp=null;
						double val=0.5;
						int indice=-1;
						if(teclas.contains(teclaso.getKeyCode())){
							indice=teclas.indexOf(teclaso.getKeyCode());
						}
						Point3d paux;
						Transform3D taux;
						switch(indice){
							case 0:
								paux=new Point3d(-val,0,0);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(-val,0,0);
								valRot=0;
	//							System.out.println();
								break;
							case 1:
								paux=new Point3d(0,-val,0);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(0,-val,0);
								valRot=0;
								break;
							case 2:
								paux=new Point3d(val,0,0);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(val,0,0);
								valRot=0;
								break;
							case 3:
								paux=new Point3d(0,val,0);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(0,val,0);
								valRot=0;
								break;
							case 4:
								paux=new Point3d(0,0,-val);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(0,0,-val);
								valRot=0;
								break;
							case 5:
								paux=new Point3d(0,0,val);
								taux=new Transform3D();
								taux.rotY(rotTotal);
								taux.transform(paux);
								centro.add(paux);
								desp=new Point3d(0,0,val);
								valRot=0;
								break;
							case 6:
//								centro.add(new Point3d(0,0,val));
//								desp=new Point3d(0,0,val);
								bandera=true;
								valRot=0.2;
								rotTotal+=0.2;
								desp=new Point3d(0,0,0);
								paux=new Point3d(0,0,0);
								break;
							case 7:
//								centro.add(new Point3d(0,0,val));
//								desp=new Point3d(0,0,val);
								desp=new Point3d(0,0,0);
								paux=new Point3d(0,0,0);
								valRot=-0.2;
								rotTotal+=-0.2;
								bandera=true;
								break;
//							case 8:
////								centro.add(new Point3d(0,0,val));
////								desp=new Point3d(0,0,val);
//								desp=new Point3d(0,0,0);
//								paux=new Point3d(0,0,0);
//								valRot=-0.2;
//								rotTotal+=-0.2;
//								bandera=true;
//								break;
//							case 9:
////								centro.add(new Point3d(0,0,val));
////								desp=new Point3d(0,0,val);
//								desp=new Point3d(0,0,0);
//								paux=new Point3d(0,0,0);
//								valRot=-0.2;
//								rotTotal+=-0.2;
//								bandera=true;
//								break;
							default:
								desp=new Point3d(0,0,0);
								paux=new Point3d(0,0,0);
						}
						
//						boundsPick=new PickBounds(new BoundingSphere(new Point3d(centro.x,centro.y,centro.z),0.9));
						boundsPick=new PickBounds(new BoundingSphere(new Point3d(centro.x,centro.y,centro.z),radio));
						picktool.setShape(boundsPick, new Point3d(0,0,0));
						System.out.println("movido a: "+centro+" Bounds: "+boundsPick.get()+" transform: "+miTG.getBounds());
						PickResult[] resultPick=picktool.pickAllSorted();
						if(resultPick!=null){
							int i;
							for(i=0;i<resultPick.length&&resultPick[i].getObject().getParent().getUserData()==cubo.getUserData();i++);
							if(i<resultPick.length){
								System.out.println(cubo.getUserData()+" colisionando con "+resultPick[i].getObject().getParent().getUserData());
								if(!bandera){
									paux.negate();
									centro.add(paux);
								}
								else{
									Transform3D ttaux=new Transform3D();
									ttaux.rotY(-valRot);
									ttaux.transform(centro);
								}
							}
							else{
//								for(int i=0;i<BG.numChildren();i++){
//									System.out.println("hijo "+i+": "+BG.getChild(i).getUserData());
//								}
								if(bandera){
									tNueva.rotY(valRot);
									Transform3D ttaux=new Transform3D();
									ttaux.rotY(valRot);
//									taux.transform(centro);
								}
								else
									tNueva.setTranslation(new Vector3d(desp));
								
//								tNueva.setTranslation(new Vector3d(desp));
//								tNueva2.rotY(valRot);
								tAct.mul(tNueva);
								miTG.setTransform(tAct);
							}
						}
						else{
//							for(int i=0;i<BG.numChildren();i++){
//								System.out.println("hijo "+i+": "+BG.getChild(i).getUserData());
//							}
							if(bandera){
								tNueva.rotY(valRot);
								Transform3D ttaux=new Transform3D();
								ttaux.rotY(valRot);
//								taux.transform(centro);
							}
							else
								tNueva.setTranslation(new Vector3d(desp));
							tAct.mul(tNueva);
							miTG.setTransform(tAct);
						}
					}
				}
			}
		}
		wakeupOn(despertar);
	}
}
