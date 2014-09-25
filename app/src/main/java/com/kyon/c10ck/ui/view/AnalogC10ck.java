package com.kyon.c10ck.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

import com.kyon.c10ck.stable.KUIConstants;

/**
 * Created by slynero on 14-9-25.
 * Copyright © 2014 FineSoft. All rights reserved.
 */
public class AnalogC10ck extends View {
    private int width;
    private int height;
    private Canvas canvas;

    public AnalogC10ck(Context context) {
        super(context);
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        width = params.width;
        height = params.height;
        if (width > 0 && height > 0) {
            refreshSize();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
    }

    private void refreshSize() {
        int minSize = KUIConstants.MIN_CANVAS_SIZE;
        width = width > minSize ? width : minSize;
        height = height > minSize ? height : minSize;
        canvas.clipRect(0,0,width,height);
    }
}
