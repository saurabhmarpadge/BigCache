package com.store.bookservice.contant;

public class BookConstant {
    private BookConstant(){}
    public static final String BOOK_KEY = "'BookInCache'+#param.isbn+#param.title+#param.subtitle+#param.author+#param.published+#param.updated+#param.publisher+#param.pages+#param.description+#param.website";
}
