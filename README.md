# 移动端技术

* 最低版本 5.0
* 开发工具：AndroidStudio
* 开发语言：Java

```js
iOS: Swift 项目混编 OC；
Android: Java 项目混编kotlin；
Vue: TS or JS
```

## List

## Toast

## Alert

## ImageView

## TextView

## 正则

## View 高度计算

## BannerView

## 加载更多

## 通知

## 监听

## Socket

## HTTP

## 数据库

## Cache

## 图文混排(+点击事件)

## 相册

## 音频

## 视频

## 定位

## 地图

## 动画

## NFC

## 算法

## Problem

* 添加 ActionBar
  1. 自定义 style:CustomBar 
  2. 自定义 View 里面需要嵌套一个布局，不然 ‘match_content’ 无效，会有上线间隙。
  3. 设置 padding 否者左右会有间隙。 parent.setPadding(0,0,0,0);
            parent.setContentInsetsAbsolute(0,0);
  ```java
  ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);

            if (Build.VERSION.SDK_INT >= 21) {
                actionBar.setElevation(0);
            }
            View customView = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
//            View customView = ActivityChooserView.InnerLayout.inflate(this,R.layout.custom_action_bar, null);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setCustomView(customView);
            Toolbar parent =(Toolbar) customView.getParent();
            parent.setPadding(0,0,0,0);//for tab otherwise give space in tab
            parent.setContentInsetsAbsolute(0,0);
        }
        setContentView(R.layout.activity_recycler);
  ```

* RecyclerView 使用