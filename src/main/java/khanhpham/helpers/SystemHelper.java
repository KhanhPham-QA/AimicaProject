package khanhpham.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SystemHelper {

    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }


    public static boolean createFolder(String path) {
        try {
            File folder = new File(path);

            // Kiểm tra xem đã tồn tại và có phải là folder không
            if (folder.exists() && folder.isDirectory()) {
                System.out.println("Folder đã tồn tại: " + path);
                return false;
            }

            // Tạo folder và các thư mục cha
            boolean created = folder.mkdirs();

            if (created) {
                System.out.println("Tạo folder thành công: " + path);
            } else {
                System.out.println("Tạo folder thất bại: " + path);
            }

            return created;
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo folder: " + e.getMessage());
            return false;
        }
    }

    public static ArrayList<String> splitString(String str, String valueSplit) {
        ArrayList<String> arrayListString = new ArrayList<>();
        for (String s : str.split(valueSplit, 0)) {
            arrayListString.add(s);
        }
        return arrayListString;
    }

    // kiểm tra xem trong chuỗi có các giá trị gì
    public static boolean checkValueInListString(String expected, String listValues[]) {
        boolean found = false;

        for (String s : listValues) {
            if (s.equals(expected)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean checkValueInListString(String expected, List<String> listValues) {
        boolean found = false;

        for (String s : listValues) {
            if (s.equals(expected)) {
                found = true;
                break;
            }
        }
        return found;
    }


    public static boolean checkTextContain (String text, String[] listText){
        String trimText = text.trim();
        for (int i = 0; i < listText.length; i++){
            if (listText[i].contains(trimText)){
                return true;
            }
        }
        return false;
    }
}
