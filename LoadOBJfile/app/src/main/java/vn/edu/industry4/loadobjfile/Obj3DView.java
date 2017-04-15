package vn.edu.industry4.loadobjfile;
import android.view.View;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;
import android.graphics.PixelFormat;
import android.os.Bundle;



public class Obj3DView extends RendererActivity {
    private Object3dContainer faceObject3D;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void initScene() {

        scene.lights().add(new Light());
        Light myLight = new Light();
        myLight.position.setY(150f);
        scene.lights().add(myLight);
        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "vn.edu.industry4.loadobjfile:raw/face_obj", true);
        myParser.parse();
        faceObject3D = myParser.getParsedObject();
        faceObject3D.position().x = faceObject3D.position().y = faceObject3D.position().z = 0.5f;
        faceObject3D.position().y = -0.5f;
        faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = .01f;
        scene.addChild(faceObject3D);
        // Depending on the model you will need to change the scale faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = 0.009f;        scene.addChild(faceObject3D);
        //scene.camera().target = faceObject3D.position();

    }

    @Override
    public void updateScene() {

        //float radians = degrees * ((float)Math.PI / 180);

        faceObject3D.rotation().x++;
        faceObject3D.rotation().z++;

        //degrees += ROTATION_SPEED;
       
    }




}







