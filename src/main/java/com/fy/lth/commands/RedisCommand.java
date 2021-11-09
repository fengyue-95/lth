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
 * @date 2021/6/1
 */
@ShellComponent
@ShellCommandGroup(value = "redis")
public class RedisCommand {

    @ShellMethod(value = "redis故障排查命令", key = {"redis_gz"})
    public Table redis_gz() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("redis-cli -h 127.0.0.1 -p 6379 --intrinsic-latency 60").addValue("查看当前redis实例60秒内最大的响应延迟。");
        builder.addRow().addValue("redis-cli -h 127.0.0.1 -p 6379 --latency-history -i 1").addValue("查看当前redis实例一段时间内最大，最小，平均访问延迟。每隔1秒采样 redis");
        builder.addRow().addValue("re di cli - h 127.0.0.1 - p 7001 -bigkeys  -i 0.1").addValue("定位大 key，指令每隔 100条 scan 指令就会休眠 O.ls, ops 就不会剧烈抬升，但是扫描的时间会变长。");

        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }

}
