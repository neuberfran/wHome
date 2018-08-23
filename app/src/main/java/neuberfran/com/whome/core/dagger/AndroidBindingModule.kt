package neuberfran.com.whome.core.dagger

import neuberfran.com.whome.core.dagger.scope.ActivityScope
import neuberfran.com.whome.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
