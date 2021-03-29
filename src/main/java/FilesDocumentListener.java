import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManagerListener;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FilesDocumentListener implements BulkFileListener {

    private static final String groupId = "Modeline";

//    @Override
//    public void after(@NotNull List<? extends VFileEvent> events) {
//        for (VFileEvent event : events) {
//            VirtualFile file = event.getFile();
//
//
//            if (file == null) {
//                continue;
//            }
//
//            for (Project project : ProjectManager.getInstance().getOpenProjects()) {
//                if (ProjectRootManager.getInstance(project).getFileIndex().isInContent(file)) {
//
//                }
//            }
//        }
//        ProjectRootManager.getInstance()
//        Notifications.Bus.notify(new Notification(groupId, "after", events.get(0).getFile().getName(), NotificationType.INFORMATION));
//    }

//    @Override
//    public void fileContentReloaded(@NotNull VirtualFile file, @NotNull Document document) {
//        Notifications.Bus.notify(new Notification(groupId, "Opened", file.getName(), NotificationType.INFORMATION));
//    }
//
//    @Override
//    public void beforeFileContentReload(@NotNull VirtualFile file, @NotNull Document document) {
//        Notifications.Bus.notify(new Notification(groupId, "Opened", file.getName(), NotificationType.INFORMATION));
//
//    }


}
