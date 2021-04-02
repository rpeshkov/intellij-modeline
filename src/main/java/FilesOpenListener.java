import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class FilesOpenListener implements FileEditorManagerListener {

    private static final String groupId = "Modeline";

    private final FileEditorManager _manager;

    public FilesOpenListener(@NotNull Project project) {
        _manager = FileEditorManager.getInstance(project);
    }

    @Override
    public void fileOpenedSync(@NotNull FileEditorManager source, @NotNull VirtualFile file, @NotNull Pair<FileEditor[], FileEditorProvider[]> editors) {
        JLabel modeline = new JBLabel(file.getName());
        JPanel myPanel = new JPanel(new BorderLayout());
        myPanel.setBackground(JBColor.LIGHT_GRAY);
        myPanel.add(modeline);
        FileEditor fileEditor = source.getSelectedEditor(file);
        if (fileEditor != null) {
            _manager.addBottomComponent(fileEditor, myPanel);
        }
    }
}
