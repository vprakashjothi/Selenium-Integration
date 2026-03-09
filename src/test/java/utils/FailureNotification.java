package utils;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.awt.AWTException;
import java.awt.Image;


public class FailureNotification {
	static SystemTray tray;
	static TrayIcon trayIcon;
	public static void NotificationPush(String TestCaseID,String TestCaseDesc) throws Exception {
	
	if (!SystemTray.isSupported()) {
        System.out.println("System tray not supported!");
        return;
    }

    tray = SystemTray.getSystemTray();

    // Create a dummy image (required for TrayIcon)
    Image image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

    TrayIcon trayIcon = new TrayIcon(image, "Failure Notification");
    trayIcon.setImageAutoSize(true);
    trayIcon.setToolTip("Selenium Test Failure Notification");

    tray.add(trayIcon);

    // Display notification
    trayIcon.displayMessage(
            TestCaseID,
            TestCaseDesc,
            TrayIcon.MessageType.INFO
    );
    Thread.sleep(5000);
    
	}
	
	public static void removeNotification() {
	    tray.remove(trayIcon);

	}
	
}
