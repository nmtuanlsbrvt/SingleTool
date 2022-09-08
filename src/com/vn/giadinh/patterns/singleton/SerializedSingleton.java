package com.vn.giadinh.patterns.singleton;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {
    //Hook đặc biệt được cung cấp bởi tuần tự hóa nơi nhà phát triển có thể kiểm soát đối tượng nào cần gửi.
    //Tuy nhiên, phương thức này được gọi trên phiên bản đối tượng mới được tạo bởi quá trình tuần tự hóa.
    private static final long serialVersionUID = 1741825395699241705L;
 
    private SerializedSingleton() {
    }
 
    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }
 
    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
}
