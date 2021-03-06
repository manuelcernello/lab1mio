package org.studyroom.control.utilities;


import org.securityfilter.realm.SimpleSecurityRealmBase;
import org.studyroom.control.dao.UserDAO;

/**
 * Trivial implementation of the SecurityRealmInterface.
 * <p/>
 * There is one user: username is 'username', password is 'password'
 * And this user is in one role: 'inthisrole'
 *
 * @author Max Cooper (max@maxcooper.com)
 * @version $Revision: 1.3 $ $Date: 2003/10/25 10:49:04 $
 */
public class LoginRealm extends SimpleSecurityRealmBase {

    /**
     * Authenticate a user.
     * <p/>
     * Implement this method in a subclass to avoid dealing with Principal objects.
     *
     * @param username a username
     * @param password a plain text password, as entered by the user
     * @return null if the user cannot be authenticated, otherwise a Principal object is returned
     */
    public boolean booleanAuthenticate(String username, String password) {
        return UserDAO.getInstance().exists(HibernateUtil.getGuestSession(), username) &&
                UserDAO.getInstance().getUser(HibernateUtil.getGuestSession(), username).getPassword().equals(password);
    }

    public boolean isUserInRole(String username, String rolename) {
        return true;
    }
}

