package com.example.fingeso.repositories;

import com.example.fingeso.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class EstadoRepositoryImp implements EstadoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstados() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM estamento").executeScalar(Integer.class);
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
    public List<Estado> getAllEstados() {
        final String query = "select * from estado";
        final List<Estado> estadoTotal;
        Connection conn = sql2o.open();
        try( conn ){
            estadoTotal = conn.createQuery(query).executeAndFetch(Estado.class);
            return estadoTotal ;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
}
