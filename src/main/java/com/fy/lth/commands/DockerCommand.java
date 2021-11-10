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
 * @date 2021/11/9
 */
@ShellComponent
@ShellCommandGroup(value = "docker")
public class DockerCommand {

    @ShellMethod(value = "docker", key = {"docker"})
    public Table docker() {
        TableModelBuilder builder = TableUtil.create(null);
        builder.addRow().addValue("").addValue("paka/paka_mysql 为容器的name");
        builder.addRow().addValue("docker logs -f --tail=1000 paka").addValue("实时查看指定容器的最新1000行日志");
        builder.addRow().addValue("docker exec -it paka bash").addValue("以bash方式进入容器控制台");
        builder.addRow().addValue("docker exec -it paka_mysql sh -c \"mysql -uroot -pZD71SEx82jg=\" ").addValue("进入mysql容器");
        builder.addRow().addValue("docker logs | grep \"XXX\" paka").addValue("过滤容器的日志");
        builder.addRow().addValue("docker logs paka | grep -A n  \"XXX\"").addValue("过滤容器的日志并显示匹配后和它后面的n行。");
        builder.addRow().addValue("docker logs paka | grep -B n  \"XXX\"").addValue("过滤容器的日志并显示匹配后和它前面的n行。");
        builder.addRow().addValue("docker logs paka | grep -C n  \"XXX\"").addValue("过滤容器的日志并显示匹配后和它前后的n行。");

        TableModel tableModel = builder.build();
        TableBuilder tableBuilder = new TableBuilder(tableModel);
        tableBuilder.on(CellMatchers.table()).addSizer(new ChinesSizeConstraints()).and();
        return tableBuilder.addFullBorder(BorderStyle.fancy_light).build();
    }
}
