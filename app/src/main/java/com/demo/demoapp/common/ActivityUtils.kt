/*
*Android assessment from 20021590
**/
package com.demo.demoapp.common

import android.annotation.SuppressLint
import androidx.core.util.Preconditions
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class ActivityUtils {
    companion object {
        @SuppressLint("RestrictedApi")
        public fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment,
                                         frameId: Int) {
            Preconditions.checkNotNull(fragmentManager)
            Preconditions.checkNotNull(fragment)
            val transaction = fragmentManager.beginTransaction()
            transaction.add(frameId, fragment)
            transaction.commit()
        }
    }
}