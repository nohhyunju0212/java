package domain;

import service.Categoriesoffical;
import util.ReadIt;

public class Ecommerce {
    public static void main(String[] args) {

        ReadIt.createcategories();
        ReadIt.create();

        Categoriesoffical cf = new Categoriesoffical();
        cf.NewCategories();


    }
}
