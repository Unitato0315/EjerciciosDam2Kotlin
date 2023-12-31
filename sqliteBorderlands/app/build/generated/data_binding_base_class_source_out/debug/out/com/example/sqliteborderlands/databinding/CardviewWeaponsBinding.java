// Generated by view binder compiler. Do not edit!
package com.example.sqliteborderlands.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sqliteborderlands.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardviewWeaponsBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button btnVolver;

  @NonNull
  public final View divider;

  @NonNull
  public final EditText etFabricante;

  @NonNull
  public final EditText etNombre;

  @NonNull
  public final ImageView imArma;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  private CardviewWeaponsBinding(@NonNull CardView rootView, @NonNull Button btnVolver,
      @NonNull View divider, @NonNull EditText etFabricante, @NonNull EditText etNombre,
      @NonNull ImageView imArma, @NonNull TextView textView, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.btnVolver = btnVolver;
    this.divider = divider;
    this.etFabricante = etFabricante;
    this.etNombre = etNombre;
    this.imArma = imArma;
    this.textView = textView;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardviewWeaponsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardviewWeaponsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cardview_weapons, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardviewWeaponsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnVolver;
      Button btnVolver = ViewBindings.findChildViewById(rootView, id);
      if (btnVolver == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.etFabricante;
      EditText etFabricante = ViewBindings.findChildViewById(rootView, id);
      if (etFabricante == null) {
        break missingId;
      }

      id = R.id.etNombre;
      EditText etNombre = ViewBindings.findChildViewById(rootView, id);
      if (etNombre == null) {
        break missingId;
      }

      id = R.id.imArma;
      ImageView imArma = ViewBindings.findChildViewById(rootView, id);
      if (imArma == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new CardviewWeaponsBinding((CardView) rootView, btnVolver, divider, etFabricante,
          etNombre, imArma, textView, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
