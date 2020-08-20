# GestureDetectorDemo
Android 手势控制
#### onSingleTapConfirmed 和 onSingleTapUp

双击触发流程
```
onDown
onSingleTapUp
onDoubleTap
onDoubleTapEvent
onDown
onDoubleTapEvent
```
单击
```
onDown
onSingleTapUp
onSingleTapConfirmed
```

**双击不会触发 `onSingleTapConfirmed`**

**应用场景**

视频播放器中 单击显示控制器view 双击播放暂停.继续

单击使用`onSingleTapConfirmed`更合适
