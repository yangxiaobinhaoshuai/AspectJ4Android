# [中文版 README](README_CN.md)
# AspectJ4Android

`AspectJ4Android` is a gradle plugin for AspectJ programming on Android platform.


## Usage
In your project build.gradle 
```
 dependencies {
        // add this
        classpath 'com.handsome:aspectJ4Android:0.1.0'
    }  
```

In your app build.gradle

```
apply plugin: 'aspectj4Android'

 dependencies {
    implementation 'org.aspectj:aspectjrt:1.9.1'
 }
```

That's all. Enjoy your AspectJ coding.:smile:

## Attention
- Your gradle plugin for Android version >= 3.0


## Thanks
- [JakeWharton's Hugo](https://github.com/JakeWharton/hugo)
