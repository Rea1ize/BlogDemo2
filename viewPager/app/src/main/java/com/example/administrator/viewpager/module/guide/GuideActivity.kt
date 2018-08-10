package com.example.administrator.viewpager.module.guide

import android.os.Build.VERSION_CODES.M
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.administrator.viewpager.R
import com.example.administrator.viewpager.R.id.mViewPager
import com.example.administrator.viewpager.base.WinActivity
import com.example.administrator.viewpager.util.L
import kotlinx.android.synthetic.main.activity_guide.*

/**
 * 引导页面
 */
class GuideActivity : WinActivity() {

    //文字图片int数组
    var ids = intArrayOf(R.drawable.guide_txt_a, R.drawable.guide_txt_b, R.drawable.guide_txt_c, R.drawable.guide_txt_d)

    //用来填充viewPager的ImageView集合
    private val list = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        //初始化数据
        initData()
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        //树叶子viewPager滑动监听
        mViewPager.addOnPageChangeListener(MyOnPageChangeListener())
        //遍历ids数组
        for (i in ids.indices) {
            //每循环一次就New一个ImageView
            val imageView = ImageView(this)
            //根据ids数据的图片地址设置New出来的ImageView背景
            imageView.setBackgroundResource(ids[i])
            //将设置好的ImageView添加到集合中
            list.add(imageView)
        }
        //设置ViewPager适配器
        mViewPager.adapter = MyAdapter()
    }

    /**
     * 监听ViewPager的滑动距离
     */
    inner class MyOnPageChangeListener : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {
        }

        /**
         * 当页面滚动时
         * @param position 当前滑动页面的位置
         */
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            L.d("当前页面的位置:$position")
            when (position) {
                0 -> mImageViews.setImageResource(R.drawable.guide_img_a)
                1 -> mImageViews.setImageResource(R.drawable.guide_img_b)
                2 -> mImageViews.setImageResource(R.drawable.guide_img_c)
                3 -> mImageViews.setImageResource(R.drawable.guide_img_d)
            }
        }

        override fun onPageSelected(position: Int) {

        }
    }

    /**
     * 设置viewPager适配器
     * 这里记得把MyAdapter加上inner关键字，声明为内部类
     */
    inner class MyAdapter : PagerAdapter() {

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        /**
         * 返回数据中的中个数
         */
        override fun getCount(): Int {
            return list.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var imageView: ImageView = list[position]
            //添加到容器中
            container.addView(imageView)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            super.destroyItem(container, position, `object`)
            container.removeView(`object` as View?)
        }
    }
}
