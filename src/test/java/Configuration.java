import org.hibernate.Session;

import sk.cyklosoft.eshop.domain.ColorType;
import sk.cyklosoft.eshop.domain.SizeType;



public class Configuration {

    public static void main(String[] args) {
        Configuration c = new Configuration();

        c.createColors();

        Util.getSessionFactory().close();

    }

    private void createColors() {
        Session session = Util.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        ColorType colorType = new ColorType();
        colorType.setCode("#000000");
        colorType.setName("White");
        session.save(colorType);
        
        ColorType colorType2 = new ColorType();
        colorType2.setCode("#f0f0f0");
        colorType2.setName("Yellow");
        session.save(colorType2);
        
        ColorType colorType3 = new ColorType();
        colorType3.setCode("#f000f0");
        colorType3.setName("Blue");
        session.save(colorType3);

        ColorType colorType4 = new ColorType();
        colorType4.setCode("#ffffff");
        colorType4.setName("Black");
        session.save(colorType4);
        
//size
        SizeType sizeType = new SizeType();
        sizeType.setValue("S");
        session.save(sizeType);
        
        SizeType sizeType2 = new SizeType();
        sizeType2.setValue("M");
        session.save(sizeType2);
        
        SizeType sizeType3 = new SizeType();
        sizeType3.setValue("L");
        session.save(sizeType3);

        SizeType sizeType4 = new SizeType();
        sizeType4.setValue("XL");
        session.save(sizeType4);

        SizeType sizeType5 = new SizeType();
        sizeType5.setValue("XXL");
        session.save(sizeType5);
        

        
        session.getTransaction().commit();

        
    }

}
