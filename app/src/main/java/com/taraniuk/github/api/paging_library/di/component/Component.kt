package com.taraniuk.github.api.paging_library.di.component

import android.app.Application
import com.taraniuk.github.api.paging_library.di.model.AppModule
import com.taraniuk.github.api.paging_library.di.model.NetModule
import com.taraniuk.github.api.paging_library.di.model.RepositoryModule
import com.taraniuk.github.api.paging_library.di.model.ViewModelModule
import com.taraniuk.github.api.paging_library.ui.main.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [NetModule::class, ViewModelModule::class, AppModule::class, RepositoryModule::class]
)
@Singleton
interface Component {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): com.taraniuk.github.api.paging_library.di.component.Component

        @BindsInstance
        fun application(application: Application): Builder
    }
}