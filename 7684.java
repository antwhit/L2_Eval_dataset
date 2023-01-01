import java.awt.*;
import java.applet.Applet;

class CardPanel extends Panel {

    Panel create(LayoutManager layout) {
        Panel p = new Panel();
        p.setLayout(layout);
        p.add("North", new Button("one"));
        p.add("West", new Button("two"));
        p.add("South", new Button("three"));
        p.add("East", new Button("four"));
        p.add("Center", new Button("five"));
        return p;
    }

    CardPanel() {
        setLayout(new CardLayout());
        add("one", create(new FlowLayout()));
        add("two", create(new BorderLayout()));
        add("three", create(new GridLayout(2, 2)));
        add("four", create(new BorderLayout(10, 10)));
        add("five", create(new FlowLayout(FlowLayout.LEFT, 10, 10)));
        add("six", create(new GridLayout(2, 2, 10, 10)));
    }

    public Dimension preferredSize() {
        return new Dimension(200, 100);
    }
}

public class CardTest extends Applet {

    CardPanel cards;

    public CardTest() {
        setLayout(new BorderLayout());
        add("Center", cards = new CardPanel());
        Panel p = new Panel();
        p.setLayout(new FlowLayout());
        add("South", p);
        p.add(new Button("first"));
        p.add(new Button("next"));
        p.add(new Button("previous"));
        p.add(new Button("last"));
        Choice c = new Choice();
        c.addItem("one");
        c.addItem("two");
        c.addItem("three");
        c.addItem("four");
        c.addItem("five");
        p.add(c);
    }

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice) {
            ((CardLayout) cards.getLayout()).show(cards, (String) arg);
        } else {
            if ("first".equals(arg)) {
                ((CardLayout) cards.getLayout()).first(cards);
            } else if ("next".equals(arg)) {
                ((CardLayout) cards.getLayout()).next(cards);
            } else if ("previous".equals(arg)) {
                ((CardLayout) cards.getLayout()).previous(cards);
            } else if ("last".equals(arg)) {
                ((CardLayout) cards.getLayout()).last(cards);
            } else {
                ((CardLayout) cards.getLayout()).show(cards, (String) arg);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Frame f = new Frame("CardTest");
        CardTest cardTest = new CardTest();
        cardTest.init();
        cardTest.start();
        f.add("Center", cardTest);
        f.resize(300, 300);
        f.show();
    }
}
