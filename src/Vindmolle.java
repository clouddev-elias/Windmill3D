package vindmolle;

import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import javax.swing.*;
import com.mnstarfire.loaders3d.Inspector3DS;


class VindmollePanel extends JPanel implements ActionListener
{
	Button minus = new Button("+");
	Button pluss = new Button("-");
	Tastaturtrykk t;
	Alpha rotationAlpha;

	public VindmollePanel()
	{
		setLayout(new BorderLayout());

		GraphicsConfigTemplate3D template = new GraphicsConfigTemplate3D();
		template.setSceneAntialiasing(GraphicsConfigTemplate3D.REQUIRED);

		// Get the GraphicsConfiguration that best fits our needs.
		GraphicsConfiguration gcfg =
			GraphicsEnvironment.getLocalGraphicsEnvironment().
			getDefaultScreenDevice().getBestConfiguration(template);

		Canvas3D c = new Canvas3D(gcfg);

		add("Center", c);

		Panel p =new Panel();

		p.add(minus);
		p.add(pluss);
		add("North",p);

		pluss.addActionListener(this);
		minus.addActionListener(this);

		// Create a simple scene and attach it to the virtual
		// universe

		BranchGroup scene = createSceneGraph();
		UniverseBuilder u = new UniverseBuilder(c);
		u.addBranchGraph(scene);
	}

	public BranchGroup createSceneGraph() {

		// Create the root of the branch graph

		BranchGroup objRoot = new BranchGroup();


		// Create the TransformGroup node and initialize it to the
		// identity. Enable the TRANSFORM_WRITE capability so that
		// our behavior code can modify it at run time. Add it to
		// the root of the subgraph.

		TransformGroup TGBlad1   = new TransformGroup();
		TransformGroup TGBlad2   = new TransformGroup();
		TransformGroup TGRotator = new TransformGroup();


		TGRotator.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		objRoot.addChild(TGRotator);

		// Add the fundament and the base in the scene graph

		/*objRoot.addChild(new Base().getShape());
      objRoot.addChild(new Fundament().getShape());*/

		Inspector3DS loader = new Inspector3DS("c:/temp/Vindmolle/fundament.3ds"); // constructor
		loader.parseIt(); // process the file
		TransformGroup fundament = loader.getModel();
		objRoot.addChild(fundament);
		// get the resulting 3D model as a Transform Group with Shape3Ds as children


		// Create a new Behavior object that will perform the
		// desired operation on the specified transform and add
		// it into the scene graph.

		Transform3D zAxis = new Transform3D();
		zAxis.rotX(Math.PI/2);
		rotationAlpha = new Alpha( -1, Alpha.INCREASING_ENABLE,0, 0,
				4000, 0, 0, 0, 0, 0);
		RotationInterpolator rotator = new RotationInterpolator(
				rotationAlpha, TGRotator, zAxis, 0.0f, (float) Math.PI*2.0f);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),200.0);
		rotator.setSchedulingBounds(bounds);
		TGRotator.addChild(rotator);

		// Add a Behavior that accepts keyboard input
		Tastaturtrykk t = new Tastaturtrykk(rotationAlpha);
		TGRotator.addChild(t);

		// Hent inn bladene
		Inspector3DS loader2 = new Inspector3DS("c:/temp/Vindmolle/blad.3ds"); // constructor
		loader2.parseIt(); // process the file
		TransformGroup blad1 = loader2.getModel();

		Inspector3DS loader3 = new Inspector3DS("c:/temp/Vindmolle/blad.3ds"); // constructor
		loader3.parseIt(); // process the file
		TransformGroup blad2 = loader3.getModel();

		Inspector3DS loader4 = new Inspector3DS("c:/temp/Vindmolle/blad.3ds"); // constructor
		loader4.parseIt(); // process the file
		TransformGroup blad3 = loader4.getModel();

		TGRotator.addChild(blad1);//TGRotator.addChild(new Blad().getShape());

		// Add the blades and rotate them
		Transform3D zAxis2 = new Transform3D();

		zAxis2.rotX(Math.PI/2);
		zAxis2.rotZ(2.0*Math.PI/3);

		TGBlad1.setTransform(zAxis2);
		TGBlad1.addChild(blad2);//TGBlad1.addChild(new Blad().getShape());

		TGBlad2.setTransform(zAxis2);
		TGBlad2.addChild(blad3);//TGBlad2.addChild(new Blad().getShape());

		TGBlad2.addChild(TGBlad1);
		TGRotator.addChild(TGBlad2);

		// Setter på lys slik at modellen blir synlig

		AmbientLight al = new AmbientLight(true,new Color3f(1,1,1));
		al.setInfluencingBounds(bounds);


		Point3f point = new Point3f(60,0,120);
		PointLight lgt1 = new PointLight();
		SpotLight lgt2 = new SpotLight();
		Color3f lColor1 = new Color3f(1.0f,1.0f,1.0f);
		lgt1.setPosition(point);
		lgt1.setColor(lColor1);
		lgt1.setInfluencingBounds(bounds);


		lgt2.setDirection(-100.0f, 0.0f, -100.0f);
		lgt2.setPosition(100.0f, 0.0f, 100.0f);
		lgt2.setSpreadAngle((float)Math.PI/64);
		lgt2.setInfluencingBounds(bounds);

		objRoot.addChild(lgt1);
		objRoot.addChild(lgt2);
		objRoot.addChild(al);

		return objRoot;
	}

	public void actionPerformed(ActionEvent e )
	{
		long oldvalue= rotationAlpha.getIncreasingAlphaDuration();
		String kommando=e.getActionCommand();
		if (kommando=="+")
		{
			rotationAlpha.setIncreasingAlphaDuration(oldvalue/2);
		}
		else if (kommando=="-")
		{
			rotationAlpha.setIncreasingAlphaDuration(oldvalue*2);
		}
	} // End actionPerformed
}

class VindmolleFrame extends JFrame
{
	public VindmolleFrame()
	{
		addWindowListener(new WindowAdapter()
		{  public void windowClosing(WindowEvent e)
		{ System.exit(0); }
		} );

		setSize(400, 400);
		setTitle(getClass().getName());

		Container contentPane = getContentPane();
		contentPane.add(new VindmollePanel());

	}
}

public class Vindmolle
{

	public static void main(String args[])
	{
		JFrame f = new VindmolleFrame();
		f.setSize(500,500);
		f.show();
	}
}


