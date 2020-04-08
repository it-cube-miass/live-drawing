package com.example.livedrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LiveDrawingView extends SurfaceView implements Runnable {
    private final boolean DEBUGGING = true;

    private SurfaceHolder holder;
    private Canvas canvas;
    private Paint paint;

    private long fps;
    private final int MS_IN_SECONDS = 1000;

    private int screenX;
    private int screenY;
    private int fontSize;
    private int marginSize;

    private Thread thread = null;
    private volatile boolean drawing;
    private boolean paused = true;

    public LiveDrawingView(Context context, int x, int y) {
        super(context);

        screenX = x;
        screenY = y;
        fontSize = screenX / 20;
        marginSize = screenX / 75;
        holder = getHolder();
        paint = new Paint();
    }

    private void draw() {
        if (holder.getSurface().isValid()) {
            canvas = holder.lockCanvas();

            canvas.drawColor(Color.BLACK);
            if (DEBUGGING) {
                printDebugginText();
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    private void printDebugginText() {
        int startX = 150;
        int startY = marginSize;
        int yLine1 = startY + fontSize;
        paint.setTextSize(fontSize);
        canvas.drawText("fps: " + fps, startX, yLine1, paint);
    }

    @Override
    public void run() {

    }
}
