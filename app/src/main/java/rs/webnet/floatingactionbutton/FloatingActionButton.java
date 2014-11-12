package rs.webnet.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Kursulla on 11/11/14.
 */
public class FloatingActionButton extends RelativeLayout {

    private static final String TAG = "FloatingActionButton";
    private RelativeLayout fab;
    private ImageView fabIcon;
    private ImageView fabIconBgd;
    private RelativeLayout fabActionBgd;
    private LinearLayout fabContentContainer;
    private int screenHeight;
    private boolean opened = false;

    private int animationSpeed = 200;
    private int rotationAngle = 450;
    private String dimmedBackgroundColor;
    private int buttonBackground;
    private int iconClosed;
    private int iconOpened;


    public FloatingActionButton(Context context) {
        super(context);
        _init(context);
    }

    public FloatingActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        _init(context);
    }

    public FloatingActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        _init(context);
    }


    private void _init(Context context) {
        inflate(context, R.layout.floating_action_button, this);

        _getScreenHeight(context);
        _getReferences();
        _hideActionContent();
        _setListeners();
    }

    private void _getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
    }

    private void _getReferences() {
        fab = (RelativeLayout) findViewById(R.id.fab);
        fabIcon = (ImageView) fab.findViewById(R.id.fabIcon);
        fabIconBgd = (ImageView) fab.findViewById(R.id.fabIconBgd);
        fabActionBgd = (RelativeLayout) fab.findViewById(R.id.fabActionBgd);
        fabContentContainer = (LinearLayout) fab.findViewById(R.id.fabContentContainer);
    }

    private void _hideActionContent() {
        fabActionBgd.animate().setDuration(1).alpha(0);
        for (int i = 0; i < fabContentContainer.getChildCount(); i++) {
            View child = fabContentContainer.getChildAt(i);
            child.animate().setDuration(1).y(screenHeight + child.getHeight());
        }
    }

    private void _setListeners() {
        fabIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opened) {
                    close();
                } else {
                    open();
                }
            }
        });


        fabActionBgd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
    }

    public void open() {
        opened = true;
        fabActionBgd.setVisibility(VISIBLE);
        fabContentContainer.setVisibility(VISIBLE);

        _animateIconToOpenedState();
        fabActionBgd.animate().setDuration(animationSpeed).alpha(1);

        for (int i = 0; i < fabContentContainer.getChildCount(); i++) {
            View child = fabContentContainer.getChildAt(i);
            child.animate().setDuration(animationSpeed + 10).translationY(0).start();
        }
    }

    public void close() {
        opened = false;

        _animateIconToClosedState();
        fabActionBgd.animate().setDuration(animationSpeed).alpha(0);

        for (int i = 0; i < fabContentContainer.getChildCount(); i++) {
            View child = fabContentContainer.getChildAt(i);
            child.animate().setDuration(animationSpeed + 10).translationY(+screenHeight + child.getHeight()).start();
        }
    }

    private void _animateIconToOpenedState() {
        fabIcon.animate().rotation(rotationAngle).setDuration(animationSpeed).start();
        fabIcon.animate().alpha(0.2f).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fabIcon.setImageResource(iconOpened);
                fabIcon.animate().setDuration(animationSpeed / 2).alpha(1f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void _animateIconToClosedState() {
        fabIcon.animate().rotation(0).setDuration(animationSpeed).start();
        fabIcon.animate().alpha(0.2f).setDuration(animationSpeed/2).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fabIcon.setImageResource(iconClosed);
                fabIcon.animate().setDuration(animationSpeed / 2).alpha(1f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void addItem(View view) {
        view.animate().setDuration(animationSpeed + 10).translationY(+screenHeight + view.getHeight()).start();
        fabContentContainer.addView(view);
    }

    public int getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public String getDimmedBackgroundColor() {
        return dimmedBackgroundColor;
    }

    public void setDimmedBackgroundColor(String dimmedBackgroundColor) {
        this.dimmedBackgroundColor = dimmedBackgroundColor;
        fabActionBgd.setBackgroundColor(Color.parseColor(this.dimmedBackgroundColor));
    }

    public int getIconClosed() {
        return iconClosed;
    }

    public void setIconClosed(int iconClosed) {
        this.iconClosed = iconClosed;
        fabIcon.setImageResource(this.iconClosed);
    }

    public int getIconOpened() {
        return iconOpened;
    }

    public void setIconOpened(int iconOpened) {
        this.iconOpened = iconOpened;
    }

    public int getButtonBackground() {
        return buttonBackground;
    }

    public void setButtonBackground(int buttonBackground) {
        this.buttonBackground = buttonBackground;
        fabIconBgd.setImageResource(buttonBackground);
    }

    public int getRotationAngle() {
        return rotationAngle;
    }

    public void setRotationAngle(int rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
}
