package com.renhong.gildetest;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class SwingAnimation extends Animation {
//    private float mMiddleDegrees;
//    private float mLeftDegrees;
//    private float mRightDegrees;
//    private int mPivotXType = ABSOLUTE;
//    private int mPivotYType = ABSOLUTE;
//    private float mPivotXValue = 0.0f;
//    private float mPivotYValue = 0.0f;
//    private float mPivotX;
//    private float mPivotY;
//
//    public SwingAnimation(float middleDegrees, float leftDegrees, float rightDegrees) {
//        mMiddleDegrees = middleDegrees;
//        mLeftDegrees = leftDegrees;
//        mRightDegrees = rightDegrees;
//        mPivotX = 0.0f;
//        mPivotY = 0.0f;
//    }
//
//    public SwingAnimation(float middleDegrees, float leftDegrees, float rightDegrees, float pivotX, float pivotY) {
//        mMiddleDegrees = middleDegrees;
//        mLeftDegrees = leftDegrees;
//        mRightDegrees = rightDegrees;
//        mPivotXType = ABSOLUTE;
//        mPivotYType = ABSOLUTE;
//        mPivotXValue = pivotX;
//        mPivotYValue = pivotY;
//        initializePivotPoint();
//    }
//
//    public SwingAnimation(float middleDegrees, float leftDegrees, float rightDegrees, int pivotXType, float pivotXValue,
//            int pivotYType, float pivotYValue) {
//    	mMiddleDegrees = middleDegrees;
//        mLeftDegrees = leftDegrees;
//        mRightDegrees = rightDegrees;
//        mPivotXValue = pivotXValue;
//        mPivotXType = pivotXType;
//        mPivotYValue = pivotYValue;
//        mPivotYType = pivotYType;
//        initializePivotPoint();
//    }
//
//    private void initializePivotPoint() {
//        if (mPivotXType == ABSOLUTE) {
//            mPivotX = mPivotXValue;
//        }
//        if (mPivotYType == ABSOLUTE) {
//            mPivotY = mPivotYValue;
//        }
//    }
//
//    @Override
//    protected void applyTransformation(float interpolatedTime, Transformation t) {
//        float degrees;
//        float leftPos = (float) (1.0/4.0);
//        float rightPos = (float) (3.0/4.0);
//        if (interpolatedTime <= leftPos) {
//        	degrees = mMiddleDegrees + ((mLeftDegrees - mMiddleDegrees) * interpolatedTime * 4);
//        } else if (interpolatedTime > leftPos && interpolatedTime < rightPos) {
//        	degrees = mLeftDegrees + ((mRightDegrees - mLeftDegrees) * (interpolatedTime-leftPos) * 2);
//        } else {
//        	degrees = mRightDegrees + ((mMiddleDegrees - mRightDegrees) * (interpolatedTime-rightPos) * 4);
//        }
//        System.out.println("degrees="+degrees);
//
//        float scale = getScaleFactor();
//        if (mPivotX == 0.0f && mPivotY == 0.0f) {
//            t.getMatrix().setRotate(degrees);
//        } else {
//            t.getMatrix().setRotate(degrees, mPivotX * scale, mPivotY * scale);
//        }
//    }
//
//    @Override
//    public void initialize(int width, int height, int parentWidth, int parentHeight) {
//        super.initialize(width, height, parentWidth, parentHeight);
//        mPivotX = resolveSize(mPivotXType, mPivotXValue, width, parentWidth);
//        mPivotY = resolveSize(mPivotYType, mPivotYValue, height, parentHeight);
//    }

    /** 控件宽 */
    private int mWidth;

    /** 控件高 */
    private int mHeight;

    /** 实例 */
    private static SwingAnimation rotateAnim;

    /**
     * 获取动画实例
     * @return 实例
     */
    public static SwingAnimation getCustomRotateAnim() {
        if (null == rotateAnim) {
            rotateAnim = new SwingAnimation();
        }
        return rotateAnim;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        this.mWidth = width;
        this.mHeight = height;
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        // 左右摇摆
        t.getMatrix().setRotate((float)(Math.sin(interpolatedTime* Math.PI*2)*10), mWidth/2, mHeight);
        super.applyTransformation(interpolatedTime, t);
    }
}
