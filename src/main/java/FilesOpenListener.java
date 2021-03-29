import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class FilesOpenListener implements FileEditorManagerListener {

    private static final String groupId = "Modeline";

    private final Project _project;

    public FilesOpenListener(@NotNull Project project) {
        _project = project;
    }

    @Override
    public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
        FileEditorManager.getInstance(_project).addBottomComponent(source.getSelectedEditor(), new JLabel(file.getName()));
    }
}
