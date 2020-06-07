package neuberfran.com.whome.core.dagger

import neuberfran.com.whome.App

object AppInjector {

    fun init(app: App) {
        DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
                .inject(app)
    }
}
