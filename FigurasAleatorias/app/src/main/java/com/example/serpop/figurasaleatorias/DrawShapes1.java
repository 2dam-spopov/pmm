package com.example.serpop.figurasaleatorias;


import android.os.Bundle;
import android.view.View;

public class DrawShapes1 extends MainActivity {
    private RandomShapeView mDrawingArea;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shape1);
        mDrawingArea = (RandomShapeView) findViewById(R.id.drawing_area);
    }

    /**
     * Handles events for the button. Redraws the ShapeView.
     */
    public void redraw(View clickedButton) {
        mDrawingArea.invalidate();
    }

}