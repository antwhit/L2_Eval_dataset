import org.jmol.applet.JmolAppletRegistry;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JmolSwingSliderControl extends JApplet implements ChangeListener {

    String myName;

    JmolAppletRegistry appletRegistry;

    String targetName;

    String label;

    String script;

    JSlider swingSlider;

    public void init() {
        myName = getParameterOrNull("name");
        appletRegistry = new JmolAppletRegistry(myName, false, this);
        targetName = getParameterOrNull("target");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(new JLabel("spacefill percentage", SwingConstants.CENTER), BorderLayout.NORTH);
        swingSlider = new JSlider(0, 100);
        swingSlider.addChangeListener(this);
        swingSlider.setMajorTickSpacing(25);
        swingSlider.setMinorTickSpacing(5);
        swingSlider.setPaintTicks(true);
        swingSlider.setPaintLabels(true);
        panel.add(swingSlider, BorderLayout.CENTER);
        getContentPane().add(panel);
    }

    private String getParameterOrNull(String paramName) {
        String value = getParameter(paramName);
        if (value != null && value.length() == 0) value = null;
        return value;
    }

    public void stateChanged(ChangeEvent e) {
        appletRegistry.script(targetName, "spacefill " + swingSlider.getValue() + "%");
    }
}
