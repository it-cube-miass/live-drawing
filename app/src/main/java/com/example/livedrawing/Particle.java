package com.example.livedrawing;

import android.graphics.PointF;

public class Particle {
    PointF velocity;
    PointF position;

    Particle(PointF direction) {
        velocity = new PointF();
        position = new PointF();

        velocity.x = direction.x;
        velocity.y = direction.y;
    }
}
