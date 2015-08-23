package me.vivianmo.happywagon;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vivian Mo on 8/8/2015.
 */
public class WagonActivity extends Activity {

    private static final int numofstones = 15;
    private MyDBHandler dbHandler;
    private ImageView stone0;
    private ImageView stone1;
    private ImageView stone2;
    private ImageView stone3;
    private ImageView stone4;
    private ImageView stone5;
    private ImageView stone6;
    private ImageView stone7;
    private ImageView stone8;
    private ImageView stone9;
    private ImageView stone10;
    private ImageView stone11;
    private ImageView stone12;
    private ImageView stone13;
    private ImageView stone14;
    private ImageView[] allStones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //content view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wagon);

        //set up drag and drop
        findViewById(R.id.stone0).setOnTouchListener(shortListen);
        findViewById(R.id.stone1).setOnTouchListener(shortListen);
        findViewById(R.id.stone2).setOnTouchListener(shortListen);
        findViewById(R.id.stone3).setOnTouchListener(shortListen);
        findViewById(R.id.stone4).setOnTouchListener(shortListen);
        findViewById(R.id.stone5).setOnTouchListener(shortListen);
        findViewById(R.id.stone6).setOnTouchListener(shortListen);
        findViewById(R.id.stone7).setOnTouchListener(shortListen);
        findViewById(R.id.stone8).setOnTouchListener(shortListen);
        findViewById(R.id.stone9).setOnTouchListener(shortListen);
        findViewById(R.id.stone10).setOnTouchListener(shortListen);
        findViewById(R.id.stone11).setOnTouchListener(shortListen);
        findViewById(R.id.stone12).setOnTouchListener(shortListen);
        findViewById(R.id.stone13).setOnTouchListener(shortListen);
        findViewById(R.id.stone14).setOnTouchListener(shortListen);
        findViewById(R.id.t0).setOnDragListener(DropListener);
        findViewById(R.id.t1).setOnDragListener(DropListener);
        findViewById(R.id.t2).setOnDragListener(DropListener);
        findViewById(R.id.t3).setOnDragListener(DropListener);
        findViewById(R.id.t4).setOnDragListener(DropListener);
        findViewById(R.id.t5).setOnDragListener(DropListener);
        findViewById(R.id.t6).setOnDragListener(DropListener);
        findViewById(R.id.t7).setOnDragListener(DropListener);
        findViewById(R.id.t8).setOnDragListener(DropListener);
        findViewById(R.id.t9).setOnDragListener(DropListener);
        findViewById(R.id.t10).setOnDragListener(DropListener);
        findViewById(R.id.t11).setOnDragListener(DropListener);
        findViewById(R.id.t12).setOnDragListener(DropListener);
        findViewById(R.id.t13).setOnDragListener(DropListener);
        findViewById(R.id.t14).setOnDragListener(DropListener);
        findViewById(R.id.t9).setOnDragListener(DropListener);
        findViewById(R.id.b0).setOnDragListener(DropListener);
        findViewById(R.id.b1).setOnDragListener(DropListener);
        findViewById(R.id.b2).setOnDragListener(DropListener);
        findViewById(R.id.b3).setOnDragListener(DropListener);
        findViewById(R.id.b4).setOnDragListener(DropListener);
        findViewById(R.id.b5).setOnDragListener(DropListener);
        findViewById(R.id.b6).setOnDragListener(DropListener);
        findViewById(R.id.b7).setOnDragListener(DropListener);
        findViewById(R.id.b8).setOnDragListener(DropListener);
        findViewById(R.id.b9).setOnDragListener(DropListener);
        findViewById(R.id.b10).setOnDragListener(DropListener);
        findViewById(R.id.b11).setOnDragListener(DropListener);
        findViewById(R.id.b12).setOnDragListener(DropListener);
        findViewById(R.id.b13).setOnDragListener(DropListener);
        findViewById(R.id.b14).setOnDragListener(DropListener);

        //set up database and stones
        dbHandler = new MyDBHandler(this, null, null, 1);
        stone0 = (ImageView) findViewById(R.id.stone0);
        stone1 = (ImageView) findViewById(R.id.stone1);
        stone2 = (ImageView) findViewById(R.id.stone2);
        stone3 = (ImageView) findViewById(R.id.stone3);
        stone4 = (ImageView) findViewById(R.id.stone4);
        stone5 = (ImageView) findViewById(R.id.stone5);
        stone6 = (ImageView) findViewById(R.id.stone6);
        stone7 = (ImageView) findViewById(R.id.stone7);
        stone8 = (ImageView) findViewById(R.id.stone8);
        stone9 = (ImageView) findViewById(R.id.stone9);
        stone10 = (ImageView) findViewById(R.id.stone10);
        stone11 = (ImageView) findViewById(R.id.stone11);
        stone12 = (ImageView) findViewById(R.id.stone12);
        stone13 = (ImageView) findViewById(R.id.stone13);
        stone14 = (ImageView) findViewById(R.id.stone14);
        stone0.setTag(new Stone(1));
        stone1.setTag(new Stone(2));
        stone2.setTag(new Stone(3));
        stone3.setTag(new Stone(4));
        stone4.setTag(new Stone(5));
        stone5.setTag(new Stone(6));
        stone6.setTag(new Stone(7));
        stone7.setTag(new Stone(8));
        stone8.setTag(new Stone(9));
        stone9.setTag(new Stone(10));
        stone10.setTag(new Stone(11));
        stone11.setTag(new Stone(12));
        stone12.setTag(new Stone(13));
        stone13.setTag(new Stone(14));
        stone14.setTag(new Stone(15));
        allStones = new ImageView[]{stone0, stone1, stone2, stone3, stone4, stone5, stone6, stone7,
        stone8, stone9, stone10, stone11, stone12, stone13, stone14};
        initializeStones();
    }

    //sets up database on first open
    //or initialize stone positions based on database data
    private void initializeStones() {
        if (dbHandler.isEmpty()) {
            Log.d("V", "filling up table");
            FrameLayout t0 = (FrameLayout) findViewById(R.id.t0);
            FrameLayout t1 = (FrameLayout) findViewById(R.id.t1);
            FrameLayout t2 = (FrameLayout) findViewById(R.id.t2);
            FrameLayout t3 = (FrameLayout) findViewById(R.id.t3);
            FrameLayout t4 = (FrameLayout) findViewById(R.id.t4);
            FrameLayout t5 = (FrameLayout) findViewById(R.id.t5);
            FrameLayout t6 = (FrameLayout) findViewById(R.id.t6);
            FrameLayout t7 = (FrameLayout) findViewById(R.id.t7);
            FrameLayout t8 = (FrameLayout) findViewById(R.id.t8);
            FrameLayout t9 = (FrameLayout) findViewById(R.id.t9);
            FrameLayout t10 = (FrameLayout) findViewById(R.id.t10);
            FrameLayout t11 = (FrameLayout) findViewById(R.id.t11);
            FrameLayout t12 = (FrameLayout) findViewById(R.id.t12);
            FrameLayout t13 = (FrameLayout) findViewById(R.id.t13);
            FrameLayout t14 = (FrameLayout) findViewById(R.id.t14);
            dbHandler.addStone("" + t0.getId());
            dbHandler.addStone("" + t1.getId());
            dbHandler.addStone("" + t2.getId());
            dbHandler.addStone("" + t3.getId());
            dbHandler.addStone("" + t4.getId());
            dbHandler.addStone("" + t5.getId());
            dbHandler.addStone("" + t6.getId());
            dbHandler.addStone("" + t7.getId());
            dbHandler.addStone("" + t8.getId());
            dbHandler.addStone("" + t9.getId());
            dbHandler.addStone("" + t10.getId());
            dbHandler.addStone("" + t11.getId());
            dbHandler.addStone("" + t12.getId());
            dbHandler.addStone("" + t13.getId());
            dbHandler.addStone("" + t14.getId());
        }

        for (int i = 1; i <= numofstones; i++) {
            String ispot = dbHandler.getSpot(i);
            int spotid = Integer.parseInt(ispot);
            FrameLayout spot = (FrameLayout) findViewById(spotid);
            ImageView currentStone = allStones[i-1];
            FrameLayout parent = (FrameLayout) currentStone.getParent();
            parent.removeView(currentStone);
            spot.addView(currentStone);
            currentStone.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

    dragTouchListener shortListen = new dragTouchListener();

    private final class dragTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(v);
                ClipData data = ClipData.newPlainText("","");
                v.startDrag(data, dragShadow, v, 0);
                return true;
            } else {
                return false;
            }
        }

    }

    private class DragShadow extends View.DragShadowBuilder{

        ColorDrawable greyBox;

        public DragShadow(View view) {
            super(view);
            greyBox = new ColorDrawable(Color.RED);
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            View v = getView();

            int height = v.getHeight();
            int width = v.getWidth();

            greyBox.setBounds(0, 0, width, height);

            shadowSize.set(width, height);

            shadowTouchPoint.set(width/2, height/2);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            greyBox.draw(canvas);
        }
    }

    View.OnDragListener DropListener = new View.OnDragListener() {

        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch(dragEvent) {
                case DragEvent.ACTION_DRAG_STARTED:
                    View draggedView = (View) event.getLocalState();
                    draggedView.setVisibility(View.INVISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.i("Drag Event", "Entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.i("Drag Event", "Exited");
                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("Drag Event", "Dropped");
                    ImageView view = (ImageView) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    FrameLayout container = (FrameLayout) v;
                    if ((container.getChildCount() > 0)) {
                        Log.d("V", "Already stone in spot");
                        view.setVisibility(view.VISIBLE);
                    }
                    else {
                        owner.removeView(view);
                        Stone thisstone = (Stone) view.getTag();
                        int id = thisstone.get_id();
                        int spot = container.getId();
                        dbHandler.update(id, spot);
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);
                        Log.d("V", "drop success");
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    ImageView oldview = (ImageView) event.getLocalState();
                    oldview.setVisibility(oldview.VISIBLE);
                    break;
                default:
                    break;
            }
            return true;

        }
    };
}
