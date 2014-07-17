package com.mascotas.rds.mascotas.Wizard.wizard.ui;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.mascotas.rds.mascotas.Wizard.Fragments.NombreMascota;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ModelCallbacks;
import com.mascotas.rds.mascotas.Wizard.wizard.model.Page;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ReviewItem;

import java.util.ArrayList;

/**
 * Created by jesus on 17/07/14.
 */
public class NombreMascotaInfoPage extends Page {

    public static final String NOMBRE_DATA_KEY = "nombre";

    public NombreMascotaInfoPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return NombreMascota.create(getKey());
    }



    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("NOMBRE", mData.getString(NOMBRE_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        Boolean nombreCompletado = !TextUtils.isEmpty(mData.getString(NOMBRE_DATA_KEY));
        return (nombreCompletado);
    }
}
