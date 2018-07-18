package com.aspectj.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.MessageHandler;
import org.aspectj.tools.ajc.Main;
import org.gradle.api.DomainObjectSet;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.tasks.compile.JavaCompile;

import java.io.File;
import java.util.List;

/**
 * Created by handsomeyang on 2018/7/13.
 *
 * @author handsomeyang
 */
public class AspectJ4AndroidPlugin implements Plugin<Project> {

    private static final String TAG = "AspectJ4AndroidPlugin";
    private Logger mLogger;
    private AppExtension mAppExtension;

    @Override
    public void apply(Project p) {
        mLogger = p.getLogger();
        // todo judge user weather has compiled the 'aspectjrt.jar'
        // add implementation 'org.aspectj:aspectjrt:1.9.1'
        p.getDependencies().add("implementation", "org.aspectj:aspectjrt:1.9.1");

        mAppExtension = p.getExtensions().getByType(AppExtension.class);
        DomainObjectSet<ApplicationVariant> applicationVariants = mAppExtension
                .getApplicationVariants();

        applicationVariants.all(applicationVariant -> {
            JavaCompile javaCompile = applicationVariant.getJavaCompile();
            javaCompile.doLast(task -> {
                String[] args = {
                        "-showWeaveInfo",
                        "-1.5",
                        "-inpath", javaCompile.getDestinationDir().toString(),
                        "-aspectpath", javaCompile.getClasspath().getAsPath(),
                        "-d", javaCompile.getDestinationDir().toString(),
                        "-classpath", javaCompile.getClasspath().getAsPath(),
                        "-bootclasspath",
                        join(mAppExtension.getBootClasspath())
                };
                // log the ajc options
                for (int i = 0; i < args.length; i++) {
                    mLogger.debug(TAG + ":" + i + " : " + args[i]);
                }

                MessageHandler msgHandler = new MessageHandler();
                // use ajc
                new Main().run(args, msgHandler);
                for (IMessage message : msgHandler.getMessages(null, true)) {
                    mLogger.error(message.getMessage(), message.getThrown());
                }
            });
        });
    }

    /**
     * convert bootClassPath<File>  to String separated by ":"
     */
    private String join(List<File> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("The parameters can't be null.");
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(
                s -> sb.append(s.getAbsolutePath()).append(File.pathSeparator)
        );
        int lastIndexOf = sb.lastIndexOf(File.pathSeparator);
        return sb.toString().substring(0, lastIndexOf);
    }

}
