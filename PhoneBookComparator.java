
import java.util.Comparator;
public class PhoneBookComparator implements Comparator<PhoneEntry> {
    @Override
    public int compare(PhoneEntry o1, PhoneEntry o2) {
        int result = strCompare(o1.getName(), o2.getName());
        if (result == 0) {
            result = strCompare(o1.getSurname(), o2.getSurname());
            if (result == 0) {
                result = strCompare(o1.getType(), o2.getType());
            }
        }
        return result;
    }

    int strCompare(String s1, String s2) {
        if (s1 == null) {
            return s2 == null ? 0 : -1;
        }
        if(s2 == null) {
            return 1;
        }
        return s1.compareTo(s2);
    }
}
