package com.iammert.library.ui.multisearchviewlib;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public abstract class ViewMultiSearchContainerBinding extends ViewDataBinding {
  @NonNull
  public final HorizontalScrollView horizontalScrollView;

  @NonNull
  public final LinearLayout layoutItemContainer;

  @NonNull
  public final View viewIndicator;

  protected ViewMultiSearchContainerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, HorizontalScrollView horizontalScrollView,
      LinearLayout layoutItemContainer, View viewIndicator) {
    super(_bindingComponent, _root, _localFieldCount);
    this.horizontalScrollView = horizontalScrollView;
    this.layoutItemContainer = layoutItemContainer;
    this.viewIndicator = viewIndicator;
  }

  @NonNull
  public static ViewMultiSearchContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMultiSearchContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMultiSearchContainerBinding>inflate(inflater, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search_container, root, attachToRoot, component);
  }

  @NonNull
  public static ViewMultiSearchContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMultiSearchContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMultiSearchContainerBinding>inflate(inflater, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search_container, null, false, component);
  }

  public static ViewMultiSearchContainerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ViewMultiSearchContainerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ViewMultiSearchContainerBinding)bind(component, view, com.iammert.library.ui.multisearchviewlib.R.layout.view_multi_search_container);
  }
}
