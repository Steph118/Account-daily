package com.example.myapp.dialog;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class InfosDialogSimple extends DialogFragment {

    private int title, message, positiveText;
    private Integer icon = null;

    public InfosDialogSimple() {
    }

    public InfosDialogSimple(int title, int message, int positiveText, Integer icon) {
        this.title = title;
        this.message = message;
        this.positiveText = positiveText;
        this.icon = icon;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireContext());
        if (icon != null) {
            builder.setIcon(icon);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveText, (dialog, which) -> {
                    this.dismiss();
                });
        return builder.create();
    }
}
