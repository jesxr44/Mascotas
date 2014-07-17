/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mascotas.rds.mascotas.Wizard;

import android.content.Context;

import com.mascotas.rds.mascotas.R;
import com.mascotas.rds.mascotas.Wizard.wizard.model.AbstractWizardModel;
import com.mascotas.rds.mascotas.Wizard.wizard.model.BranchPage;
import com.mascotas.rds.mascotas.Wizard.wizard.model.CustomerInfoPage;
import com.mascotas.rds.mascotas.Wizard.wizard.model.MultipleFixedChoicePage;
import com.mascotas.rds.mascotas.Wizard.wizard.model.PageList;
import com.mascotas.rds.mascotas.Wizard.wizard.model.SingleFixedChoicePage;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.DatosMascotaInfoPage;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.FotoInfoPage;
import com.mascotas.rds.mascotas.Wizard.wizard.ui.NombreMascotaInfoPage;

public class MascotaWizardModel extends AbstractWizardModel {
    public MascotaWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(
                new BranchPage(this, "Seleccione mascota")

                        
                        .addBranch("Perro",

                                new NombreMascotaInfoPage(this, "Introducir nombre")
                                        .setRequired(true),

                                new DatosMascotaInfoPage(this, "Datos")
                                        .setRequired(true),

                                new FotoInfoPage(this, "Foto")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Bread")
                                        .setChoices("White", "Wheat", "Rye", "Pretzel", "Ciabatta")
                                        .setRequired(true),

                                new MultipleFixedChoicePage(this, "Meats")
                                        .setChoices("Pepperoni", "Turkey", "Ham", "Pastrami",
                                                "Roast Beef", "Bologna"),

                                new MultipleFixedChoicePage(this, "Veggies")
                                        .setChoices("Tomatoes", "Lettuce", "Onions", "Pickles",
                                                "Cucumbers", "Peppers"),

                                new MultipleFixedChoicePage(this, "Cheeses")
                                        .setChoices("Swiss", "American", "Pepperjack", "Muenster",
                                                "Provolone", "White American", "Cheddar", "Bleu"),

                                new BranchPage(this, "Toasted?")
                                        .addBranch("Yes",
                                                new SingleFixedChoicePage(this, "Toast time")
                                                        .setChoices("30 seconds", "1 minute",
                                                                "2 minutes")
                                        )
                                        .addBranch("No")
                                        .setValue("No")
                        )
                        

                        .addBranch("Gato",

                                new NombreMascotaInfoPage(this, "Introducir nombre")
                                        .setRequired(true),

                                new DatosMascotaInfoPage(this, "Datos")
                                        .setRequired(true),

                                new FotoInfoPage(this, "Foto")
                                        .setRequired(true),
                                new SingleFixedChoicePage(this, "Salad type")
                                        .setChoices("Greek", "Caesar")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Dressing")
                                        .setChoices("No dressing", "Balsamic", "Oil & vinegar",
                                                "Thousand Island", "Italian")
                                        .setValue("No dressing")
                        )


                        .addBranch("Otro",

                                new NombreMascotaInfoPage(this, "Introducir nombre")
                                        .setRequired(true),

                                new DatosMascotaInfoPage(this, "Datos")
                                        .setRequired(true),

                                new FotoInfoPage(this, "Foto")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Salad type")
                                        .setChoices("Greek", "Caesar")
                                        .setRequired(true),

                                new SingleFixedChoicePage(this, "Dressing")
                                        .setChoices("No dressing", "Balsamic", "Oil & vinegar",
                                                "Thousand Island", "Italian")
                                        .setValue("No dressing")
                        )

                        .setRequired(true),

                new CustomerInfoPage(this, "Your info")
                        .setRequired(true)
        );
    }
}
