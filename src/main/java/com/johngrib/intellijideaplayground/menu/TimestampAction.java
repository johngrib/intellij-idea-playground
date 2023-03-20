package com.johngrib.intellijideaplayground.menu;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * 현재 시간을 사용자에게 보여주는 액션.
 */
public class TimestampAction extends AnAction {
    private final Logger logger = Logger.getInstance(TimestampAction.class);

    /**
     * 현재 시간 정보를 IntelliJ 팝업으로 사용자에게 보여줍니다.
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        logger.info("타임스탬프 액션!");

        final Project project = e.getProject();
        final Instant now = Instant.now();
        final Icon icon = Messages.getInformationIcon();

        final String contents = "UTC: %s\nKST: %s\nTIMESTAMP: %s".formatted(
                now.toString(),
                now.plus(9, ChronoUnit.HOURS),
                String.valueOf(now.toEpochMilli())
        );
        Messages.showMessageDialog(project, contents, "타이틀: 현재 시간 보기", icon);
    }
}
