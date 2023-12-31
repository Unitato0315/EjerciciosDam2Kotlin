// Generated by view binder compiler. Do not edit!
package com.example.sqliteborderlands.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sqliteborderlands.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final Button btnBorrar;

  @NonNull
  public final Button btnBuscar;

  @NonNull
  public final Button btnEditar;

  @NonNull
  public final Button btnListar;

  @NonNull
  public final Button btnVerLista;

  @NonNull
  public final EditText edNombreMain;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final Spinner spFabricante;

  @NonNull
  public final Spinner spTipo;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView txtListado;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAdd,
      @NonNull Button btnBorrar, @NonNull Button btnBuscar, @NonNull Button btnEditar,
      @NonNull Button btnListar, @NonNull Button btnVerLista, @NonNull EditText edNombreMain,
      @NonNull LinearLayout linearLayout, @NonNull Spinner spFabricante, @NonNull Spinner spTipo,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView txtListado) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.btnBorrar = btnBorrar;
    this.btnBuscar = btnBuscar;
    this.btnEditar = btnEditar;
    this.btnListar = btnListar;
    this.btnVerLista = btnVerLista;
    this.edNombreMain = edNombreMain;
    this.linearLayout = linearLayout;
    this.spFabricante = spFabricante;
    this.spTipo = spTipo;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.txtListado = txtListado;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.btnBorrar;
      Button btnBorrar = ViewBindings.findChildViewById(rootView, id);
      if (btnBorrar == null) {
        break missingId;
      }

      id = R.id.btnBuscar;
      Button btnBuscar = ViewBindings.findChildViewById(rootView, id);
      if (btnBuscar == null) {
        break missingId;
      }

      id = R.id.btnEditar;
      Button btnEditar = ViewBindings.findChildViewById(rootView, id);
      if (btnEditar == null) {
        break missingId;
      }

      id = R.id.btnListar;
      Button btnListar = ViewBindings.findChildViewById(rootView, id);
      if (btnListar == null) {
        break missingId;
      }

      id = R.id.btnVerLista;
      Button btnVerLista = ViewBindings.findChildViewById(rootView, id);
      if (btnVerLista == null) {
        break missingId;
      }

      id = R.id.edNombreMain;
      EditText edNombreMain = ViewBindings.findChildViewById(rootView, id);
      if (edNombreMain == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.spFabricante;
      Spinner spFabricante = ViewBindings.findChildViewById(rootView, id);
      if (spFabricante == null) {
        break missingId;
      }

      id = R.id.spTipo;
      Spinner spTipo = ViewBindings.findChildViewById(rootView, id);
      if (spTipo == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.txtListado;
      TextView txtListado = ViewBindings.findChildViewById(rootView, id);
      if (txtListado == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnAdd, btnBorrar, btnBuscar,
          btnEditar, btnListar, btnVerLista, edNombreMain, linearLayout, spFabricante, spTipo,
          textView3, textView4, txtListado);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
