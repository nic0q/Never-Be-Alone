package com.example.fingeso.repositories;

import com.example.fingeso.models.Estado;
import com.example.fingeso.models.Estamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
@Repository
public class EstadoRepositoryImp implements EstadoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstados() {
        Integer total = 0;
        Connection conn = sql2o.open();
        try( conn ){
            total = conn.createQuery( "SELECT COUNT(*) FROM estado").executeScalar(Integer.class);
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
    public List<Estado> getById(Integer id){
        final String query = "SELECT * FROM estado WHERE id_estado = '" + id + "'";
        final List<Estado> usersRol;
        Connection conn = sql2o.open();
        try( conn ){
            usersRol = conn.createQuery(query).executeAndFetch(Estado.class);
            return usersRol;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            conn.close();
        }
    }
}
