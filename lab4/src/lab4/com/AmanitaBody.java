package lab4.com;

import java.awt.Container;
import javax.media.j3d.*; // for transform

import java.awt.Color;
import com.sun.j3d.utils.geometry.*;
import javax.vecmath.*; // for Vector3f
import com.sun.j3d.utils.image.TextureLoader;

public class AmanitaBody {
	
	public static Cone getCone(float height, float radius) {   
		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;   
		return new Cone(radius, height, primflags, getTopAppearence());  
	} 
	public static Cylinder getCylinder(float radius, float height) {
		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
		return new Cylinder(radius, height, primflags, getLegAppearence());
	}
	public static Cylinder getCylinderMiddle(float radius, float height) {
		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
		return new Cylinder(radius, height, primflags, getTopAppearence());
	}
	
	 
	public static Appearance getTopAppearence() {
		// завантажуЇмо текстуру
        TextureLoader loader = new TextureLoader("D:\\универ(люблю ѕ»)\\3 курс\\Comp_gr\\lab4\\sourse_folder\\top.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        // задаЇмо властивост≥ границ≥ текстури
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        // встановлюЇмо атрибути текстури
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE); // може бути REPLACE, BLEND або DECAL зам≥сть MODULATE

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(100,38, 38));
        Color3f diffuse = new Color3f(new Color(178,38, 38));
        Color3f specular = new Color3f(new Color(0,0, 0));
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
	}
	
	public static Appearance getLegAppearence() {
		// завантажуЇмо текстуру
        TextureLoader loader = new TextureLoader("D:\\универ(люблю ѕ»)\\3 курс\\Comp_gr\\lab4\\sourse_folder\\noga.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        // задаЇмо властивост≥ границ≥ текстури
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        // встановлюЇмо атрибути текстури
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.REPLACE); // може бути REPLACE, BLEND або DECAL зам≥сть MODULATE

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(0,0, 0));
        Color3f ambient = new Color3f(new Color(100,38, 38));
        Color3f diffuse = new Color3f(new Color(178,38, 38));
        Color3f specular = new Color3f(new Color(0,0, 0));
        // ambient, emissive, diffuse, specular, 1.0f
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;

    }
}
