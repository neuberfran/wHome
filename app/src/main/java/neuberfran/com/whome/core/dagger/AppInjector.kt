package neuberfran.com.whome.core.dagger


import neuberfran.com.whome.App
import neuberfran.com.whome.core.dagger.AppModule

object AppInjector {

    fun init(app: App) {
        DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
                .inject(app)
    }
}
