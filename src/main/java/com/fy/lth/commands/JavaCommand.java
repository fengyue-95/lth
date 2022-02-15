package com.fy.lth.commands;

import com.fy.lth.common.util.TableUtil;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableModelBuilder;

/**
 * @author fengyue
 * @date 2021/6/2
 */
@ShellComponent
@ShellCommandGroup(value = "java")
public class JavaCommand {

    @ShellMethod(value = "java相关" ,key = {"java"})
    public Table java_class(){
        TableModelBuilder tableModelBuilder = TableUtil.create(null);
        tableModelBuilder.addRow().addValue("javap -c -s -v -l SynchronizedDemo.class").addValue("查看字节码文件");
        tableModelBuilder.addRow().addValue("javap  -verbose SynchronizedDemo.class").addValue("查看字节码文件");
        return TableUtil.build(tableModelBuilder);
    }
}
