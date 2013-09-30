package com.udev.events;

import com.udev.domain.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * User: oleg.krupenya
 * Date: 9/30/13
 * Time: 8:46 AM
 */
public class KeyboardEventDispatcher {
    private List<KeyboardEventListener> listeners = new ArrayList<>();

    public void addEventListener(KeyboardEventListener keyboardEventListener) {
        this.listeners.add(keyboardEventListener);
    }

    public void processKey(int keyCode) {
        for (KeyboardEventListener listener : listeners) {
            listener.keyPressed(keyCode);
        }
    }
}
