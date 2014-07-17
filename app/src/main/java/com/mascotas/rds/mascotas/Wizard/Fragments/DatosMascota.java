package com.mascotas.rds.mascotas.Wizard.Fragments;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.TextView;

import com.mascotas.rds.mascotas.R;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.DatosMascotaInfoPage;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.PageFragmentCallbacks;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DatosMascota extends Fragment {

    private static final String ARG_KEY = "key";

    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private DatosMascotaInfoPage mPage;

    private TextView chipField;
    private TextView fechaField;
    private TextView razaField;
    private TextView pesoField;
    private DatePicker fecha2Field;


    public DatosMascota() {
        // Required empty public constructor
    }

    public static DatosMascota create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        DatosMascota fragment = new DatosMascota();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (DatosMascotaInfoPage) mCallbacks.onGetPage(mKey);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_datos_mascota, container, false);

        chipField = ((TextView) rootView.findViewById(R.id.chip));
        fechaField = ((TextView) rootView.findViewById(R.id.fecha));

        razaField = ((TextView) rootView.findViewById(R.id.raza));
        pesoField = ((TextView) rootView.findViewById(R.id.peso));


        ((TextView) rootView.findViewById(android.R.id.title)).setText(mPage.getTitle());

        chipField.setText(mPage.getData().getString(DatosMascotaInfoPage.CHIP_DATA_KEY));
        fechaField.setText(mPage.getData().getString(DatosMascotaInfoPage.FECHA_DATA_KEY));

        razaField.setText(mPage.getData().getString(DatosMascotaInfoPage.RAZA_DATA_KEY));
        pesoField.setText(mPage.getData().getString(DatosMascotaInfoPage.PESO_DATA_KEY));

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

        chipField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(DatosMascotaInfoPage.CHIP_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        fechaField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(DatosMascotaInfoPage.FECHA_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        razaField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(DatosMascotaInfoPage.RAZA_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        pesoField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(DatosMascotaInfoPage.PESO_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.
        if (chipField != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }
}
