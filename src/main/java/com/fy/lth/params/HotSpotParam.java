package com.fy.lth.params;

import com.fy.lth.common.util.TableUtil;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableModelBuilder;

/**
 * @author fengyue
 * @date 2021/5/23
 */
@ShellComponent
@ShellCommandGroup(value = "hotspot")
public class HotSpotParam {

    @ShellMethod(value = "虚拟机常用参数导航", key = {"hotspot"})
    public Table hotspotTable() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("-XX:+TraceClassLoading").addValue("查看类加载过程");
        builder.addRow().addValue("-Xint").addValue("只用解释器进行，不对代码进行编译，抛弃JIT（及时编译【动态编译】）");
        builder.addRow().addValue("-Xcomp").addValue("关闭解释器，不要进行解释执行，或者叫作最大优化级别，会导致启动变慢，内存消耗大");
        return TableUtil.build(builder);
    }
}
