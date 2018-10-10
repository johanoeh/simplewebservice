
package se.havero;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author johan
 */
@XmlRootElement(name = "user")
@Entity
@Table
@NamedQueries({
    @NamedQuery(name=User.USER_ALL, query="select u from User u")
})
public class User implements Serializable {
    
    public static final String USER_ALL ="user.all";

    //important to have a no arg constructor
    public User(){
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String passWord;

    /**
     *
     * @param id
     * @param userName
     * @param password
     */
    public User(long id, String userName, String password) {
        
        this.id = id;
        this.userName = userName;
        this.passWord = password;
    }

    public long getId() {
        return id;
    }
    
    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    @XmlElement
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    @XmlElement
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User [ id="+id+", userName=" + userName + ", password=" + passWord + "]";
    }

}
