package com.np.solid.liskovsubprinciple.good;

// the functionalities are segregated
public class Instagram implements SocialNetwork, SocialPostAndMediaManager {

    public void chatWithFriend() {
        //logic
    }

    public void sendPhotosAndVideos() {
        //logic
    }

    public void publishPost(Object post) {
        //logic
    }
}