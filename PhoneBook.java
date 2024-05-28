
import java.io.*;
import java.util.*;

public class PhoneBook {
    private List<PhoneEntry> phoneEntries;

    public PhoneBook() {
        phoneEntries = new ArrayList<>();
    }
    public PhoneBook(List<PhoneEntry> initialContent) {
        phoneEntries = initialContent;
    }
    public void readAndSave(String pathIn, String pathOut) throws PhoneAppException{
        validatePath(pathIn, "pathIn");
        validatePath(pathOut, "pathOut");

        BufferedReader inputReader = getInputReader(pathIn);
        phoneEntries = readPhoneEntries(inputReader);
        sort(phoneEntries);
        countOccurencies(phoneEntries);

        FileWriter outWriter = getOutputWriter(pathOut);
        if (outWriter != null) {
            try {
                save(outWriter, phoneEntries);
            } finally {
                try {
                    outWriter.close();
                }catch(IOException ioe) {
                    throw new PhoneAppException("Cannot close "+ pathOut +" stream.", ioe);
                }
            }
        }
    }

    public void print(PrintStream pstream) {
        if (phoneEntries != null) {
            for (PhoneEntry entry : phoneEntries) {
                pstream.println(entry);
            }
        }
    }

    protected BufferedReader getInputReader(String path_in) throws PhoneAppException {
        BufferedReader inputReader;
        try {
            inputReader = new BufferedReader(new FileReader(path_in));
        }catch (IOException ioe) {
            throw new PhoneAppException("File "+ path_in +" cannot be read. ", ioe);
        }
        return inputReader;
    }

    protected FileWriter getOutputWriter(String path) throws PhoneAppException{
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(path);
        } catch (IOException e) {
            throw new PhoneAppException("File "+ path +" cannot be created. ", e);
        }
        return myWriter;
    }

    protected void validatePath(String param, String paramName) throws PhoneAppException{
        if (param == null || param.trim().isEmpty()) {
            throw new PhoneAppException("Missing "+paramName);
        }
    }

    protected List<PhoneEntry> readPhoneEntries(BufferedReader inputReader ) throws PhoneAppException{
        List<PhoneEntry> list = new ArrayList<>();
        String line;
        try{
            while( (line=inputReader.readLine()) != null ) {
                PhoneEntry entry = parseOneLine(line);
                list.add(entry);
            }
        } catch (IOException e) {
            throw new PhoneAppException("Cannot read input file. ", e);
        }
        return list;
    }

    protected PhoneEntry parseOneLine(String line) {
        if(line == null) {
            return null;
        }
        line = line.trim();
        String[] chunks = line.split("\\s+");
        String s1 = (chunks.length > 0) ? chunks[0] : null;
        String s2 = (chunks.length > 1) ? chunks[1] : null;
        String s3 = (chunks.length > 2) ? chunks[2] : null;
        String s4 = (chunks.length > 3) ? chunks[3] : null;
        PhoneEntry entry = new PhoneEntry(s1, s2, s3, s4);
        return entry;
    }
    protected void sort( List<PhoneEntry> entries) {
        Collections.sort(entries, new PhoneBookComparator());
    }
    protected void countOccurencies( List<PhoneEntry> entries) {
        Map<String, Integer> counts = new HashMap<>();
        for(PhoneEntry entry: entries) {
            counts.put(entry.getPhone(), 1 + counts.getOrDefault(entry.getPhone(), 0));
        }
        for(PhoneEntry entry: entries) {
            if(counts.get(entry.getPhone()) > 1 ) {
                entry.setMultiple(true);
            }
        }
    }
    protected void save(Writer outWriter, List<PhoneEntry> entries) throws PhoneAppException{
        if (outWriter == null) {
            throw new PhoneAppException("Missing FileWriter parameter");
        }
        if (entries == null || entries.isEmpty()) {
            throw new PhoneAppException("Nothing to save");
        }
        String lastString = null;
        try {
            for (PhoneEntry entry : entries) {
                lastString = entry.outputString();
                outWriter.write(lastString);
                outWriter.write(System.lineSeparator());
            }
        }catch(IOException ioe) {
            throw new PhoneAppException("Cannot save string: "+lastString);
        }
    }

}
