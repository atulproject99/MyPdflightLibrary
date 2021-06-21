package atul.maurya.atullightpdflibrary.subscaleview;

@SuppressWarnings("EmptyMethod")
public interface OnAnimationEventListener {

    void onComplete();

    void onInterruptedByUser();

    void onInterruptedByNewAnim();
}