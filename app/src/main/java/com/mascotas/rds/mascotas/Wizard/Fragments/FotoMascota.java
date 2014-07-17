package com.mascotas.rds.mascotas.Wizard.Fragments;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mascotas.rds.mascotas.R;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.FotoInfoPage;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.PageFragmentCallbacks;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FotoMascota extends Fragment {

    private static final String ARG_KEY = "key";
    private static final int CAMERA_REQUEST = 1888;
    private static final int SELECT_PICTURE = 1;

    public ImageView imageView;

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private FotoInfoPage mPage;

    public FotoMascota() {
        // Required empty public constructor
    }

    public static FotoMascota create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        FotoMascota fragment = new FotoMascota();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_foto_mascota, container, false);

        imageView = (ImageView)rootView.findViewById(R.id.imagen);

        Button camaraButton = (Button) rootView.findViewById(R.id.camara);
        camaraButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Button galeriaButton = (Button) rootView.findViewById(R.id.galeria);
        galeriaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
        }

        mCallbacks = (PageFragmentCallbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

            // TODO http://stackoverflow.com/questions/9941637/android-how-to-save-camera-images-in-database-and-display-another-activity-in-li

        }
    }
}
