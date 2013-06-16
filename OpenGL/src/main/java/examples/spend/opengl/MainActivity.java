package examples.spend.opengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import examples.spend.opengl.myrenderers.IExampleRenderer;
import examples.spend.opengl.myrenderers.Renderer01;
import examples.spend.opengl.myrenderers.Renderer02;

import java.util.Locale;

public class MainActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
     * will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(mSectionsPagerAdapter.COUNT-1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * A dummy fragment representing a section of the app, but that simply
     * displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
        private GLSurfaceView glSurfaceView;
        private IExampleRenderer renderer;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            glSurfaceView = (GLSurfaceView) inflater.inflate(R.layout.fragment_main_dummy, container, false);

            glSurfaceView = new GLSurfaceView(getActivity().getApplicationContext());
            glSurfaceView.setEGLContextClientVersion(2);
            if (renderer != null) {
                renderer.setContext(this.getActivity().getApplicationContext());
                glSurfaceView.setRenderer(renderer);
            }
            glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

            return glSurfaceView;
        }

        public void setRenderer(IExampleRenderer renderer) {
            this.renderer = renderer;
        }
        @Override
        public void onPause() {
            if (glSurfaceView != null) {
                glSurfaceView.onPause();
                renderer.onPause();
            }

            super.onPause();
        }

        @Override
        public void onResume() {
            if (glSurfaceView != null) {
                glSurfaceView.onResume();
                renderer.onContinue();
            }
            super.onResume();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final int COUNT = 2;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a DummySectionFragment (defined as a static inner class
            // below) with the page number as its lone argument.
            DummySectionFragment fragment = new DummySectionFragment();
            IExampleRenderer renderer = null;
            switch (position) {
                case 0:
                    renderer = new Renderer01();
                    break;
                case 1:
                    renderer = new Renderer02();
                    break;
            }
            fragment.setRenderer(renderer);
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase();
                default:
                    return "Ошибка";
            }
        }
    }

}
