package com.mascotas.rds.mascotas.Wizard.wizard.ui;

import android.support.v4.app.Fragment;

import com.mascotas.rds.mascotas.Wizard.Fragments.FotoMascota;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ModelCallbacks;
import com.mascotas.rds.mascotas.Wizard.wizard.model.Page;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ReviewItem;

import java.util.ArrayList;

/**
 * Created by jesus on 17/07/14.
 */
public class FotoInfoPage extends Page {

    public static final String FOTO_DATA_KEY = "foto";

    public FotoInfoPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return FotoMascota.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("FOTO", mData.getString(FOTO_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {

        return true;
    }
}
