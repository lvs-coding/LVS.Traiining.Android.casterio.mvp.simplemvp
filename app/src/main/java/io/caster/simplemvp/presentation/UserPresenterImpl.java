package io.caster.simplemvp.presentation;

import hugo.weaving.DebugLog;
import io.caster.simplemvp.model.User;
import io.caster.simplemvp.repository.UserRepository;
import io.caster.simplemvp.view.UserView;

public class UserPresenterImpl implements UserPresenter {

    private UserView view;
    private UserRepository userRepository;
    private User u;


    @DebugLog
    public UserPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @DebugLog
    @Override
    public void loadUserDetails() {
        int userId = view.getUserId();
        u = userRepository.getUser(userId);
        if(u == null) {
            view.showUserNotFoundMessage();
        } else {
            view.displayFirstName(u.getFirstName());
            view.displayLastName(u.getLastName());
        }
    }

    @DebugLog
    @Override
    public void setView(UserView view) {
        this.view = view;
        loadUserDetails();
    }

    @DebugLog
    @Override
    public void saveUser() {
        if(u != null) {
            if(view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showUserNameIsRequired();
            } else {
                u.setFirstName(view.getFirstName());
                u.setLastName(view.getLastName());
                userRepository.save(u);
                view.showUserSavedMessage();
            }

        }
    }
}
