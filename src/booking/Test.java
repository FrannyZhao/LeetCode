package booking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;


public class Test {


    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        
        for (int i = 0; i < arr.size() - 1; i ++) {
            if (arr.get(i) == k) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = "";
//        while (line != null) {
//            line = br.readLine();
//            System.out.println("output " + line);
//        }
//        Scanner s = new Scanner(System.in);
//        while (s.hasNext()) {
//            System.out.println("output " + s.nextLine());
//        }
        int[] nums = new int[0];
        if (nums.length == 0) {
            throw new IllegalArgumentException("nums is empty");
        }
        System.out.println("end");
    }
    /**
     * import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;

class Seeker {

    public static View findViewById(ViewGroup root, int id) {
        // implement this method only
        if () {
            
        }
    }
}
// don’t edit code below this line

// this code is not editable
//                                               ∆
//                                               |
//                                               |
// please focus on implementing the method above |

class View {
    private ViewGroup parent;
    private String name;
    private int id;

    View(ViewGroup parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public ViewGroup getParent() {
        return parent;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ViewGroup extends View {
    private ArrayList<View> children = new ArrayList<>();

    ViewGroup(ViewGroup parent) {
        super(parent);
    }

    void addChild(View child) {
        children.add(child);
    }

    public int getChildCount() {
        return children.size();
    }
    public View getChildAt(int index) {
        return children.get(index);
    }
}

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int id = Integer.parseInt(line);
        StringBuilder builder = new StringBuilder();

        while ((line = br.readLine()) != null) {
            builder.append(line);
            builder.append(' ');
        }
        View root = Parser.parse(builder.toString());
        View found = Seeker.findViewById((ViewGroup)root, id);
        if (found != null) {
            System.out.println(found.getName());
        } else {
            System.out.println(found);
        }
    }
}

class Parser {
    static View parse(String input) throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SaxHandler saxHandler = new SaxHandler();
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        saxParser.parse(is, saxHandler);

        return saxHandler.getLast();
    }
}

class SaxHandler extends DefaultHandler {

    private View current;
    private View last;

    private boolean bName;
    private boolean bId;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("ViewGroup")) {
            ViewGroup parent = (ViewGroup)current;
            ViewGroup newParent = new ViewGroup(parent);
            if (parent != null) {
                parent.addChild(newParent);
            }
            current = newParent;
        } else if (qName.equals("View")) {
            ViewGroup parent = (ViewGroup)current;
            View newView = new View(parent);
            parent.addChild(newView);
            current = newView;
        } else if (qName.equals("name")) {
            bName = true;
        } else if (qName.equals("id")) {
            bId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("ViewGroup") ||
                qName.equals("View") ) {
            if (current != null) {
                last = current;
                current = current.getParent();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            current.setName(new String(ch, start, length));
            bName = false;
        } else if (bId) {
            String idString = new String(ch, start, length);
            int id = Integer.parseInt(idString);
            current.setId(id);
            bId = false;
        }
    }

    public View getLast() {
        return last;
    }
}
     */

}
