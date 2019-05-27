package lab5.com;

import javax.media.j3d.*;
import javax.vecmath.*;
import javax.media.j3d.Background;
import javax.swing.JFrame;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import com.sun.j3d.loaders.objectfile.ObjectFile;  
import com.sun.j3d.loaders.lw3d.Lw3dLoader;


public class Dino extends JFrame {
	private static Canvas3D canvas;
	private static SimpleUniverse universe;
	private static BranchGroup root;
	
	private static TransformGroup dino;
	
	public Dino() throws IOException {
		configureWindow();
        configureCanvas();
        configureUniverse();
        
        root = new BranchGroup();

        addImageBackground();
        
        addDirectionalLightToUniverse();
        addAmbientLightToUniverse();
        
        ChangeViewAngle();
        

        dino = getStegoGroup();
        root.addChild(dino);
        
        root.compile();
        universe.addBranchGraph(root);

    }

	private void configureWindow() {
        setTitle("Mini Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void configureCanvas() {
    	canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas, BorderLayout.CENTER);
    }

    private void configureUniverse() {
        universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }
    
    private void addImageBackground() {
    	TextureLoader t = new TextureLoader("D:\\������(��������)\\3 ����\\Comp_gr\\lab5\\source_folder\\123.png", canvas);
    	Background background = new Background(t.getImage());
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
        background.setApplicationBounds(bounds);
        root.addChild(background);
    }
    private void addDirectionalLightToUniverse() {
    	BoundingSphere bounds = new BoundingSphere();
	    bounds.setRadius(100);

	    DirectionalLight light = new DirectionalLight(new Color3f(1, 1, 1), new Vector3f(-1, -1, -1));
	    light.setInfluencingBounds(bounds);

	    root.addChild(light);

	}
    
    private void addAmbientLightToUniverse() {
    	AmbientLight light = new AmbientLight(new Color3f(1, 1, 1));
        light.setInfluencingBounds(new BoundingSphere());
        root.addChild(light);
    }
    
    private void ChangeViewAngle() {
        ViewingPlatform vp = universe.getViewingPlatform();
        TransformGroup vpGroup = vp.getMultiTransformGroup().getTransformGroup(0);
        Transform3D vpTranslation = new Transform3D();
        vpTranslation.setTranslation(new Vector3f(0, 0, 5));
        vpGroup.setTransform(vpTranslation);
    }
    private TransformGroup getStegoGroup() throws IOException {
    	Shape3D shape = getModelShape3D("polysurface164", "D:\\������(��������)\\3 ����\\Comp_gr\\lab5\\source_folder\\dinosaur.obj");

    	Transform3D transform3D = new Transform3D();
    	transform3D.setScale(new Vector3d(0.3, 0.3, 0.3)); 
    	

//
        Transform3D rotationY = new Transform3D();
        rotationY.rotY(Math.PI/2);
        transform3D.mul(rotationY);

        TransformGroup group = getModelGroup(shape);
        group.setTransform(transform3D);
        
        return group;

    }
    private TransformGroup getModelGroup(Shape3D shape) {
    	TransformGroup group = new TransformGroup();
    	group.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    	group.addChild(shape);
    	return group;
    }
    
	private Shape3D getModelShape3D(String name, String path) throws IOException {
		Scene scene = getSceneFromFile(path);
    	Map<String, Shape3D> map = scene.getNamedObjects();
    	printModelElementsList(map);
    	Shape3D shape = map.get(name);
    	scene.getSceneGroup().removeChild(shape);
    	return shape;

    }
    
    private Scene getSceneFromFile(String path) throws IOException {

        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        file.setFlags(ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return file.load(new FileReader(path));

    }
    
    private void printModelElementsList(Map<String, Shape3D> map) {
    	for (String name : map.keySet()) {
    		System.out.println("Name: " + name);
    	}
    }

    public static void main(String[] args) {
        try {
        	Dino window = new Dino();
        	DinoAnimation dinoMovement = new DinoAnimation(dino);
            canvas.addKeyListener(dinoMovement);
            window.setVisible(true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    

}
