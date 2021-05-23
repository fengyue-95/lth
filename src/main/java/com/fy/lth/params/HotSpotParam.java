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
        return TableUtil.build(builder);
    }
}
