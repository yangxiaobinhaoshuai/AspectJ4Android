# AspectJ4Android

`AspectJ4Android` 是一个在 Android 平台应用 AspectJ 的 Gradle 插件。


## 使用
在你的项目根目录的 build.gradle 文件中
```
 dependencies {
        // add this
        classpath 'com.handsome:aspectJ4Android:0.1.0'
    }
   
```

在 app 目录的 build.gradle 文件中

```
apply plugin: 'aspectj4Android'

dependencies {
   implementation 'org.aspectj:aspectjrt:1.9.1'
}
```

That's all. Enjoy your AspectJ coding.:smile:

## 须知
- 你的项目 Android Gradle Plugin 版本需要大于等于 3.0


## 感谢
- [JakeWharton's Hugo](https://github.com/JakeWharton/hugo)
