package jp.ne.mkb.ringring.utils;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by Li Yiming on 2018/02/08.
 */

public class BottomNavigationViewHelper {

    /**
     * BottomNavigationViewのアイテムのサイズの調整、アイコンサイズ調整、タイトルの削除
     *
     * @param view
     */
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {

            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);

            for (int i = 0; i < menuView.getChildCount(); i++) {

                /**
                 * アイテムの幅調整
                 */
                BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) menuView.getChildAt(i);
                // noinspection RestrictedApi
                bottomNavigationItemView.setShiftingMode(false);
                // チェックされた値を設定すると、ビューが更新されるみたい
                // noinspection RestrictedApi
                bottomNavigationItemView.setChecked(false);

            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
