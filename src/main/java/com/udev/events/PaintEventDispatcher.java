package com.udev.events;

import com.udev.domain.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 9/26/13
 * Time: 1:00 PM
 */
public class PaintEventDispatcher {
    private List<PaintEventListener> listeners = new ArrayList<>();

    public void addEventListener(PaintEventListener paintEventListener) {
        this.listeners.add(paintEventListener);
    }

    public void paintField(Field field) {
        for (PaintEventListener listener : listeners) {
            listener.paintField(field);
        }
    }
}
