package neuberfran.com.whome.core.dagger

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import neuberfran.com.whome.core.dagger.scope.AppScope
import neuberfran.com.whome.core.dagger.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class AppModule {

    @AppScope
    @Provides fun provideDatabaseReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().reference!!
    }
}
