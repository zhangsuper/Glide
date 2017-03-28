package com.renhong.gildetest.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.renhong.gildetest.R;

/**
 * Created by Zhangrh on 17/3/9.
 */
public class CathecticPokerTypeView extends LinearLayout{

    private Context mContext;
    private static final int DEFAULT_COLOR = Color.WHITE;//默认颜色
    private static final int LEFT_POSITION = 0;//居左显示
    private static final int CENTER_POSITION = 1;//居中显示
    private static final int RIGHT_POSITION = 2;//居右显示

    public CathecticPokerTypeView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CathecticPokerTypeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray arra = context.obtainStyledAttributes(attrs, R.styleable.cathecticPokerTypeStyle);
        String pokerTypeName = arra.getString(R.styleable.cathecticPokerTypeStyle_pokerTypeName);
        int pokerTypeNameColor = arra.getColor(R.styleable.cathecticPokerTypeStyle_pokerTypeNameColor, DEFAULT_COLOR);
        int pokerTypeNamePosition = arra.getInt(R.styleable.cathecticPokerTypeStyle_pokerTypeNamePosition,CENTER_POSITION);

        String peilv = arra.getString(R.styleable.cathecticPokerTypeStyle_peilv);
        int peilvColor = arra.getInt(R.styleable.cathecticPokerTypeStyle_peilvColor,CENTER_POSITION);
        int peilvPosition = arra.getColor(R.styleable.cathecticPokerTypeStyle_peilvPosition,DEFAULT_COLOR);

        int betNumber = arra.getInt(R.styleable.cathecticPokerTypeStyle_betNumber,0);
        int betNumberColor = arra.getColor(R.styleable.cathecticPokerTypeStyle_betNumberColor,DEFAULT_COLOR);
        int betNumberPosiiton = arra.getInt(R.styleable.cathecticPokerTypeStyle_betNumberPosition,CENTER_POSITION);
        arra.recycle();
        init();
    }

    public CathecticPokerTypeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        LayoutInflater.from(mContext).inflate(R.layout.pkgame_cathectic_layout,this);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    private void initView() {
    }

}
