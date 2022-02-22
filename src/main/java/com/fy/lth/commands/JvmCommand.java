package com.fy.lth.commands;

import com.fy.lth.common.util.TableUtil;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableModelBuilder;

/**
 * @author fengyue
 * @date 2022/2/15
 *
 */
public class JvmCommand {

    @ShellMethod(value = "jvm相关" ,key = {"jvm"})
    public Table jvm_class(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("jps -v").addValue("查看项目启动参数");
        tableModelBuilder.addRow().addValue("System.gc()").addValue("手动gc");
        tableModelBuilder.addRow().addValue("-verbose:gc").addValue("打印gc信息");
        return TableUtil.build(tableModelBuilder);
    }


    @ShellMethod(value = "jvm_paramter相关" ,key = {"jvm_heap"})
    public Table jvm_heap(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("-Xss").addValue("堆栈大小");
        tableModelBuilder.addRow().addValue("-Xms").addValue("堆内存的初始大小,默认为物理内存的1/64");
        tableModelBuilder.addRow().addValue("-Xmx").addValue("堆内存的最大大小,默认为物理内存的1/4");
        tableModelBuilder.addRow().addValue("-Xmn").addValue("堆内新生代的大小");
        tableModelBuilder.addRow().addValue("-XX:NewRatio").addValue("新生代和老年代的比值,为3，表示年轻代与老年代比值为1：3");
        tableModelBuilder.addRow().addValue("-XX:MaxTenuringThreshold").addValue("转入老年代的存活次数");
        tableModelBuilder.addRow().addValue("-XX:SurvivorRatio").addValue("新生代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：为3，表示Eden：Survivor=3：2，一个Survivor区占整个新生代的1/5  ");
        tableModelBuilder.addRow().addValue("-XX:PermSize、-XX:MaxPermSize").addValue("设置永久代最小大小与最大大小（Java8以前）");
        tableModelBuilder.addRow().addValue("-XX:MetaspaceSize、-XX:MaxMetaspaceSize").addValue("设置元空间最小大小与最大大小（Java8以后）");
        return TableUtil.build(tableModelBuilder);
    }


    @ShellMethod(value = "jvm_paramter相关" ,key = {"jvm_gc"})
    public Table jvm_gc(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("-XX:+PrintGC").addValue("");
        tableModelBuilder.addRow().addValue("-XX:+PrintGCDetails").addValue("");
        tableModelBuilder.addRow().addValue("-XX:+PrintGCTimeStamps").addValue("");
        tableModelBuilder.addRow().addValue("-Xloggc:filename").addValue("");
        return TableUtil.build(tableModelBuilder);
    }


    @ShellMethod(value = "jvm_paramter相关" ,key = {"jvm_other"})
    public Table jvm_other(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("-XX:UseBiasedLocking=false").addValue("关闭偏向锁");
        return TableUtil.build(tableModelBuilder);
    }
}
