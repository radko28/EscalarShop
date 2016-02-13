import org.hibernate.Session;

import sk.cyklosoft.eshop.domain.CategoryType;
import sk.cyklosoft.eshop.domain.Product;
import sk.cyklosoft.eshop.domain.ProductCategory;
import sk.cyklosoft.eshop.domain.RecommendedType;


public class Test {

    public static void main(String[] args) {
        Test mgr = new Test();

        mgr.createAndStoreEvent();

        Util.getSessionFactory().close();
    }

    private void createAndStoreEvent() {
        Session session = Util.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // CategoryType.HOMBRE
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setCategoryType(CategoryType.HOMBRE);
        productCategory2.setName(CategoryType.HOMBRE.toString());

        session.save(productCategory2);


        Product product = new Product();
        product.setName("Dakota");
        product.setEnabled(true);
        product.setWeight(123);
/*        product.setPhoto("photo");
        product.setDetailPhoto("detailPhoto");
*/        product.setRecomended(RecommendedType.ESCALAR);
  //      product.setColours(2);
        product.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product.setDescription("description");
        product.setFeatures("features");
        product.setPrice(42.45F);

        product.setProductCategory(productCategory2);

        session.save(product);

        Product product2 = new Product();
        product2.setName("Bulnes");
        product2.setEnabled(true);
        product2.setWeight(123);
/*        product2.setPhoto("photo");
        product2.setDetailPhoto("detailPhoto");
*/        product2.setRecomended(RecommendedType.ESCALAR);
    //    product2.setColours(2);
        product2.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product2.setDescription("description");
        product2.setFeatures("features");
        product2.setPrice(72.45F);

        product2.setProductCategory(productCategory2);

        session.save(product2);

        Product product3 = new Product();
        product3.setName("Thaya");
        product3.setEnabled(true);
        product3.setWeight(123);
/*        product3.setPhoto("photo");
        product3.setDetailPhoto("detailPhoto");
*/        product3.setRecomended(RecommendedType.ESCALAR);
      //  product3.setColours(2);
        product3.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product3.setDescription("description");
        product3.setFeatures("features");
        product3.setPrice(23.45F);

        product3.setProductCategory(productCategory2);


        session.save(product3);


        // CategoryType.COLCHONETAS
        ProductCategory productCategory3 = new ProductCategory();
        productCategory3.setCategoryType(CategoryType.COLCHONETAS);
        productCategory3.setName(CategoryType.COLCHONETAS.toString());

        session.save(productCategory3);

        Product product4 = new Product();
        product4.setName("CRASH_PAD_VEIDER_5.0");
        product4.setEnabled(true);
        product4.setWeight(123);
/*        product4.setPhoto("photo");
        product4.setDetailPhoto("detailPhoto");
*/        product4.setRecomended(RecommendedType.ESCALAR);
       // product4.setColours(2);
        product4.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product4.setDescription("description");
        product4.setFeatures("features");

        product4.setProductCategory(productCategory3);
        session.save(product4);

        // CategoryType.COMPLEMENTOS
        ProductCategory productCategory4 = new ProductCategory();
        productCategory4.setCategoryType(CategoryType.COMPLEMENTOS);
        productCategory4.setName(CategoryType.COMPLEMENTOS.toString());

        session.save(productCategory4);

        Product product5 = new Product();
        product5.setName("MARGALEF");
        product5.setEnabled(true);
        product5.setWeight(123);
/*        product5.setPhoto("photo");
        product5.setDetailPhoto("detailPhoto");
*/        product5.setRecomended(RecommendedType.ESCALAR);
        product5.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product5.setDescription("description");
        product5.setFeatures("features");
        product5.setPrice(45.67F);

        product5.setProductCategory(productCategory4);


        session.save(product5);


        Product product6 = new Product();
        product6.setName("ZETA");
        product6.setEnabled(true);
        product6.setWeight(123);
/*        product6.setPhoto("photo");
        product6.setDetailPhoto("detailPhoto");
*/        product6.setRecomended(RecommendedType.ESCALAR);
        product6.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product6.setDescription("description");
        product6.setFeatures("features");
        product6.setPrice(23.87F);
        
        product6.setProductCategory(productCategory4);


        session.save(product6);

        Product product10 = new Product();
        product10.setName("STORM");
        product10.setEnabled(true);
        product10.setWeight(123);
/*        product10.setPhoto("photo");
        product10.setDetailPhoto("detailPhoto");
*/        product10.setRecomended(RecommendedType.ESCALAR);
        product10.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product10.setDescription("description");
        product10.setFeatures("features");
        product10.setPrice(90.23F);

        product10.setProductCategory(productCategory4);


        session.save(product10);


        // CategoryType.MOCHILAS
        ProductCategory productCategory5 = new ProductCategory();
        productCategory5.setCategoryType(CategoryType.MOCHILAS);
        productCategory5.setName(CategoryType.MOCHILAS.toString());

        session.save(productCategory5);

        Product product7 = new Product();
        product7.setName("TX 20");
        product7.setEnabled(true);
        product7.setWeight(123);
/*        product7.setPhoto("photo");
        product7.setDetailPhoto("detailPhoto");
*/        product7.setRecomended(RecommendedType.ESCALAR);
        product7.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product7.setDescription("description");
        product7.setFeatures("features");
        product7.setPrice(67.78F);

        product7.setProductCategory(productCategory5);


        session.save(product7);

        Product product8 = new Product();
        product8.setName("EXPEDICION 45");
        product8.setEnabled(true);
        product8.setWeight(123);
/*        product8.setPhoto("photo");
        product8.setDetailPhoto("detailPhoto");
*/        product8.setRecomended(RecommendedType.ESCALAR);
       // product8.setColours(2);
        product8.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product8.setDescription("description");
        product8.setFeatures("features");
        product8.setPrice(65.45F);

        product8.setProductCategory(productCategory5);


        session.save(product8);

        // CategoryType.MUJER
        ProductCategory productCategory6 = new ProductCategory();
        productCategory6.setCategoryType(CategoryType.MUJER);
        productCategory6.setName(CategoryType.MUJER.toString());

        session.save(productCategory6);

        Product product9 = new Product();
        product9.setName("FIT");
        product9.setEnabled(true);
        product9.setWeight(123);
/*        product9.setPhoto("photo");
        product9.setDetailPhoto("detailPhoto");
*/        product9.setRecomended(RecommendedType.ESCALAR);
      //  product9.setColours(2);
        product9.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product9.setDescription("description");
        product9.setFeatures("features");
        product9.setPrice(45.23F);

        product9.setProductCategory(productCategory6);


        session.save(product9);

        Product product11 = new Product();
        product11.setName("NARA");
        product11.setEnabled(true);
        product11.setWeight(123);
/*        product11.setPhoto("photo");
        product11.setDetailPhoto("detailPhoto");
*/        product11.setRecomended(RecommendedType.ESCALAR);
     //  product11.setColours(2);
        product11.setAbout("Versión en cuarenta y cinco litros del petate EXPEDICIÓN 120.");
        product11.setDescription("description");
        product11.setFeatures("features");
        product11.setPrice(10.23F);

        product11.setProductCategory(productCategory6);


        session.save(product11);


        session.getTransaction().commit();
    }
}
