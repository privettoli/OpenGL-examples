package examples.spend.opengl.myrenderers;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by anatoliy on 15.06.13.
 */
public class Renderer02 extends IExampleRenderer {

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClearColor((float) Math.random(), (float) Math.random(), (float) Math.random(), (float) Math.random());

        GLES20.glClear( GLES20.GL_COLOR_BUFFER_BIT ); // Очищаем буффер цвета
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onContinue() {

    }
}
