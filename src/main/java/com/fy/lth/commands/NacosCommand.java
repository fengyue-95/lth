package com.fy.lth.commands;

import com.fy.lth.common.ChinesSizeConstraints;
import com.fy.lth.common.util.TableUtil;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.shell.table.TableModelBuilder;

/**
 * @author fengyue
 * @date 2022/9/2
 */

@ShellComponent
@ShellCommandGroup(value = "nacos")
public class NacosCommand {

    @ShellMethod(value = "nacos命令", key = {"nacos_gz"})
    public Table nacos_gz() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("sh startup.sh -m standalone").addValue("单机启动nacos");

        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }

}