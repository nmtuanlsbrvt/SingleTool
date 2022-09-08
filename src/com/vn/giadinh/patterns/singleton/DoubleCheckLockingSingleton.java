package com.vn.giadinh.patterns.singleton;

public class DoubleCheckLockingSingleton {
    private static volatile DoubleCheckLockingSingleton instance;
 
    private DoubleCheckLockingSingleton() {
    }
 
    public static DoubleCheckLockingSingleton getInstance() {
        // Làm điều gì đó trước khi nhận được ví dụ ...
        if (instance == null) {
            // Thực hiện tác vụ quá lâu trước khi tạo phiên bản ...
            // Chặn để các luồng khác không thể đi vào trong khi khởi tạo
            synchronized (DoubleCheckLockingSingleton.class) {
                // Kiểm tra lại một lần nữa. Có thể một chủ đề khác đã khởi tạo trước đây
                if (instance == null) {
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }
        // Làm điều gì đó sau khi nhận được ví dụ ...
        return instance;
    }
}
