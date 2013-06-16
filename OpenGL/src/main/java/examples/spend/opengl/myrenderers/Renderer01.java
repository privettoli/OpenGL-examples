package examples.spend.opengl.myrenderers;

import android.content.Context;
import android.content.SharedPreferences;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by anatoliy on 15.06.13.
 */
public class Renderer01 extends IExampleRenderer {
    float r, g, b, a;

    @Override
    public void onDrawFrame(GL10 gl10) {

        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        a = (float) Math.random();

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT); // Очищаем буффер цвета

        // Задаем случайный цвет и сводим с ума эпилептиков =)
        // Цвет задается в формате RGBA, от 0.0f до 1.0f.
        GLES20.glClearColor(r, g, b, a);
    }
}
