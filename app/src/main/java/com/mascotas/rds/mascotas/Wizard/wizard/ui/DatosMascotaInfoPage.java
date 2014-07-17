package com.mascotas.rds.mascotas.Wizard.wizard.ui;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.mascotas.rds.mascotas.Wizard.Fragments.DatosMascota;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ModelCallbacks;
import com.mascotas.rds.mascotas.Wizard.wizard.model.Page;
import com.mascotas.rds.mascotas.Wizard.wizard.model.ReviewItem;

import java.util.ArrayList;

/**
 * Created by jesus on 17/07/14.
 */
public class DatosMascotaInfoPage extends Page {

    public static final String CHIP_DATA_KEY = "chip";
    public static final String FECHA_DATA_KEY = "fecha";

    public static final String RAZA_DATA_KEY = "raza";
    public static final String PESO_DATA_KEY = "peso";

    public DatosMascotaInfoPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return DatosMascota.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("CHIP", mData.getString(CHIP_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("FECHA", mData.getString(FECHA_DATA_KEY), getKey(), -1));

        dest.add(new ReviewItem("RAZA", mData.getString(RAZA_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("PESO", mData.getString(PESO_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        Boolean chipCompletado = !TextUtils.isEmpty(mData.getString(CHIP_DATA_KEY));
        Boolean fechaCompletado = !TextUtils.isEmpty(mData.getString(FECHA_DATA_KEY));

        Boolean razaCompletado = !TextUtils.isEmpty(mData.getString(RAZA_DATA_KEY));
        Boolean pesoCompletado = !TextUtils.isEmpty(mData.getString(PESO_DATA_KEY));

        return (chipCompletado && fechaCompletado && razaCompletado && pesoCompletado);
    }


}
