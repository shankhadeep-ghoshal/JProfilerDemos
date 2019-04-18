package profile;

import java.util.ArrayList;

public class ProfileArrayListCreation {
    private static final String STRING_CONSTANT_FRONT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String STRING_CONSTANT_BACK = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ARRAY_SIZE = 10000;

    private static ArrayList<String> withSize(int size) {
        return new ArrayList<String>(size) {{
            for (int i = 0 ; i < ARRAY_SIZE; i++) {
                add(STRING_CONSTANT_BACK);
            }
        }};
    }

    private static ArrayList<String> withoutSize(int size) {
        return new ArrayList<String>() {{
            for (int i = 0 ; i < size; i++) {
                add(STRING_CONSTANT_FRONT);
            }
        }};
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> sized = withSize(ARRAY_SIZE);
        ArrayList<String> withoutSized = withoutSize(ARRAY_SIZE);

        Thread.sleep(10000);
    }
}