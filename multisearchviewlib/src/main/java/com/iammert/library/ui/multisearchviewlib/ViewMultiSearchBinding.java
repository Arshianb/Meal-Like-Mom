package com.iammert.library.ui.multisearchviewlib;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.iammert.library.ui.multisearchviewlib.databinding.MultiSearchContainerView;

public abstract class ViewMultiSearchBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatImageView imageViewSearch;

  @NonNull
  public final MultiSearchContainerView searchViewContainer;

  protected ViewMultiSearchBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppCompatImageView imageViewSearch,
      MultiSearchContainerView searchViewContainer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageViewSearch = imageViewSearch;
    this.searchViewContainer = searchViewContainer;
  }

  @NonNull
  public static ViewMultiSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMultiSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMultiSearchBinding>inflate(inflater, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search, root, attachToRoot, component);
  }

  @NonNull
  public static ViewMultiSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMultiSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMultiSearchBinding>inflate(inflater, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search, null, false, component);
  }

  public static ViewMultiSearchBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ViewMultiSearchBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ViewMultiSearchBinding)bind(component, view, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search);
  }
}
