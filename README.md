# AspectJ4Android

`AspectJ4Android` is a gradle plugin for AspectJ programming on Android platform.


## Usage
In your project build.gradle 
```
 dependencies {
        classpath 'com.android.tools.build:gradle:3.1.3'
        // add this
        classpath 'com.handsome:aspectJ4Android:0.1.0'
        
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
   
```

In your app build.gradle

```
apply plugin: 'aspectj4Android'
```

That's all. Enjoy your AspectJ coding.:smile:

## Attention
- Your gradle plugin for Android version >= 3.0


## Thanks
- [JakeWharton's Hugo](https://github.com/JakeWharton/hugo)