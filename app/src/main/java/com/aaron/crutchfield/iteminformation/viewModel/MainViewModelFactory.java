package com.aaron.crutchfield.iteminformation.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Aaron Crutchfield on 6/22/2018.
 */
public class MainViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private Application application;

    public MainViewModelFactory(Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(application);
    }
}
