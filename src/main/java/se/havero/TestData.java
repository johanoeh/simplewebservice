/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.havero;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan
 */
public class TestData {

    public static final  List<User> USERS = new ArrayList<User>() {
        {
            add(new User(1L, "John", "s3cret"));
            add(new User(2L, "Jack", "n01s3cret"));
            add(new User(3L, "Johnny", "password"));
            add(new User(4L, "Jackie", "salvation"));
            add(new User(5L, "Ronny", "saviours"));
        }
    };

}
