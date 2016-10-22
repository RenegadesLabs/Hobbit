package com.renegades.labs.hobbit;

import android.os.Binder;

import java.lang.ref.WeakReference;

/**
 * Created by Виталик on 04.10.2016.
 */

public class LocalBinder<S> extends Binder {
    private final WeakReference<S> mService;

    public LocalBinder(final S service) {
        mService = new WeakReference<S>(service);
    }

    public S getService() {
        return mService.get();
    }

}