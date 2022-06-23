package com.example.fingeso.repositories;

import com.example.fingeso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countUsers(){
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM USER").executeScalar(Integer.class);
            return total;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            conn.close();
        }
    }

    @Override
    public List<User> getAllUsers(){
        final String query = "select * from users";
        final List<User> diplomas;
        Connection conn = sql2o.open();
        try( conn ){
            diplomas = conn.createQuery(query).executeAndFetch(User.class);
            return diplomas;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
}
