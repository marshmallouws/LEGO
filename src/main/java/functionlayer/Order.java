/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

/**
 *
 * @author Annika
 */
public class Order {
    private int id;
    private User user;
    private int height;
    private int length;
    private int width;
    
    public Order(User user, int height, int length, int width) {
        this.user = user;
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
