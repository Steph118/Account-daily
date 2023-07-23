package com.example.myapp.dialog;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class InfosDialog extends DialogFragment {

    private int title, message , positiveText , negativeText;
    private Integer icon = null;

    public InfosDialog() {
    }

    public InfosDialog(int title, int message, int positiveText, int negativeText, Integer icon) {
        this.title = title;
        this.message = message;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.icon = icon;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        if (icon!=null){
            builder.setIcon(icon);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, (dialog, which) -> {
                    this.dismiss();
                    InscriptionFragment inscriptionFragment = InscriptionFragment.instance();
                    inscriptionFragment.show(getParentFragmentManager(), InscriptionFragment.TAG);
                })
                .setNegativeButton(negativeText,(dialog, which) -> this.dismiss());
        return builder.create();
    }
}
