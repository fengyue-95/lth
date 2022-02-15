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
        return TableUtil.build(tableModelBuilder);
    }
}
