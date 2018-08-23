package neuberfran.com.whome.core.dagger

import neuberfran.com.whome.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import neuberfran.com.whome.core.dagger.AndroidBindingModule
import neuberfran.com.whome.core.dagger.scope.AppScope

@AppScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, AndroidBindingModule::class])
interface AppComponent {
    fun inject(app: App)
}
