import org.hibernate.Session;
import org.joda.time.DateTime;

import sk.cyklosoft.eshop.domain.Authority;
import sk.cyklosoft.eshop.domain.RoleType;
import sk.cyklosoft.eshop.domain.User;

public class CreateUsers {

    public static void main(String[] args) {

        CreateUsers cr = new CreateUsers();

        cr.create();

        Util.getSessionFactory().close();

    }

    private void create() {
        Session session = Util.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        DateTime created = new DateTime();

//admin
        User admin = new User();
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEnabled(true);
        
        admin.setCreated(created);


        session.save(admin);


        Authority authAdmin = new Authority();
        authAdmin.setAuthority(RoleType.ROLE_ADMIN);
        authAdmin.setUsername(admin.getUsername());
        authAdmin.setUsers(admin);
        session.save(authAdmin);

        //user
        User user = new User();

        user.setFirstname("user");
        user.setLastname("user");
        user.setUsername("user");
        user.setPassword("user");
        user.setEnabled(true);

        user.setCreated(created);


        session.save(user);

        Authority auth = new Authority();
        auth.setAuthority(RoleType.ROLE_USER);
        auth.setUsername(user.getUsername());
        auth.setUsers(user);
        session.save(auth);
//user2
        User user2 = new User();

        user2.setFirstname("user");
        user2.setLastname("user");
        user2.setUsername("user2");
        user2.setPassword("user");
        user2.setEnabled(true);

        user2.setCreated(created);



        session.save(user2);

        Authority auth2 = new Authority();
        auth2.setAuthority(RoleType.ROLE_USER);
        auth2.setUsername(user2.getUsername());
        auth2.setUsers(user2);
        session.save(auth2);
        
//user3
        User user3 = new User();

        user3.setFirstname("user");
        user3.setLastname("user");
        user3.setUsername("user3");
        user3.setPassword("user");
        user3.setEnabled(true);

        user3.setCreated(created);


        session.save(user3);

        Authority auth3 = new Authority();
        auth3.setAuthority(RoleType.ROLE_USER);
        auth3.setUsername(user3.getUsername());
        auth3.setUsers(user3);
        session.save(auth3);
        
//user4        
        User user4 = new User();

        user4.setFirstname("user");
        user4.setLastname("user");
        user4.setUsername("user4");
        user4.setPassword("user");
        user4.setEnabled(true);

        user4.setCreated(created);


        session.save(user4);

        Authority auth4 = new Authority();
        auth4.setAuthority(RoleType.ROLE_USER);
        auth4.setUsername(user4.getUsername());
        auth4.setUsers(user4);
        session.save(auth4);

        session.getTransaction().commit();

    }

}
