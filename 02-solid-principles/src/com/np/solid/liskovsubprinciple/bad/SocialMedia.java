package com.np.solid.liskovsubprinciple.bad;

// Derived or child classes must be substitutable for their base or parent classes
// if class A is a subtype of class B, then we should be able to replace B with A without interrupting the behavior of
// the program
public abstract class SocialMedia {

    public abstract void chatWithFriend();

    public abstract void publishPost(Object post);

    public abstract void sendPhotosAndVideos();

    public abstract void groupVideoCall(String... users);
}