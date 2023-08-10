package com.np.solid.liskovsubprinciple.bad;

// obviously WhatsApp is not a substitution for SocialMedia supertype
public class WhatsApp extends SocialMedia {

    public void chatWithFriend() {
        //logic
    }

    public void publishPost(Object post) {
        //Not Applicable
    }

    public void sendPhotosAndVideos() {
        //logic
    }

    public void groupVideoCall(String... users) {
        //logic
    }
}
