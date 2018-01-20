package com.ibrahimyousre.resumebuilder.helper;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by ibrahim on 1/19/18.
 */


public abstract class TextChangeListener implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public abstract void onTextChanged(CharSequence s, int start, int before, int count);

    @Override
    public void afterTextChanged(Editable s) {

    }
}