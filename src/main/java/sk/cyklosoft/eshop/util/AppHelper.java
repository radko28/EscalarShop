package sk.cyklosoft.eshop.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import sk.cyklosoft.eshop.domain.RoleType;


/**
 * AppHelper contains project static properties and static functions
 * 
 * @author radoslav.kuzma
 * 
 */
public class AppHelper {

    /** Device, Computer and CellPhone create form submit button value */
    public static String FROM_ADD = "Save";
    /** Device edit form submit button value */
    public static String FROM_EDIT = "Update";
    /** Computer and CellPhone create form cancel button name */
    public static String BUTTON_STORNO = "_cancel";
    /** string array of user roles */
    private static String[] userRoles = { RoleType.ROLE_USER.toString() };
    /** string array of user roles */
    private static String[] adminRoles = { RoleType.ROLE_ADMIN.toString() };
    /** User birthday date format */
    public static String DATE_FORMAT = "dd.MM.yyyy";

    /**
     * Returns whether authenticated user belongs to authority group
     * 
     * @param roles
     *            list of authority roles
     * @return true if authenticated user authority belongs to parameter roles
     */

    public static boolean hasRole(String[] roles) {
        boolean result = false;
        for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            String userRole = authority.getAuthority();
            for (String role : roles) {
                if (role.equals(userRole)) {
                    result = true;
                    break;
                }
            }

            if (result) {
                break;
            }
        }

        return result;
    }

    /**
     * Returns whether authenticated user belongs to administrator roles
     * 
     * @return true if authenticated user has administrator role, else false
     */
    public static boolean hasAdminRole() {
        return hasRole(adminRoles);
    }

    /**
     * Returns whether authenticated user belongs to user roles
     * 
     * @return true if authenticated user has user role, else false
     */
    public static boolean hasUserRole() {
        return hasRole(userRoles);
    }

    /**
     * users/manageComputer.jsp page computer type map
     * 
     * @return types of computer and description map
     */
    /*
     * public static Map<String, String> getComputerTypeMap() { Map<String, String> computerTypeMap = new LinkedHashMap<String, String>();
     * computerTypeMap.put(ComputerType.NOTEBOOK.toString(), "Notebook"); computerTypeMap.put(ComputerType.PC.toString(), "PC"); return
     * computerTypeMap; }
     */
    /**
     * Gets project pages header login bar parameter
     * 
     * @return authenticated user username
     */
    public static String getUsername() {
        org.springframework.security.core.userdetails.User userPrincipal = (org.springframework.security.core.userdetails.User)SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        
        
        return userPrincipal.getUsername();
    }
    
    public static void logout() {
        SecurityContextHolder.clearContext();
        //initAnonymous();
    }
    
    public static void initUser(String username, String role) {
        AnonymousAuthenticationToken auth = new AnonymousAuthenticationToken(username, username, AuthorityUtils.createAuthorityList(role));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}

    
   



