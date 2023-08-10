package com.np.solid.liskovsubprinciple.bad;

// obviously Instagram is not a substitution for SocialMedia supertype
public class Instagram extends SocialMedia {

    @Override
    public void chatWithFriend() {
        // logic
    }

    @Override
    public void publishPost(Object post) {
        // logic
    }

    @Override
    public void sendPhotosAndVideos() {
        // logic
    }

    @Override
    public void groupVideoCall(String... users) {
        // Not applicable
    }
}
