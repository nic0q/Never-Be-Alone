package com.example.fingeso.repositories;

import com.example.fingeso.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class RolRepositoryImp implements RolRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countRoles() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM rol").executeScalar(Integer.class);
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
    public List<Rol> getAllRoles() {
        final String query = "select * from rol";
        final List<Rol> rolTotal;
        Connection conn = sql2o.open();
        try (conn) {
            rolTotal = conn.createQuery(query).executeAndFetch(Rol.class);
            return rolTotal;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            conn.close();
        }
    }
}
