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
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";
    private static final String ALPHA = "alpha";
    float r, g, b, a;

    public Renderer01() {
        super();
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        a = (float) Math.random();
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        for (int i=0; i<Integer.MAX_VALUE/20; ++i);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT); // Очищаем буффер цвета

        // Задаем случайный цвет и сводим с ума эпилептиков =)
        // Цвет задается в формате RGBA, от 0.0f до 1.0f.
        GLES20.glClearColor(r, g, b, a);
        r = (float) Math.random();
        g = (float) Math.random();
        b = (float) Math.random();
        a = (float) Math.random();
    }

    @Override
    public void onPause() {
        Log.e(getClass().getName(), "I'm pausing");
        SharedPreferences.Editor editor = context.getSharedPreferences(getClass().getName(), Context.MODE_PRIVATE).edit();
        editor.putFloat(RED, r);
        editor.putFloat(GREEN, g);
        editor.putFloat(BLUE, b);
        editor.putFloat(ALPHA, a);
        editor.commit();
    }

    @Override
    public void onContinue() {
        Log.e(getClass().getName(), "I'm continuing");
        SharedPreferences sharedPreferences = context.getSharedPreferences(getClass().getName(), Context.MODE_PRIVATE);
        r = sharedPreferences.getFloat(RED, 1);
        g = sharedPreferences.getFloat(GREEN, 1);
        b = sharedPreferences.getFloat(BLUE, 1);
        a = sharedPreferences.getFloat(ALPHA, 1);

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT); // Очищаем буффер цвета

        // Задаем случайный цвет и сводим с ума эпилептиков =)
        // Цвет задается в формате RGBA, от 0.0f до 1.0f.
        GLES20.glClearColor(r, g, b, a);
    }
}
