package io.caster.simplemvp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hugo.weaving.DebugLog;
import io.caster.simplemvp.presentation.UserPresenter;
import io.caster.simplemvp.presentation.UserPresenterImpl;
import io.caster.simplemvp.repository.UserRepository;
import io.caster.simplemvp.repository.InMemoryUserRepositoryImpl;

@Module
public class AppModule {
    @Provides @Singleton @DebugLog
    public UserRepository provideUserRepository() {
        return new InMemoryUserRepositoryImpl();
    }

    @Provides @DebugLog
    public UserPresenter provideUserPresenter(UserRepository userRepository) {
        return new UserPresenterImpl(userRepository);
    }
}
