package vp.ali.sunstone_android_assignment.Adapter

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import vp.ali.sunstone_android_assignment.Fragments.ImageFragment
import vp.ali.sunstone_android_assignment.Fragments.VideoFragment

class MyPagerAdapter (fragmentManager: FragmentManager,lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return VideoFragment()
            1 -> return ImageFragment()
        }
        return ImageFragment()
    }
}