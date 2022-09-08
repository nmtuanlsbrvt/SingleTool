package com.vn.giadinh.patterns.singleton;

public class StaticBlockSingleton {
    private static final StaticBlockSingleton INSTANCE;
 
    private StaticBlockSingleton() {
    }
 
    // Khởi tạo khối tĩnh để xử lý ngoại lệ
    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Ngoại lệ đã xảy ra trong việc tạo phiên bản singleton");
        }
    }
 
    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }
}
    
