import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.fileEditor.FileEditorProvider
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Pair
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.JBColor
import com.intellij.ui.components.JBLabel
import java.awt.BorderLayout
import javax.swing.JPanel

class FileOpenListener(project: Project) : FileEditorManagerListener {

    private var _manager: FileEditorManager = FileEditorManager.getInstance(project)

    override fun fileOpenedSync(source: FileEditorManager, file: VirtualFile, editors: Pair<Array<FileEditor>, Array<FileEditorProvider>>) {
        val filenameLabel = JBLabel(file.name)
        val modeline = JPanel(BorderLayout())
        modeline.background = JBColor.LIGHT_GRAY
        modeline.add(filenameLabel)
        val fileEditor = source.getSelectedEditor(file)
        if (fileEditor != null) {
            _manager.addBottomComponent(fileEditor, modeline)
        }
    }
}