package com.example.cc15.anwesha2017.transformers;

import android.view.View;

public class ZoomOutTransformer extends BaseTransformer {
    @Override
    protected void onTransform(View view, float position) {
        final float scale = 1f + Math.abs(position);
        view.setScaleX(scale);
        view.setScaleY(scale);
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(view.getWidth() * 0.5f);
        view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
        if(position < -0.9){
            view.setTranslationX(view.getWidth() * position);
        }
    }
}