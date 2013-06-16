package examples.spend.opengl.myrenderers;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by anatoliy on 16.06.13.
 */
public abstract class IExampleRenderer implements GLSurfaceView.Renderer {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {

    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    public void onPause() {

    }

    public void onContinue() {
    }
}
